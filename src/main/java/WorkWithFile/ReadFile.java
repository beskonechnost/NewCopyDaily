package WorkWithFile;

import Entity.AllInformation;
import Entity.LO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 15.09.2016.
 */
public class ReadFile {

    public static List<LO> readFile(String FILE_NAME) {
        List<LO> ListLO = new ArrayList<LO>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] s = line.split("-");
                ListLO.add(new LO(Integer.parseInt(s[1]),Integer.parseInt(s[0])));
            }
        }catch(IOException e){
                System.out.println("IOException");
            }
        return ListLO;
    }

    public static List<AllInformation> readFileQueue(String FILE_NAME){
        List<AllInformation> listAI = new ArrayList<AllInformation>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
            for(String line : lines){
                String[] s = line.split("-");
                listAI.add(new AllInformation(new LO(Integer.parseInt(s[0]),Integer.parseInt(s[1])),s[2],s[3],Boolean.parseBoolean(s[5])));
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return listAI;
    }
}
