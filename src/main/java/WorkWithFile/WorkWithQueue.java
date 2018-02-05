package WorkWithFile;

import Entity.AllInformation;
import Entity.LO;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ������ on 13.12.2017.
 */
public class WorkWithQueue {

    private static final String FILE_NAME ="C:\\mainPawn\\CopyFile\\NumberAndCode";
    private static final String FILE_QUEUE ="C:\\mainPawn\\CopyFile\\queue";
    private static final String FILE_EXE = "C:\\mainPawn\\CopyFile\\Import_data.exe";

    //�������� � ������� ���������� � ������ �� �����
    public static List<AllInformation> filesForYesterdayInQueue(){
        List<AllInformation> queue = new ArrayList<AllInformation>();
        List<LO> los = ReadFile.readFile(FILE_NAME);
        String dataInNeededFormatInString = CopyFile.getYesterdayDateInFormat();
        for(LO lo : los){
            queue.add(new AllInformation(lo, dataInNeededFormatInString, "daily_"+lo.getNumberLo()+"_"+lo.getCodeLo()+"_"+dataInNeededFormatInString, false));
        }
        return queue;
    }

    //���������� � ��������������� ����� � DataForImport � .����������������
    public void unRarFilesInQueue(List<AllInformation> queue){
        for(AllInformation ai : queue){
            CopyFile.unRarFile(CopyFile.getThePathToTheSource(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()),ai.getName()), CopyFile.getThePathToTheReceiver(ai.getName()));
            CopyFile.unRarFile(CopyFile.getThePathToTheSourceY(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()), ai.getName()), CopyFile.getThePathToTheReceiver(ai.getName()));


            CopyFile.unRarFile(CopyFile.getThePathToTheSource(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()),ai.getName()), CopyFile.getThePathToTheReceiverOYY(ai.getDataInNeededFormatInString().substring(2, 4), ai.getName()));
            CopyFile.unRarFile(CopyFile.getThePathToTheSourceY(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()), ai.getName()), CopyFile.getThePathToTheReceiverOYY(ai.getDataInNeededFormatInString().substring(2,4),ai.getName()));
        }
    }

    //������� ���� � ������� ����� ����������� � DataForImport
    public List<String> FilesInDataForImport(){
        String path = "C:\\DataForImport";
        File dir = new File(path); //path ��������� �� ����������
        File[] arrFiles = dir.listFiles();
        if(arrFiles.length==0){
            List<String> namesFolder = new ArrayList<String>();
            return namesFolder;
        }else{
            List<File> lst = Arrays.asList(arrFiles);
            List<String> namesFolder = new ArrayList<String>();
            for(File f : lst){
                namesFolder.add(f.getName());
            }
            return namesFolder;
        }
    }

    //�������� ���������� ����� � �������� � ������� �� �����, ������� ���� ���������� �����
    public void CompareQueueAndFilesInDataForImport(List<String> namesFolder, List<AllInformation> queue){
        for(String nameFolder : namesFolder){
            for(AllInformation ai : queue){
                if(ai.getName().equals(nameFolder)){
                    ai.setCopyMark(true);
                    AllInformation ai1 = ai;
                    queue.remove(ai1);
                    break;
                }
            }
        }
    }

    //�������� ������� � ����
    public void WriteQueueInFile(File file, List<AllInformation> queue){
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(writer); //  ������ ���������������� �����
            out.write("");
            out.close();
            writer = new FileWriter(file);
            for (AllInformation ai : queue) {
                String line = ai.getLo().getNumberLo() + "-" + ai.getLo().getCodeLo() + "-" + ai.getDataInNeededFormatInString() + "-" + ai.getName() + "-" + ai.getFolderOYY() + "-" + ai.isCopyMark();
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    //delete in folder
    public void deleteAllFilesFolder(File file) {
            if(!file.exists())
                return;
            if(file.isDirectory())
            {
                for(File f : file.listFiles())
                    deleteAllFilesFolder(f);
                file.delete();
            }
            else
            {
                file.delete();
            }
        File folder = new File("C:\\DataForImport");
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    //��������� exe file-����������
    public void runExe(String fileExeName){
        File file =new File(fileExeName);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void FirstPart (List<AllInformation> queue, Date startDate) {
        //������ � ������� �� �����
        List<AllInformation> read = ReadFile.readFileQueue(FILE_QUEUE);
        queue.addAll(read);
        //����������� � .���������������� � DataForImport ����� � ������� � ���������������
        unRarFilesInQueue(queue);
        //�������� ���������� ����� � ��������
        List<String> namesFoldersInDataForImport = FilesInDataForImport();
        CompareQueueAndFilesInDataForImport(namesFoldersInDataForImport,queue);
        //�������� ������� � ����
        WriteQueueInFile(new File(FILE_QUEUE), queue);
        //�������� ���� �������
        queue.clear();
        //��������� exe file-����������
        runExe(FILE_EXE);
        //����� 15 �����
        try {
            Thread.sleep(60000);//900000 - 15 min
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //������� ��� �� DataForImport
        deleteAllFilesFolder(new File("C:\\DataForImport\\"));

            Date nowDate = new Date();
            if (!((nowDate.getTime() - startDate.getTime()) >= 36000000)) {
                //������ �� ����� � ������ �������
                queue = ReadFile.readFileQueue(FILE_QUEUE);
                if (!queue.isEmpty()) {
                    FirstPart(queue, startDate);
                }
            }

    }
}
