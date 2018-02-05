package InsertInDB;

import Entity.*;
import XMLparser.ParseDouble;
import com.healthmarketscience.jackcess.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Андрей on 22.01.2018.
 */
public class Inserter {

    public static final String DB_PATH = "C:\\mainPawn\\data\\lo22.mdb";
    public static final String TABLE_OPERATION = "operation";
    public static final String TABLE_CONTRACT = "contract_info";
    public static final String TABLE_PRODUCT = "product_info";
    public static final String TABLE_DELIVERER = "deliverer";
    public static final String TABLE_EVENT = "event";
    public static final String TABLE_LOYALTY = "loyalty";
    public static final String TABLE_EMPLOYEE = "employee";


    public static void insertOperation(List<Operation> operationList){
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            Table table = db.getTable(TABLE_OPERATION);

            for(Operation op : operationList){
                table.addRow(Column.AUTO_NUMBER,
                        op.getCodeFilial(),
                        op.getId(),
                        op.getOp(),
                        op.getDateOp(),
                        ParseDouble.doubleForAccess(op.getSumOp()),
                        op.getIdContractOp(),
                        ParseDouble.doubleForAccess(op.getPercentOp()),
                        ParseDouble.doubleForAccess(op.getDelayOp()),
                        op.getTimestampField(),
                        op.getCurrencyCode(),
                        ParseDouble.doubleForAccess(op.getCurrencyRate())
                        );

            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void insertContract(List<Contract> contractList){
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            Table table = db.getTable(TABLE_CONTRACT);
            for(Contract con : contractList) {
               table.addRow(Column.AUTO_NUMBER,
                        con.getCodeFilial(),
                        con.getIdParentContract(),
                        con.getId(),
                        con.getIdDeliverer(),
                        con.getNumOfDay(),
                        ParseDouble.doubleForAccess(con.getLoanAmount()),
                        ParseDouble.doubleForAccess(con.getEstimatedAmount()),
                        con.getContractNumber(),
                        con.getDateBegin(),
                        con.getDateEnd(),
                        ParseDouble.doubleForAccess(con.getConPercent()),
                        ParseDouble.doubleForAccess(con.getAmountRef()),
                        con.getConStatus(),
                        ParseDouble.doubleForAccess(con.getSumPercent()),
                        con.getIdEmployee(),
                        con.getDateClose(),
                        con.getSpecialCondition(),
                        con.getEstimatedPercent(),
                        ParseDouble.doubleForAccess(con.getDollarPrice()),
                        ParseDouble.doubleForAccess(con.getEstimatedAmountInDollar()),
                        con.getSpecialAction(),
                        con.getContractTypeGroup(),
                        con.getCurrencyCode(),
                        ParseDouble.doubleForAccess(con.getCurrencyRate()),
                        con.getLastId(),
                        con.getCloseType(),
                        con.getProductType(),
                        0//ParseDouble.doubleForAccess(con.getWeight2())
                        );
            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insertProduct(List<Product> productList){
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            Table table = db.getTable(TABLE_PRODUCT);

            for(Product product : productList){
                table.addRow(Column.AUTO_NUMBER,
                        product.getCodeFilial(),
                        product.getIdProduct(),
                        product.getProduct(),
                        product.getMetal(),
                        product.getNum(),
                        product.getTest(),
                        ParseDouble.doubleForAccess(product.getPrice()),
                        ParseDouble.doubleForAccess(product.getWeight()),
                        ParseDouble.doubleForAccess(product.getWeightNet()),
                        ParseDouble.doubleForAccess(product.getEstimatedAmount()),
                        product.getIdContract(),
                        product.getProductStatus(),
                        product.getCurrencyCode(),
                        ParseDouble.doubleForAccess(product.getCurrencyRate()),
                        product.getSerialNumber(),
                        product.getpKod()
                );
            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insertDeliverer(List<Deliverer> delivererList){
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            Table table = db.getTable(TABLE_DELIVERER);

            for (Deliverer deliverer : delivererList) {
                table.addRow(Column.AUTO_NUMBER,
                        deliverer.getCodeFilial(),
                        deliverer.getIdDeliverer(),
                        deliverer.getName(),
                        deliverer.getIdTariff(),
                        deliverer.getDateAdd(),
                        deliverer.getTelephone(),
                        deliverer.getDateOfBurn(),
                        deliverer.getAdress(),
                        deliverer.getPasportSer(),
                        deliverer.getPasportNum(),
                        deliverer.getPasportVydan(),
                        deliverer.getPasportDate(),
                        deliverer.getInn(),
                        deliverer.getIdGroupOfRisk(),
                        deliverer.getCardNumber(),
                        deliverer.getCardType(),
                        deliverer.getDateEdit(),
                        deliverer.getAdressOfBorn(),
                        deliverer.getAdress2(),
                        deliverer.getNationality(),
                        deliverer.getChanel()
                        );
            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insertEvent(List<Event> eventList){
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            Table table = db.getTable(TABLE_EVENT);

            for (Event event : eventList) {
                table.addRow(Column.AUTO_NUMBER,
                        event.getCodeFilial(),
                        event.getIdEvent(),
                        event.getEventDate(),
                        event.getEventTypeId(),
                        event.getEmployeeId(),
                        event.getTimeStampField(),
                        event.getEventText(),
                        event.getComment()
                );
            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insertEmployee(List<Employee> employeeList){
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            Table table = db.getTable(TABLE_EMPLOYEE);

            for (Employee employee : employeeList) {
                table.addRow(Column.AUTO_NUMBER,
                        employee.getCodeFilial(),
                        employee.getIdEmployee(),
                        employee.getEmployeeName(),
                        employee.getInstruction()
                );
            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insertLoyalty(List<Loyalty> loyaltyList){
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            Table table = db.getTable(TABLE_LOYALTY);

            for (Loyalty loyalty : loyaltyList) {
                table.addRow(Column.AUTO_NUMBER,
                        loyalty.getId_loyalty(),
                        loyalty.getCodeFilial(),
                        loyalty.getIdLoyalty(),
                        loyalty.getIdDeliverer(),
                        ParseDouble.doubleForAccess(loyalty.getOption1()),
                        ParseDouble.doubleForAccess(loyalty.getOption2()),
                        loyalty.getEditDate(),
                        loyalty.getStatus(),
                        loyalty.getIdContract()
                );
            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contract> updateContract(List<Contract> contractList){
        List<Contract> deletList = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            for(Contract con : contractList){
                Map<String, Object> columnMap = new TreeMap<>();
                columnMap.put("code_filial", con.getCodeFilial());
                columnMap.put("id_contract", con.getId());

                Table table = db.getTable(TABLE_CONTRACT);
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(columnMap);

                if (found) {
                    for(Row row : cursor.newIterable().setMatchPattern(columnMap)) {
                        row.put("idParentContract", con.getIdParentContract());
                        row.put("id_deliverer", con.getIdDeliverer());
                        row.put("num_of_day", con.getNumOfDay());
                        row.put("loan_amount", ParseDouble.doubleForAccess(con.getLoanAmount()));
                        row.put("estimated_amount", ParseDouble.doubleForAccess(con.getEstimatedAmount()));
                        row.put("contract_number", con.getContractNumber());
                        row.put("date_begin", con.getDateBegin());
                        row.put("date_end", con.getDateEnd());
                        row.put("con_percent", ParseDouble.doubleForAccess(con.getConPercent()));
                        row.put("amount_ref", ParseDouble.doubleForAccess(con.getAmountRef()));
                        row.put("con_status", con.getConStatus());
                        row.put("sum_percent", ParseDouble.doubleForAccess(con.getSumPercent()));
                        row.put("idEmployee", con.getIdEmployee());
                        row.put("DateClose", con.getDateClose());
                        row.put("SpecialCondition", con.getSpecialAction());
                        row.put("EstimatedPercent", con.getEstimatedPercent());
                        row.put("DollarPrice", ParseDouble.doubleForAccess(con.getDollarPrice()));
                        row.put("EstimatedAmountInDollar", ParseDouble.doubleForAccess(con.getEstimatedAmountInDollar()));
                        row.put("SpecialAction", con.getSpecialAction());
                        row.put("contractTypeGroup", con.getContractTypeGroup());
                        row.put("currencyCode", con.getCurrencyCode());
                        row.put("currencyRate", ParseDouble.doubleForAccess(con.getCurrencyRate()));
                        row.put("lastId", con.getLastId());
                        row.put("closeType", con.getCloseType());
                        row.put("productType", con.getProductType());
                        row.put("weight2", 0);
                        table.updateRow(row);
                        deletList.add(con);
                    }
                }
            }
            db.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Contract> con = contractList;
        con.removeAll(deletList);
        return con;
    }
    public static List<Product> updateProduct(List<Product> productList){
        List<Product> deletList = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            for(Product product : productList){
                Map<String, Object> columnMap = new TreeMap<>();
                columnMap.put("code_filial", product.getCodeFilial());
                columnMap.put("id_contract", product.getIdContract());
                columnMap.put("id_product", product.getIdProduct());

                Table table = db.getTable(TABLE_PRODUCT);
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(columnMap);
                if (found) {
                    for(Row row : cursor.newIterable().setMatchPattern(columnMap)) {
                        row.put("product", product.getProduct());
                        row.put("metal", product.getMetal());
                        row.put("num", product.getNum());
                        row.put("test", product.getTest());
                        row.put("price", ParseDouble.doubleForAccess(product.getPrice()));
                        row.put("weight", ParseDouble.doubleForAccess(product.getWeight()));
                        row.put("weight_net", ParseDouble.doubleForAccess(product.getWeightNet()));
                        row.put("estimated_amount", ParseDouble.doubleForAccess(product.getEstimatedAmount()));
                        row.put("product_status", product.getProductStatus());
                        row.put("currencyCode", product.getCurrencyCode());
                        row.put("currencyRate", ParseDouble.doubleForAccess(product.getCurrencyRate()));
                        row.put("SerialNumber", product.getSerialNumber());
                        row.put("pKod", product.getpKod());
                        table.updateRow(row);
                        deletList.add(product);
                    }
                }
            }
            db.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> prod = productList;
        prod.removeAll(deletList);
        return prod;
    }
    public static List<Employee> updateEmployee(List<Employee> employeeList){
        List<Employee> deletList = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            for(Employee employee : employeeList){
                Map<String, Object> columnMap = new TreeMap<>();
                columnMap.put("code_filial", employee.getCodeFilial());
                columnMap.put("idEmployee", employee.getIdEmployee());

                Table table = db.getTable(TABLE_EMPLOYEE);
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(columnMap);

                if (found) {
                    for(Row row : cursor.newIterable().setMatchPattern(columnMap)) {
                        row.put("EmployeeName", employee.getEmployeeName());
                        row.put("Instruction", employee.getInstruction());
                        table.updateRow(row);
                        deletList.add(employee);
                    }
                }
            }
            db.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        List<Employee> emp = employeeList;
        emp.removeAll(deletList);
        return emp;
    }
    public static List<Deliverer> updateDeliverer(List<Deliverer> delivererList){
        List<Deliverer> deletList = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            for(Deliverer deliverer : delivererList){
                Map<String, Object> columnMap = new TreeMap<>();
                columnMap.put("code_filial", deliverer.getCodeFilial());
                columnMap.put("id_deliverer", deliverer.getIdDeliverer());

                Table table = db.getTable(TABLE_DELIVERER);
                CursorBuilder.createCursor(table);
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(columnMap);

                if (found) {
                    for(Row row : cursor.newIterable().setMatchPattern(columnMap)){
                        row.put("name", deliverer.getName());
                        row.put("id_tarif", deliverer.getIdTariff());
                        row.put("DateAdd", deliverer.getDateAdd());
                        row.put("telephone", deliverer.getTelephone());
                        row.put("date_of_burn", deliverer.getDateOfBurn());
                        row.put("adress", deliverer.getAdress());
                        row.put("pasport_ser", deliverer.getPasportSer());
                        row.put("pasport_num", deliverer.getPasportNum());
                        row.put("pasport_vydan", deliverer.getPasportVydan());
                        row.put("pasport_date", deliverer.getPasportDate());
                        row.put("inn", deliverer.getInn());
                        row.put("id_group_of_risk", deliverer.getIdGroupOfRisk());
                        row.put("CardNumber", deliverer.getCardNumber());
                        row.put("CardType", deliverer.getCardType());
                        row.put("DateEdit", deliverer.getDateEdit());
                        row.put("adress_of_born", deliverer.getAdressOfBorn());
                        row.put("adress2", deliverer.getAdress2());
                        row.put("nationality", deliverer.getNationality());
                        row.put("chanel", deliverer.getChanel());
                        table.updateRow(row);
                        deletList.add(deliverer);
                    }
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        List<Deliverer> deliv = delivererList;
        deliv.removeAll(deletList);
        return deliv;
    }
    public static List<Event> updateEvent(List<Event> eventList){
        List<Event> deletList = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            for(Event event : eventList){
                Map<String, Object> columnMap = new TreeMap<>();
                columnMap.put("code_filial", event.getCodeFilial());
                columnMap.put("idEvent", event.getIdEvent());

                Table table = db.getTable(TABLE_EVENT);
                CursorBuilder.createCursor(table);
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(columnMap);
                if (found) {
                    for(Row row : cursor.newIterable().setMatchPattern(columnMap)){
                        row.put("EventDate", event.getEventDate());
                        row.put("EventTypeId", event.getEventTypeId());
                        row.put("EmployeeId", event.getEmployeeId());
                        row.put("timeStampField", event.getTimeStampField());
                        row.put("EventText", event.getEventText());
                        row.put("comment", event.getComment());
                        table.updateRow(row);
                        deletList.add(event);
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        List<Event> event = eventList;
        event.removeAll(deletList);
        return event;
    }
    public static List<Loyalty> updateLoyalty(List<Loyalty> loyaltyList){
        List<Loyalty> deletList = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            for(Loyalty lol : loyaltyList) {
                Map<String, Object> columnMap = new TreeMap<>();
                columnMap.put("code_filial", lol.getCodeFilial());
                columnMap.put("id_loyalty", lol.getId_loyalty());

                Table table = db.getTable(TABLE_LOYALTY);
                CursorBuilder.createCursor(table);
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(columnMap);
                if (found) {
                    for(Row row : cursor.newIterable().setMatchPattern(columnMap)) {
                        row.put("idLoyalty", lol.getIdLoyalty());
                        row.put("idDeliverer", lol.getIdDeliverer());
                        row.put("option1", ParseDouble.doubleForAccess(lol.getOption1()));
                        row.put("option2", ParseDouble.doubleForAccess(lol.getOption2()));
                        row.put("editDate", lol.getEditDate());
                        row.put("status", lol.getStatus());
                        row.put("idContract", lol.getIdContract());
                        table.updateRow(row);
                        deletList.add(lol);
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        List<Loyalty> lol = loyaltyList;
        lol.removeAll(deletList);
        return lol;
    }
    public static List<Operation> updateOperation(List<Operation> operationList){
        List<Operation> deletList = new ArrayList<>();
        try {
            Database db = DatabaseBuilder.open(new File(DB_PATH));
            for(Operation op : operationList){
                Map<String, Object> columnMap = new TreeMap<>();
                columnMap.put("code_filial", op.getCodeFilial());
                columnMap.put("id_contract_op", op.getIdContractOp());
                columnMap.put("id_operation", op.getId());

                Map<String, Object> contractUpdateMap = new TreeMap<>();
                contractUpdateMap.put("code_filial", op.getCodeFilial());
                contractUpdateMap.put("id_contract", op.getIdContractOp());

                Map<String, Object> productUpdateMap = new TreeMap<>();
                productUpdateMap.put("code_filial", op.getCodeFilial());
                productUpdateMap.put("id_contract", op.getIdContractOp());

                Table table = db.getTable(TABLE_OPERATION);
                CursorBuilder.createCursor(table);
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(columnMap);
                if (found) {
                    for(Row rowOperation : cursor.newIterable().setMatchPattern(columnMap)) {
                        rowOperation.put("op", op.getOp());
                        rowOperation.put("date_op", op.getDateOp());
                        rowOperation.put("sum_op", ParseDouble.doubleForAccess(op.getSumOp()));
                        rowOperation.put("percent_op", ParseDouble.doubleForAccess(op.getPercentOp()));
                        rowOperation.put("delay_op", ParseDouble.doubleForAccess(op.getDelayOp()));
                        rowOperation.put("TimeStampField", op.getTimestampField());
                        rowOperation.put("currencyCode", op.getCurrencyCode());
                        rowOperation.put("currencyRate", ParseDouble.doubleForAccess(op.getCurrencyRate()));
                        table.updateRow(rowOperation);
                        deletList.add(op);

                    }
                    if(op.getOp()==2 || op.getOp()==3 || op.getOp()==5 || op.getOp()==6 || op.getOp()==7){
                        Table table1 = db.getTable(TABLE_CONTRACT);
                        CursorBuilder.createCursor(table1);
                        Cursor cursor1 = CursorBuilder.createCursor(table1);
                        boolean found1 = cursor1.findFirstRow(contractUpdateMap);
                        if (found1) {
                            for (Row rowContract : cursor1.newIterable().setMatchPattern(contractUpdateMap)) {
                                rowContract.put("con_status", 0);
                                rowContract.put("DateClose", op.getDateOp());
                                table.updateRow(rowContract);
                            }
                        }

                        Table table2 = db.getTable(TABLE_PRODUCT);
                        CursorBuilder.createCursor(table2);
                        Cursor cursor2 = CursorBuilder.createCursor(table2);
                        boolean found2 = cursor2.findFirstRow(productUpdateMap);
                        if (found2) {
                            for (Row rowProduct : cursor2.newIterable().setMatchPattern(productUpdateMap)) {
                                rowProduct.put("product_status", 0);
                                table.updateRow(rowProduct);
                            }
                        }
                    }
                }else{
                    if(op.getOp()==2 || op.getOp()==3 || op.getOp()==5 || op.getOp()==6 || op.getOp()==7){
                        Table table1 = db.getTable(TABLE_CONTRACT);
                        CursorBuilder.createCursor(table1);
                        Cursor cursor1 = CursorBuilder.createCursor(table1);
                        boolean found1 = cursor1.findFirstRow(contractUpdateMap);
                        if (found1) {
                            for (Row rowContract : cursor1.newIterable().setMatchPattern(contractUpdateMap)) {
                                rowContract.put("con_status", 0);
                                rowContract.put("DateClose", op.getDateOp());
                                table.updateRow(rowContract);
                            }
                        }

                        Table table2 = db.getTable(TABLE_PRODUCT);
                        CursorBuilder.createCursor(table2);
                        Cursor cursor2 = CursorBuilder.createCursor(table2);
                        boolean found2 = cursor2.findFirstRow(productUpdateMap);
                        if (found2) {
                            for (Row rowProduct : cursor2.newIterable().setMatchPattern(productUpdateMap)) {
                                rowProduct.put("product_status", 0);
                                table.updateRow(rowProduct);
                            }
                        }
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        List<Operation> op = operationList;
        op.removeAll(deletList);
        return op;
    }




}
