package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Андрей on 22.01.2018.
 */
public class Operation {
    private int id;
    private int codeFilial;
    private int op;
    private Date dateOp;
    private String sumOp;
    private int idContractOp;
    private String percentOp;
    private String delayOp;
    private String timestampField;
    private String currencyRate;
    private int currencyCode;

    public Operation() {
    }

    public Operation(int id, int codeFilial, int op, Date dateOp, String sumOp, int idContractOp, String percentOp, String delayOp, String timestampField,
                     String currencyRate, int currencyCode) {
        this.id = id;
        this.codeFilial = codeFilial;
        this.op = op;
        this.dateOp = dateOp;
        this.sumOp = sumOp;
        this.idContractOp = idContractOp;
        this.percentOp = percentOp;
        this.delayOp = delayOp;
        this.timestampField = timestampField;
        this.currencyRate = currencyRate;
        this.currencyCode = currencyCode;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCodeFilial() {
        return codeFilial;
    }
    public void setCodeFilial(int codeFilial) {
        this.codeFilial = codeFilial;
    }

    public int getOp() {
        return op;
    }
    public void setOp(int op) {
        this.op = op;
    }

    public Date getDateOp() {
        return dateOp;
    }
    public void setDateOp(Date dateOp) {
        this.dateOp = dateOp;
    }
    public void setDateOp(String date_op) {
        try {
            this.dateOp = new SimpleDateFormat( "dd.MM.yyyy" ).parse(date_op);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getSumOp() {
        return sumOp;
    }
    public void setSumOp(String sumOp) {
        this.sumOp = sumOp;
    }

    public int getIdContractOp() {
        return idContractOp;
    }
    public void setIdContractOp(int idContractOp) {
        this.idContractOp = idContractOp;
    }

    public String getPercentOp() {
        return percentOp;
    }
    public void setPercentOp(String percentOp) {
        this.percentOp = percentOp;
    }

    public String getDelayOp() {
        return delayOp;
    }
    public void setDelayOp(String delayOp) {
        this.delayOp = delayOp;
    }

    public String getTimestampField() {
        return timestampField;
    }
    public void setTimestampField(String timestampField) {
        if(timestampField.equals("30.12.1899")){
            this.timestampField = null;
        }else {
            this.timestampField = timestampField;
        }
    }

    public String getCurrencyRate() {
        return currencyRate;
    }
    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", codeFilial=" + codeFilial +
                ", op=" + op +
                ", dateOp=" + dateOp +
                ", sumOp=" + sumOp +
                ", idContractOp=" + idContractOp +
                ", percentOp=" + percentOp +
                ", delayOp=" + delayOp +
                ", timestampField='" + timestampField + '\'' +
                ", currencyRate=" + currencyRate +
                ", currencyCode=" + currencyCode +
                '}';
    }

}
