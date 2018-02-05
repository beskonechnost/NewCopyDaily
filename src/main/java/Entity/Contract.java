package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Андрей on 23.01.2018.
 */
public class Contract {

    private int codeFilial;
    private int id;
    private int idParentContract;
    private int idDeliverer;
    private int numOfDay;
    private String loanAmount;
    private String estimatedAmount;
    private String contractNumber;
    private Date dateBegin;
    private Date dateEnd;
    private String conPercent;
    private String amountRef;
    private boolean conStatus;
    private String sumPercent;
    private int idEmployee;
    private Date dateClose;
    private int specialCondition;
    private int estimatedPercent;
    private String dollarPrice;
    private String estimatedAmountInDollar;
    private int specialAction;
    private int contractTypeGroup;
    private int arrears;
    private int currencyCode;
    private String currencyRate;
    private int lastId;
    private int productType;
    private int closeType;
    private String weight2;

    public Contract(int codeFilial, int id, int idParentContract, int idDeliverer, int numOfDay, String loanAmount, String estimatedAmount, String contractNumber,
                    Date dateBegin, Date dateEnd, String conPercent, String amountRef, boolean conStatus, String sumPercent, int idEmployee, Date dateClose, int specialCondition,
                    int estimatedPercent, String dollarPrice, String estimatedAmountInDollar, int specialAction,
                    int contractTypeGroup, int arrears, int currencyCode, String currencyRate, int lastId, int productType, int closeType, String weight2) {
        this.codeFilial = codeFilial;
        this.id = id;
        this.idParentContract = idParentContract;
        this.idDeliverer = idDeliverer;
        this.numOfDay = numOfDay;
        this.loanAmount = loanAmount;
        this.estimatedAmount = estimatedAmount;
        this.contractNumber = contractNumber;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.conPercent = conPercent;
        this.amountRef = amountRef;
        this.conStatus = conStatus;
        this.sumPercent = sumPercent;
        this.idEmployee = idEmployee;
        this.dateClose = dateClose;
        this.specialCondition = specialCondition;
        this.estimatedPercent = estimatedPercent;
        this.dollarPrice = dollarPrice;
        this.estimatedAmountInDollar = estimatedAmountInDollar;
        this.specialAction = specialAction;
        this.contractTypeGroup = contractTypeGroup;
        this.arrears = arrears;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
        this.lastId = lastId;
        this.productType = productType;
        this.closeType = closeType;
        this.weight2 = weight2;
    }

    public Contract() {
    }

    public int getCodeFilial() {
        return codeFilial;
    }
    public void setCodeFilial(int codeFilial) {
        this.codeFilial = codeFilial;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdParentContract() {
        return idParentContract;
    }
    public void setIdParentContract(int idParentContract) {
        this.idParentContract = idParentContract;
    }

    public int getIdDeliverer() {
        return idDeliverer;
    }
    public void setIdDeliverer(int idDeliverer) {
        this.idDeliverer = idDeliverer;
    }

    public int getNumOfDay() {
        return numOfDay;
    }
    public void setNumOfDay(int numOfDay) {
        this.numOfDay = numOfDay;
    }

    public String getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getEstimatedAmount() {
        return estimatedAmount;
    }
    public void setEstimatedAmount(String estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public String getContractNumber() {
        return contractNumber;
    }
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getDateBegin() {
        return dateBegin;
    }
    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }
    public void setDateBegin(String dateBegin){
        try {
            this.dateBegin = new SimpleDateFormat( "dd.MM.yyyy" ).parse(dateBegin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDateEnd() {
        return dateEnd;
    }
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    public void setDateEnd(String dateEnd){
        try {
            this.dateEnd = new SimpleDateFormat( "dd.MM.yyyy" ).parse(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getConPercent() {
        return conPercent;
    }
    public void setConPercent(String conPercent) {
        this.conPercent = conPercent;
    }

    public String getAmountRef() {
        return amountRef;
    }
    public void setAmountRef(String amountRef) {
        this.amountRef = amountRef;
    }

    public boolean getConStatus() {
        return conStatus;
    }
    public void setConStatus(int conStatus) {
        if(conStatus!=0) {
            this.conStatus = true;
        }else{
            this.conStatus = false;
        }
    }

    public String getSumPercent() {
        return sumPercent;
    }
    public void setSumPercent(String sumPercent) {
        this.sumPercent = sumPercent;
    }

    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Date getDateClose() {
        return dateClose;
    }
    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }
    public void setDateClose(String dateClose){
        try {
            if(dateClose.equals("30.12.1899")){
                this.dateClose = null;
            }else {
                this.dateClose = new SimpleDateFormat("dd.MM.yyyy").parse(dateClose);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getSpecialCondition() {
        return specialCondition;
    }
    public void setSpecialCondition(int specialCondition) {
        this.specialCondition = specialCondition;
    }

    public int getEstimatedPercent() {
        return estimatedPercent;
    }
    public void setEstimatedPercent(int estimatedPercent) {
        this.estimatedPercent = estimatedPercent;
    }

    public String getDollarPrice() {
        return dollarPrice;
    }
    public void setDollarPrice(String dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public String getEstimatedAmountInDollar() {
        return estimatedAmountInDollar;
    }
    public void setEstimatedAmountInDollar(String estimatedAmountInDollar) {
        this.estimatedAmountInDollar = estimatedAmountInDollar;
    }

    public int getSpecialAction() {
        return specialAction;
    }
    public void setSpecialAction(int specialAction) {
        this.specialAction = specialAction;
    }

    public int getContractTypeGroup() {
        return contractTypeGroup;
    }
    public void setContractTypeGroup(int contractTypeGroup) {
        this.contractTypeGroup = contractTypeGroup;
    }

    public int getArrears() {
        return arrears;
    }
    public void setArrears(int arrears) {
        this.arrears = arrears;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }
    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }

    public int getLastId() {
        return lastId;
    }
    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public int getProductType() {
        return productType;
    }
    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getCloseType() {
        return closeType;
    }
    public void setCloseType(int closeType) {
        this.closeType = closeType;
    }

    public String getWeight2() {
        return weight2;
    }
    public void setWeight2(String weight2) {
        this.weight2 = weight2;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", idParentContract=" + idParentContract +
                ", idDeliverer=" + idDeliverer +
                ", numOfDay=" + numOfDay +
                ", loanAmount='" + loanAmount + '\'' +
                ", estimatedAmount='" + estimatedAmount + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", conPercent='" + conPercent + '\'' +
                ", amountRef='" + amountRef + '\'' +
                ", conStatus=" + conStatus +
                ", sumPercent='" + sumPercent + '\'' +
                ", idEmployee=" + idEmployee +
                ", dateClose=" + dateClose +
                ", specialCondition=" + specialCondition +
                ", estimatedPercent=" + estimatedPercent +
                ", dollarPrice='" + dollarPrice + '\'' +
                ", estimatedAmountInDollar='" + estimatedAmountInDollar + '\'' +
                ", specialAction=" + specialAction +
                ", contractTypeGroup=" + contractTypeGroup +
                ", arrears=" + arrears +
                ", currencyCode=" + currencyCode +
                ", currencyRate='" + currencyRate + '\'' +
                ", lastId=" + lastId +
                '}';
    }
}
