package WorkWithFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopyFile {
    static int count = 0;


    //работает ок - путь к начальной папкеи указывает на нужный файл.
    public static String getThePathToTheSource (String folder, String nameFile) {
        String path = "C:\\\\Dropbox\\lo\\1\\"+folder+"\\data\\"+nameFile+".rar";
        return  path;
    }

    public static String getThePathToTheSourceY (String folder, String nameFile) {
        String path = "C:\\\\Dropbox\\lo\\2\\"+folder+"\\data\\"+nameFile+".rar";
        return  path;
    }

    //работает ок - путь к конечной папке.
    public static String getThePathToTheReceiver (String nameFile) {
        String path = null;
        path = "C:\\DataForImport\\"+nameFile+"\\";
        return path;
    }

    public static String getThePathToTheReceiverOYY (String folderName, String nameFile) {
        String path = null;
        path = "C:\\.Данные для Импорта\\"+folderName+"\\"+nameFile+"\\";
        return path;
    }

    //работает ок - выводит номер в формате 1 = 001 или 10 = 010
    public static String threeGigitNumber (int number) {
        String s;
        if (number < 10) {
            String a = Integer.toString(number);
            s = "00"+a;
        } else {
            if ((number >= 10) && (number < 100)) {
                s = "0" + Integer.toString(number);
            } else {
                s = Integer.toString(number);
            }

        }
        return s;
    }

    //работает ок - возвращает вчерашнюю дату в формате "ddMMyyyy"
    public static String getYesterdayDateInFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date currentDate = new Date();
        Long time = currentDate.getTime();
        long anotherDate = -1;
        time = time + (60*60*24*1000*anotherDate);
        currentDate = new Date(time);
        sdf.applyPattern("ddMMyyyy");
        String s = sdf.format(currentDate);
        return s;
    }

    public static String getDateInFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d1 = date;
        sdf.applyPattern("ddMMyyyy");
        String s = sdf.format(date);
        return s;
    }


    //работает ок - копирование файлов из их деррикторий в DataForImport
    public static void copyToZDrive(String source, String receiver) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("cmd /c xcopy \"" + source + "\" \"" + receiver +
                "\" /z /y /j /c /q");
        p.waitFor();
    }

    //работает ок - распаковка архивов
    public static void unRarFile(String pathRarFiles, String pathToExtract){
        try {
            Process p = Runtime.getRuntime().exec("cmd /c  \"C:\\Program Files\\WinRAR\\unrar\" x -y "+pathRarFiles+" "+pathToExtract);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
