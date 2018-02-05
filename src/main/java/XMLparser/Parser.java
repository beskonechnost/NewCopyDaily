package XMLparser;

import Entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parser {

    public static final String OPERATION_FILE = "operation.xml";
    public static final String CONTRACT_FILE = "contract_info.xml";
    public static final String PRODUCT_FILE = "product_info.xml";
    public static final String DELIVERER_FILE = "deliverer.xml";
    public static final String EVENT_FILE = "event.xml";
    public static final String LOYALTY_FILE = "loyalty.xml";
    public static final String EMPLOYEE_FILE = "employee.xml";

    public static List<Operation> operationPars(String path){
        File fileName = new File(path+OPERATION_FILE);
        List<Operation> listOperation = new ArrayList<Operation>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            int codeFilial = 0;

            Node root = document.getDocumentElement();
            NodeList rootElements = root.getChildNodes();

            for(int i = 0; i<rootElements.getLength(); i++){
                Node rootElement = rootElements.item(i);
                if(rootElement.getNodeName() == "FILIAL"){
                    codeFilial = Integer.parseInt(rootElement.getTextContent());
                }
                if(rootElement.getNodeName() == "ROWDATA") {
                    NodeList rows = rootElement.getChildNodes();
                    for(int j = 0; j < rows.getLength(); j++) {
                        Node row = rows.item(j);

                        Operation operation = new Operation();
                        operation.setCodeFilial(codeFilial);
                        operation.setId(Integer.parseInt(row.getAttributes().getNamedItem("id").getTextContent()));
                        operation.setOp(Integer.parseInt(row.getAttributes().getNamedItem("op").getTextContent()));
                        operation.setDateOp(row.getAttributes().getNamedItem("date_op").getTextContent());
                        operation.setSumOp(row.getAttributes().getNamedItem("sum_op").getTextContent());
                        operation.setIdContractOp(Integer.parseInt(row.getAttributes().getNamedItem("id_contract_op").getTextContent()));
                        operation.setPercentOp(row.getAttributes().getNamedItem("percent_op").getTextContent());
                        operation.setDelayOp(row.getAttributes().getNamedItem("delay_op").getTextContent());
                        operation.setTimestampField(row.getAttributes().getNamedItem("TimestampField").getTextContent());
                        operation.setCurrencyRate(row.getAttributes().getNamedItem("currencyRate").getTextContent());
                        operation.setCurrencyCode(Integer.parseInt(row.getAttributes().getNamedItem("currencyCode").getTextContent()));
                        listOperation.add(operation);
                    }
                }
            }

        } catch (Exception e) {
            try(FileWriter writer = new FileWriter("log.txt", false))
            {
                Date nowDate = new Date();
                writer.append(nowDate.toString());
                writer.append('\n');
                writer.append("Error parse \""+OPERATION_FILE+"\" in "+path);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return listOperation;
    }
    public static List<Contract> contractPars(String path) {
        File fileName = new File(path+CONTRACT_FILE);
        List<Contract> listContract = new ArrayList<Contract>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            int codeFilial = 0;

            Node root = document.getDocumentElement();
            NodeList rootElements = root.getChildNodes();

            for(int i = 0; i<rootElements.getLength(); i++) {
                Node rootElement = rootElements.item(i);
                if (rootElement.getNodeName() == "FILIAL") {
                    codeFilial = Integer.parseInt(rootElement.getTextContent());
                }
                if(rootElement.getNodeName() == "ROWDATA") {
                    NodeList rows = rootElement.getChildNodes();
                    for (int j = 0; j < rows.getLength(); j++) {
                        Node row = rows.item(j);

                        NamedNodeMap attributes = row.getAttributes();

                        Contract contract = new Contract();
                        contract.setCodeFilial(codeFilial);
                        contract.setId(Integer.parseInt(row.getAttributes().getNamedItem("id").getTextContent()));
                        contract.setIdParentContract(Integer.parseInt(row.getAttributes().getNamedItem("idParentContract").getTextContent()));
                        contract.setIdDeliverer(Integer.parseInt(row.getAttributes().getNamedItem("id_deliverer").getTextContent()));
                        contract.setNumOfDay(Integer.parseInt(row.getAttributes().getNamedItem("num_of_day").getTextContent()));
                        contract.setLoanAmount(row.getAttributes().getNamedItem("loan_amount").getTextContent());
                        contract.setEstimatedAmount(row.getAttributes().getNamedItem("estimated_amount").getTextContent());
                        contract.setContractNumber(row.getAttributes().getNamedItem("contract_number").getTextContent());
                        contract.setDateBegin(row.getAttributes().getNamedItem("date_begin").getTextContent());
                        contract.setDateEnd(row.getAttributes().getNamedItem("date_end").getTextContent());
                        contract.setConPercent(row.getAttributes().getNamedItem("con_percent").getTextContent());
                        contract.setAmountRef(row.getAttributes().getNamedItem("amount_ref").getTextContent());
                        contract.setConStatus(Integer.parseInt(row.getAttributes().getNamedItem("con_status").getTextContent()));
                        contract.setSumPercent(row.getAttributes().getNamedItem("sum_percent").getTextContent());
                        contract.setIdEmployee(Integer.parseInt(row.getAttributes().getNamedItem("id_Employee").getTextContent()));
                        contract.setDateClose(row.getAttributes().getNamedItem("DateClose").getTextContent());
                        contract.setSpecialCondition(Integer.parseInt(row.getAttributes().getNamedItem("SpecialCondition").getTextContent()));
                        contract.setEstimatedPercent(Integer.parseInt(row.getAttributes().getNamedItem("EstimatedPercent").getTextContent()));
                        contract.setDollarPrice(row.getAttributes().getNamedItem("DollarPrice").getTextContent());
                        contract.setEstimatedAmountInDollar(row.getAttributes().getNamedItem("EstimatedAmountInDollar").getTextContent());
                        contract.setSpecialAction(Integer.parseInt(row.getAttributes().getNamedItem("SpecialAction").getTextContent()));
                        contract.setContractTypeGroup(Integer.parseInt(row.getAttributes().getNamedItem("contractTypeGroup").getTextContent()));
                        contract.setArrears(Integer.parseInt(row.getAttributes().getNamedItem("arrears").getTextContent()));
                        contract.setCurrencyCode(Integer.parseInt(row.getAttributes().getNamedItem("currencyCode").getTextContent()));
                        contract.setCurrencyRate(row.getAttributes().getNamedItem("currencyRate").getTextContent());
                        for (int ii = 0; ii < attributes.getLength(); ii++) {
                            Node attr = attributes.item(ii);
                            if(attr.getNodeName().equals("lastId")){
                                contract.setLastId(Integer.parseInt(row.getAttributes().getNamedItem("lastId").getTextContent()));
                            }
                            if(attr.getNodeName().equals("productType")){
                                contract.setProductType(Integer.parseInt(row.getAttributes().getNamedItem("productType").getTextContent()));
                            }
                            if(attr.getNodeName().equals("weightTotal")){
                                contract.setWeight2(row.getAttributes().getNamedItem("weightTotal").getTextContent());
                            }
                        }
                        listContract.add(contract);
                    }
                }
            }
        } catch (Exception e) {
            try(FileWriter writer = new FileWriter("log.txt", false))
            {
                Date nowDate = new Date();
                writer.append(nowDate.toString());
                writer.append('\n');
                writer.append("Error parse \""+CONTRACT_FILE+"\" in "+path);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return listContract;
    }
    public static List<Product> productPars(String path){
        File fileName = new File(path+PRODUCT_FILE);
        List<Product> listProduct = new ArrayList<Product>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            int codeFilial = 0;

            Node root = document.getDocumentElement();
            NodeList rootElements = root.getChildNodes();

            for(int i = 0; i<rootElements.getLength(); i++) {
                Node rootElement = rootElements.item(i);
                if(rootElement.getNodeName().equals("FILIAL")) {
                    codeFilial = Integer.parseInt(rootElement.getTextContent());
                }
                if(rootElement.getNodeName() == "ROWDATA") {
                    NodeList rows = rootElement.getChildNodes();
                    for(int j = 0; j < rows.getLength(); j++) {
                        Node row = rows.item(j);
                        NamedNodeMap attributes = row.getAttributes();

                        Product product = new Product();
                        product.setCodeFilial(codeFilial);
                        product.setIdProduct(Integer.parseInt(row.getAttributes().getNamedItem("id").getTextContent()));
                        product.setProduct(row.getAttributes().getNamedItem("product").getTextContent());
                        product.setMetal(row.getAttributes().getNamedItem("metal").getTextContent());
                        product.setNum(Integer.parseInt(row.getAttributes().getNamedItem("num").getTextContent()));
                        product.setTest(Integer.parseInt(row.getAttributes().getNamedItem("test").getTextContent()));
                        product.setPrice(row.getAttributes().getNamedItem("price").getTextContent());
                        product.setWeight(row.getAttributes().getNamedItem("weight").getTextContent());
                        product.setWeightNet(row.getAttributes().getNamedItem("weight_net").getTextContent());
                        product.setEstimatedAmount(row.getAttributes().getNamedItem("estimated_amount").getTextContent());
                        product.setIdContract(Integer.parseInt(row.getAttributes().getNamedItem("id_contract").getTextContent()));
                        product.setProductStatus(Integer.parseInt(row.getAttributes().getNamedItem("product_status").getTextContent()));
                        product.setCurrencyCode(Integer.parseInt(row.getAttributes().getNamedItem("currencyCode").getTextContent()));
                        product.setCurrencyRate(row.getAttributes().getNamedItem("currencyRate").getTextContent());
                        for (int ii = 0; ii < attributes.getLength(); ii++) {
                            Node attr = attributes.item(ii);
                            if (attr.getNodeName().equals("pKod")) {
                                product.setpKod(row.getAttributes().getNamedItem("pKod").getTextContent());
                            }
                            if(attr.getNodeName().equals("SerialNumber")){
                                product.setSerialNumber(row.getAttributes().getNamedItem("SerialNumber").getTextContent());
                            }
                        }
                        listProduct.add(product);
                    }
                }
            }
        } catch (Exception e) {
            try(FileWriter writer = new FileWriter("log.txt", false))
            {
                Date nowDate = new Date();
                writer.append(nowDate.toString());
                writer.append('\n');
                writer.append("Error parse \""+PRODUCT_FILE+"\" in "+path);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return listProduct;
    }
    public static List<Deliverer> delivererPars(String path){
        File fileName = new File(path+DELIVERER_FILE);
        List<Deliverer> listDeliverer = new ArrayList<Deliverer>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            int codeFilial = 0;

            Node root = document.getDocumentElement();
            NodeList rootElements = root.getChildNodes();
            for(int i = 0; i<rootElements.getLength(); i++) {
                Node rootElement = rootElements.item(i);
                if(rootElement.getNodeName().equals("FILIAL")) {
                    codeFilial = Integer.parseInt(rootElement.getTextContent());
                }
                if(rootElement.getNodeName() == "ROWDATA") {
                    NodeList rows = rootElement.getChildNodes();
                    for(int j = 0; j < rows.getLength(); j++) {
                        Node row = rows.item(j);
                        NamedNodeMap attributes = row.getAttributes();

                        Deliverer deliv = new Deliverer();
                        deliv.setCodeFilial(codeFilial);
                        for (int ii = 0; ii < attributes.getLength(); ii++) {
                            Node attr = attributes.item(ii);
                            if (attr.getNodeName().equals("id")) {
                                deliv.setIdDeliverer(Integer.parseInt(row.getAttributes().getNamedItem("id").getTextContent()));
                            }
                            if (attr.getNodeName().equals("name")) {
                                deliv.setName(row.getAttributes().getNamedItem("name").getTextContent());
                            }
                            if (attr.getNodeName().equals("date_of_burn")) {
                                deliv.setDateOfBurn(row.getAttributes().getNamedItem("date_of_burn").getTextContent());
                            }
                            if (attr.getNodeName().equals("adress")) {
                                deliv.setAdress(row.getAttributes().getNamedItem("adress").getTextContent());
                            }
                            if (attr.getNodeName().equals("pasport_ser")) {
                                deliv.setPasportSer(row.getAttributes().getNamedItem("pasport_ser").getTextContent());
                            }
                            if (attr.getNodeName().equals("pasport_num")) {
                                deliv.setPasportNum(row.getAttributes().getNamedItem("pasport_num").getTextContent());
                            }
                            if (attr.getNodeName().equals("pasport_vydan")) {
                                deliv.setPasportVydan(row.getAttributes().getNamedItem("pasport_vydan").getTextContent());
                            }
                            if (attr.getNodeName().equals("pasport_date")) {
                                deliv.setPasportDate(row.getAttributes().getNamedItem("pasport_date").getTextContent());
                            }
                            if (attr.getNodeName().equals("inn")) {
                                deliv.setInn(row.getAttributes().getNamedItem("inn").getTextContent());
                            }
                            if (attr.getNodeName().equals("id_tarif")) {
                                deliv.setIdTariff(row.getAttributes().getNamedItem("id_tarif").getTextContent());
                            }
                            if (attr.getNodeName().equals("id_group_of_risk")) {
                                deliv.setIdGroupOfRisk(row.getAttributes().getNamedItem("id_group_of_risk").getTextContent());
                            }
                            if (attr.getNodeName().equals("telephon")) {
                                deliv.setTelephone(row.getAttributes().getNamedItem("telephon").getTextContent());
                            }
                            if (attr.getNodeName().equals("DateAdd")) {
                                deliv.setDateAdd(row.getAttributes().getNamedItem("DateAdd").getTextContent());
                            }
                            if (attr.getNodeName().equals("DateEdit")) {
                                deliv.setDateEdit(row.getAttributes().getNamedItem("DateEdit").getTextContent());
                            }
                            if (attr.getNodeName().equals("adress_of_born")) {
                                deliv.setAdressOfBorn(row.getAttributes().getNamedItem("adress_of_born").getTextContent());
                            }
                            if (attr.getNodeName().equals("adress2")) {
                                deliv.setAdress2(row.getAttributes().getNamedItem("adress2").getTextContent());
                            }
                            if (attr.getNodeName().equals("nationality")) {
                                deliv.setNationality(row.getAttributes().getNamedItem("nationality").getTextContent());
                            }
                            if (attr.getNodeName().equals("chanel")) {
                                deliv.setChanel(row.getAttributes().getNamedItem("chanel").getTextContent());
                            }
                            if (attr.getNodeName().equals("CardType")) {
                                deliv.setCardType(row.getAttributes().getNamedItem("CardType").getTextContent());
                            }
                            if (attr.getNodeName().equals("CardNumber")) {
                                deliv.setCardNumber(row.getAttributes().getNamedItem("CardNumber").getTextContent());
                            }
                        }
                        listDeliverer.add(deliv);
                    }
                }
            }
        } catch (Exception e) {
            try(FileWriter writer = new FileWriter("log.txt", false))
            {
                Date nowDate = new Date();
                writer.append(nowDate.toString());
                writer.append('\n');
                writer.append("Error parse \""+DELIVERER_FILE+"\" in "+path);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return listDeliverer;
    }
    public static List<Event> eventPars(String path){
        File fileName = new File(path+EVENT_FILE);
        List<Event> listEvent = new ArrayList<Event>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            int codeFilial = 0;

            Node root = document.getDocumentElement();
            NodeList rootElements = root.getChildNodes();
            for(int i = 0; i<rootElements.getLength(); i++) {
                Node rootElement = rootElements.item(i);
                if(rootElement.getNodeName().equals("FILIAL")) {
                    codeFilial = Integer.parseInt(rootElement.getTextContent());
                }
                if(rootElement.getNodeName() == "ROWDATA") {
                    NodeList rows = rootElement.getChildNodes();
                    for(int j = 0; j < rows.getLength(); j++) {
                        Node row = rows.item(j);
                        NamedNodeMap attributes = row.getAttributes();

                        Event event = new Event();
                        event.setCodeFilial(codeFilial);
                        for (int ii = 0; ii < attributes.getLength(); ii++) {
                            Node attr = attributes.item(ii);
                            if (attr.getNodeName().equals("id")) {
                                event.setIdEvent(Integer.parseInt(row.getAttributes().getNamedItem("id").getTextContent()));
                            }
                            if (attr.getNodeName().equals("EventDate")) {
                                event.setEventDate(row.getAttributes().getNamedItem("EventDate").getTextContent());
                            }
                            if (attr.getNodeName().equals("EventTypeId")) {
                                event.setEventTypeId(Integer.parseInt(row.getAttributes().getNamedItem("EventTypeId").getTextContent()));
                            }
                            if (attr.getNodeName().equals("EventText")) {
                                event.setEventText(row.getAttributes().getNamedItem("EventText").getTextContent());
                            }
                            if (attr.getNodeName().equals("EmployeeId")) {
                                event.setEmployeeId(Integer.parseInt(row.getAttributes().getNamedItem("EmployeeId").getTextContent()));
                            }
                            if (attr.getNodeName().equals("timeStampField")) {
                                event.setTimeStampField(row.getAttributes().getNamedItem("timeStampField").getTextContent());
                            }
                            if (attr.getNodeName().equals("comment")) {
                                event.setComment(row.getAttributes().getNamedItem("comment").getTextContent());
                            }
                        }
                        listEvent.add(event);
                    }
                }
            }
        }catch (Exception e) {
            try(FileWriter writer = new FileWriter("log.txt", false))
            {
                Date nowDate = new Date();
                writer.append(nowDate.toString());
                writer.append('\n');
                writer.append("Error parse \""+EVENT_FILE+"\" in "+path);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return listEvent;


    }
    public static List<Loyalty> loyaltyPars(String path){
        File fileName = new File(path+LOYALTY_FILE);
        List<Loyalty> listLoyalty = new ArrayList<Loyalty>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            int codeFilial = 0;

            Node root = document.getDocumentElement();
            NodeList rootElements = root.getChildNodes();
            for(int i = 0; i<rootElements.getLength(); i++) {
                Node rootElement = rootElements.item(i);
                if (rootElement.getNodeName().equals("FILIAL")) {
                    codeFilial = Integer.parseInt(rootElement.getTextContent());
                }
                if(rootElement.getNodeName() == "ROWDATA") {
                    NodeList rows = rootElement.getChildNodes();
                    for(int j = 0; j < rows.getLength(); j++) {
                        Node row = rows.item(j);
                        NamedNodeMap attributes = row.getAttributes();
                        Loyalty loyalty = new Loyalty();
                        loyalty.setCodeFilial(codeFilial);
                        for (int ii = 0; ii < attributes.getLength(); ii++) {
                            Node attr = attributes.item(ii);
                            if (attr.getNodeName().equals("id")) {
                                loyalty.setId_loyalty(Integer.parseInt(row.getAttributes().getNamedItem("id").getTextContent()));
                            }
                            if (attr.getNodeName().equals("idLoyalty")) {
                                loyalty.setIdLoyalty(Integer.parseInt(row.getAttributes().getNamedItem("idLoyalty").getTextContent()));
                            }
                            if (attr.getNodeName().equals("idDeliverer")) {
                                loyalty.setIdDeliverer(Integer.parseInt(row.getAttributes().getNamedItem("idDeliverer").getTextContent()));
                            }
                            if (attr.getNodeName().equals("editDate")) {
                                loyalty.setEditDate(row.getAttributes().getNamedItem("editDate").getTextContent());
                            }
                            if (attr.getNodeName().equals("status")) {
                                loyalty.setStatus(Integer.parseInt(row.getAttributes().getNamedItem("status").getTextContent()));
                            }
                            if (attr.getNodeName().equals("iDContract")) {
                                loyalty.setIdDeliverer(Integer.parseInt(row.getAttributes().getNamedItem("iDContract").getTextContent()));
                            }
                            if (attr.getNodeName().equals("option1")) {
                                loyalty.setOption1(row.getAttributes().getNamedItem("option1").getTextContent());
                            }
                            if (attr.getNodeName().equals("option2")) {
                                loyalty.setOption2(row.getAttributes().getNamedItem("option2").getTextContent());
                            }
                            if (attr.getNodeName().equals("idContract")) {
                                loyalty.setIdContract(Integer.parseInt(row.getAttributes().getNamedItem("idContract").getTextContent()));
                            }
                        }
                        listLoyalty.add(loyalty);
                    }
                }
            }
        }catch (Exception e) {
            try(FileWriter writer = new FileWriter("log.txt", false))
            {
                Date nowDate = new Date();
                writer.append(nowDate.toString());
                writer.append('\n');
                writer.append("Error parse \""+LOYALTY_FILE+"\" in "+path);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return listLoyalty;
    }
    public static List<Employee> employeePars(String path){
        File fileName = new File(path+EMPLOYEE_FILE);
        List<Employee> employeeList = new ArrayList<Employee>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            int codeFilial = 0;

            Node root = document.getDocumentElement();
            NodeList rootElements = root.getChildNodes();
            for(int i = 0; i<rootElements.getLength(); i++) {
                Node rootElement = rootElements.item(i);
                if (rootElement.getNodeName().equals("FILIAL")) {
                    codeFilial = Integer.parseInt(rootElement.getTextContent());
                }
                if(rootElement.getNodeName() == "ROWDATA") {
                    NodeList rows = rootElement.getChildNodes();
                    for(int j = 0; j < rows.getLength(); j++) {
                        Node row = rows.item(j);
                        NamedNodeMap attributes = row.getAttributes();
                        Employee employee = new Employee();
                        employee.setCodeFilial(codeFilial);
                        for (int ii = 0; ii < attributes.getLength(); ii++) {
                            Node attr = attributes.item(ii);
                            if (attr.getNodeName().equals("id")) {
                                employee.setIdEmployee(Integer.parseInt(row.getAttributes().getNamedItem("id").getTextContent()));
                            }
                            if (attr.getNodeName().equals("name")) {
                                employee.setEmployeeName(row.getAttributes().getNamedItem("name").getTextContent());
                            }
                            if (attr.getNodeName().equals("Instruction")) {
                                employee.setInstruction(Integer.parseInt(row.getAttributes().getNamedItem("Instruction").getTextContent()));
                            }

                        }
                        employeeList.add(employee);
                    }
                }
            }
        }catch (Exception e) {
            try(FileWriter writer = new FileWriter("log.txt", false))
            {
                Date nowDate = new Date();
                writer.append(nowDate.toString());
                writer.append('\n');
                writer.append("Error parse \""+EMPLOYEE_FILE+"\" in "+path);
                writer.append('\n');

                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return employeeList;
    }

}
