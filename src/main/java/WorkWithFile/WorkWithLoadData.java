package WorkWithFile;

import InsertInDB.Inserter;
import XMLparser.Parser;
import com.healthmarketscience.jackcess.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Андрей on 31.01.2018.
 */
public class WorkWithLoadData {

    public static final String TABLE_LOAD_DATA = "LoadData";
    public static final String TABLE_FILIALS = "filials";

    public static void addYesterdayOpenPawn(){
        try {
            Database db = DatabaseBuilder.open(new File(Inserter.DB_PATH));

            Table table = db.getTable(TABLE_LOAD_DATA);
            Cursor cursor = CursorBuilder.createCursor(table);
            boolean found = cursor.findFirstRow(Collections.singletonMap("LoadDate", CopyFile.getYesterdayDateInFormatFromDB()));
            if(!found){
                Map<String, Object> filialMap = new TreeMap<>();
                filialMap.put("enabl", true);
                filialMap.put("CloseDate", null);

                Table table1 = db.getTable(TABLE_FILIALS);
                Cursor cursor1 = CursorBuilder.createCursor(table1);
                List<Short> codeEnableList = new ArrayList<>();
                for (Row row : cursor1.newIterable().setMatchPattern(filialMap)) {
                    codeEnableList.add(row.getShort("code_filial"));
                }
                for(Short i : codeEnableList){
                    table.addRow(Column.AUTO_NUMBER, i, CopyFile.getYesterdayDateInFormatFromDB(), 0);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> createDailyNameUnloaded(){
        List<String> dailyNames = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(Inserter.DB_PATH));
            Table tableLD = db.getTable(TABLE_LOAD_DATA);
            Cursor cursorLD = CursorBuilder.createCursor(tableLD);
            for(Row rowLD : cursorLD.newIterable().addMatchPattern("Status", 0)){
                Integer codeFilialLD = rowLD.getInt("CodeFilial");
                String stringDateLD = CopyFile.getDateInFormat(rowLD.getDate("LoadDate"));

                Table tableF = db.getTable(TABLE_FILIALS);
                Cursor cursorF = CursorBuilder.createCursor(tableF);
                Short numberFilialF = 0;
                for(Row rowF : cursorF.newIterable().addMatchPattern("code_filial", codeFilialLD)){
                    numberFilialF = rowF.getShort("number_filial");
                }
                if(codeFilialLD==47 || codeFilialLD==43){
                    dailyNames.add("daily_"+numberFilialF+"_0"+codeFilialLD+"_"+stringDateLD);
                }else {
                    dailyNames.add("daily_"+numberFilialF+"_"+codeFilialLD+"_"+stringDateLD);
                }
            }
            for(String s : dailyNames){
                System.out.println(s);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  dailyNames;
    }
    public static void unRarInFolder(List<String> names){
        for(String name : names){
            String[] ss = name.split("_");
            CopyFile.unRarFile(CopyFile.getThePathToTheSource(ss[1],name), CopyFile.getThePathToTheReceiver(name));
            CopyFile.unRarFile(CopyFile.getThePathToTheSourceY(ss[1], name), CopyFile.getThePathToTheReceiver(name));
        }
    }
    public static void loadInDB(List<String> names){
        for(String name : names){
            Inserter.insertContract(Inserter.updateContract(Parser.contractPars(CopyFile.getThePathToTheReceiver(name))));
            Inserter.insertProduct(Inserter.updateProduct(Parser.productPars(CopyFile.getThePathToTheReceiver(name))));
            Inserter.insertDeliverer(Inserter.updateDeliverer(Parser.delivererPars(CopyFile.getThePathToTheReceiver(name))));
            Inserter.insertEmployee(Inserter.updateEmployee(Parser.employeePars(CopyFile.getThePathToTheReceiver(name))));
            Inserter.insertLoyalty(Inserter.updateLoyalty(Parser.loyaltyPars(CopyFile.getThePathToTheReceiver(name))));
            Inserter.insertEvent(Inserter.updateEvent(Parser.eventPars(CopyFile.getThePathToTheReceiver(name))));
            Inserter.insertOperation(Inserter.updateOperation(Parser.operationPars(CopyFile.getThePathToTheReceiver(name))));
        }
    }
}
