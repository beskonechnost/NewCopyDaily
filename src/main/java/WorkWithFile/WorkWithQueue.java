package WorkWithFile;

import Entity.AllInformation;
import Entity.LO;
import Extra.ListMonthsOYY;
import Extra.MonthFormOYY;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ������ on 13.12.2017.
 */
public class WorkWithQueue {

    private static final String FILE_NAME ="C:\\MainPawn\\CopyFile\\NumberAndCode";
    private static final String FILE_QUEUE ="C:\\MainPawn\\CopyFile\\queue";
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

            String folderOYY = null;
            for(MonthFormOYY mon : ListMonthsOYY.getInstance()){
                if(mon.getNumber().equals(ai.getFolderOYY())){
                    folderOYY = mon.getTextMonth();
                }
            }
            CopyFile.unRarFile(CopyFile.getThePathToTheSource(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()),ai.getName()), CopyFile.getThePathToTheReceiverOYY(folderOYY,ai.getName()));
            CopyFile.unRarFile(CopyFile.getThePathToTheSourceY(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()), ai.getName()), CopyFile.getThePathToTheReceiverOYY(folderOYY,ai.getName()));
        }
    }

    //������� ���� � ������� ����� ����������� � DataForImport
    public List<String> FilesInDataForImport(){
        String path = "C:\\DataForImport";
        File dir = new File(path); //path ��������� �� ����������
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        List<String> namesFolder = new ArrayList<String>();
        for(File f : lst){
            namesFolder.add(f.getName());
        }
        return namesFolder;
    }

    //�������� ���������� ����� � �������� � ������� ��� �����, ������� ���� ���������� �����
    public void CompareQueueAndFilesInDataForImport(List<String> namesFolder, List<AllInformation> queue){
        for(AllInformation ai : queue){
            for(String nameFolder : namesFolder){
                if(ai.getName().equals(nameFolder)){
                    ai.setCopyMark(true);
                    break;
                }
            }
        }
        for(AllInformation ai : queue){
            if(ai.isCopyMark()){
                queue.remove(ai);
            }
        }
    }

    //�������� ������� � ����
    public void WriteQueueInFile(File file, List<AllInformation> queue){
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            for (AllInformation ai : queue) {
                String line = ai.getLo().getNumberLo()+"-"+ai.getLo().getCodeLo()+"-"+ai.getDataInNeededFormatInString()+"-"+ai.getName()+"-"+ai.getFolderOYY()+"-"+ai.isCopyMark();
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

    public void deleteAllFilesFolder(String path) {
        for (File myFile : new File(path).listFiles())
            myFile.delete();
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
            wait(900000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //������� ��� �� DataForImport
        deleteAllFilesFolder("C:\\DataForImport\\");

        Date nowDate = new Date();
        if(!((nowDate.getTime()-startDate.getTime())>=36000000)){
            //������ �� ����� � ������ �������
            queue = ReadFile.readFileQueue(FILE_QUEUE);
            if(!queue.isEmpty()){
                FirstPart(queue,startDate);
            }
        }
    }
}
