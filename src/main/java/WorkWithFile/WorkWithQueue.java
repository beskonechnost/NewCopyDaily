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
 * Created by Андрей on 13.12.2017.
 */
public class WorkWithQueue {

    private static final String FILE_NAME ="C:\\mainPawn\\CopyFile\\NumberAndCode";
    private static final String FILE_QUEUE ="C:\\mainPawn\\CopyFile\\queue";
    private static final String FILE_EXE = "C:\\mainPawn\\CopyFile\\Import_data.exe";

    //Записать в очередь информацию о файлах за вчера
    public static List<AllInformation> filesForYesterdayInQueue(){
        List<AllInformation> queue = new ArrayList<AllInformation>();
        List<LO> los = ReadFile.readFile(FILE_NAME);
        String dataInNeededFormatInString = CopyFile.getYesterdayDateInFormat();
        for(LO lo : los){
            queue.add(new AllInformation(lo, dataInNeededFormatInString, "daily_"+lo.getNumberLo()+"_"+lo.getCodeLo()+"_"+dataInNeededFormatInString, false));
        }
        return queue;
    }

    //Копировать и разархивировать файлы в DataForImport и .ДанныеДляИмпорта
    public void unRarFilesInQueue(List<AllInformation> queue){
        for(AllInformation ai : queue){
            CopyFile.unRarFile(CopyFile.getThePathToTheSource(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()),ai.getName()), CopyFile.getThePathToTheReceiver(ai.getName()));
            CopyFile.unRarFile(CopyFile.getThePathToTheSourceY(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()), ai.getName()), CopyFile.getThePathToTheReceiver(ai.getName()));


            CopyFile.unRarFile(CopyFile.getThePathToTheSource(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()),ai.getName()), CopyFile.getThePathToTheReceiverOYY(ai.getDataInNeededFormatInString().substring(2, 4), ai.getName()));
            CopyFile.unRarFile(CopyFile.getThePathToTheSourceY(CopyFile.threeGigitNumber(ai.getLo().getNumberLo()), ai.getName()), CopyFile.getThePathToTheReceiverOYY(ai.getDataInNeededFormatInString().substring(2,4),ai.getName()));
        }
    }

    //Создать лист с именами папок находящихся в DataForImport
    public List<String> FilesInDataForImport(){
        String path = "C:\\DataForImport";
        File dir = new File(path); //path указывает на директорию
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

    //Сравнить содержимое папки с очередью и удалить те папки, которые были перемещены верно
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

    //Записать очередь в файл
    public void WriteQueueInFile(File file, List<AllInformation> queue){
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(writer); //  создаём буферезированный поток
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

    //Запустить exe file-загрузчика
    public void runExe(String fileExeName){
        File file =new File(fileExeName);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void FirstPart (List<AllInformation> queue, Date startDate) {
        //Читать в очередь из файла
        List<AllInformation> read = ReadFile.readFileQueue(FILE_QUEUE);
        queue.addAll(read);
        //переместить в .ДанныеДляИмпорта и DataForImport файлы с данными и разархивировать
        unRarFilesInQueue(queue);
        //Сравнить содержимое папки с очередью
        List<String> namesFoldersInDataForImport = FilesInDataForImport();
        CompareQueueAndFilesInDataForImport(namesFoldersInDataForImport,queue);
        //Записать очередь в файл
        WriteQueueInFile(new File(FILE_QUEUE), queue);
        //очистить лист очереди
        queue.clear();
        //Запустить exe file-загрузчика
        runExe(FILE_EXE);
        //Ждать 15 минту
        try {
            Thread.sleep(60000);//900000 - 15 min
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Удаляем все из DataForImport
        deleteAllFilesFolder(new File("C:\\DataForImport\\"));

            Date nowDate = new Date();
            if (!((nowDate.getTime() - startDate.getTime()) >= 36000000)) {
                //Читать из файла в пустую очередь
                queue = ReadFile.readFileQueue(FILE_QUEUE);
                if (!queue.isEmpty()) {
                    FirstPart(queue, startDate);
                }
            }

    }
}
