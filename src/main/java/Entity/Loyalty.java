package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Андрей on 26.01.2018.
 */
public class Loyalty {

    private int id_loyalty;
    private int codeFilial;
    private int idLoyalty;
    private int idDeliverer;
    private String option1;
    private String option2;
    private Date editDate;
    private int status;
    private int idContract;

    public Loyalty() {
    }
    public Loyalty(int id_loyalty, int codeFilial, int idLoyalty, int idDeliverer, String option1, String option2, Date editDate, int status, int idContract) {
        this.id_loyalty = id_loyalty;
        this.codeFilial = codeFilial;
        this.idLoyalty = idLoyalty;
        this.idDeliverer = idDeliverer;
        this.option1 = option1;
        this.option2 = option2;
        this.editDate = editDate;
        this.status = status;
        this.idContract = idContract;
    }

    public int getId_loyalty() {
        return id_loyalty;
    }
    public void setId_loyalty(int id_loyalty) {
        this.id_loyalty = id_loyalty;
    }

    public int getCodeFilial() {
        return codeFilial;
    }
    public void setCodeFilial(int codeFilial) {
        this.codeFilial = codeFilial;
    }

    public int getIdLoyalty() {
        return idLoyalty;
    }
    public void setIdLoyalty(int idLoyalty) {
        this.idLoyalty = idLoyalty;
    }

    public int getIdDeliverer() {
        return idDeliverer;
    }
    public void setIdDeliverer(int idDeliverer) {
        this.idDeliverer = idDeliverer;
    }

    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public Date getEditDate() {
        return editDate;
    }
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
    public void setEditDate(String editDate) {
        try {
            if(editDate.equals("30.12.1899")){
                this.editDate = null;
            }else {
                this.editDate = new SimpleDateFormat("dd.MM.yyyy").parse(editDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdContract() {
        return idContract;
    }
    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }
}
