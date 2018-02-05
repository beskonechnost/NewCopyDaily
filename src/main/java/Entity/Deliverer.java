package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Андрей on 26.01.2018.
 */
public class Deliverer {

    private int codeFilial;
    private int idDeliverer;
    private String name;
    private String idTariff;
    private Date dateAdd;
    private String telephone;
    private String dateOfBurn;
    private String adress;
    private String pasportSer;
    private String pasportNum;
    private String pasportVydan;
    private String pasportDate;
    private String inn;
    private String idGroupOfRisk;
    private String CardNumber;
    private String CardType;
    private Date dateEdit;
    private String adressOfBorn;
    private String adress2;
    private String nationality;
    private String chanel;

    public Deliverer() {
    }
    public Deliverer(int codeFilial, int idDeliverer, String name, String idTariff, Date dateAdd, String telephone, String dateOfBurn, String adress, String pasportSer,
                     String pasportNum, String pasportVydan, String pasportDate, String inn, String idGroupOfRisk, String cardNumber, String cardType, Date dateEdit,
                     String adressOfBorn, String adress2, String nationality, String chanel) {
        this.codeFilial = codeFilial;
        this.idDeliverer = idDeliverer;
        this.name = name;
        this.idTariff = idTariff;
        this.dateAdd = dateAdd;
        this.telephone = telephone;
        this.dateOfBurn = dateOfBurn;
        this.adress = adress;
        this.pasportSer = pasportSer;
        this.pasportNum = pasportNum;
        this.pasportVydan = pasportVydan;
        this.pasportDate = pasportDate;
        this.inn = inn;
        this.idGroupOfRisk = idGroupOfRisk;
        CardNumber = cardNumber;
        CardType = cardType;
        this.dateEdit = dateEdit;
        this.adressOfBorn = adressOfBorn;
        this.adress2 = adress2;
        this.nationality = nationality;
        this.chanel = chanel;
    }

    public int getCodeFilial() {
        return codeFilial;
    }
    public void setCodeFilial(int codeFilial) {
        this.codeFilial = codeFilial;
    }

    public int getIdDeliverer() {
        return idDeliverer;
    }
    public void setIdDeliverer(int idDeliverer) {
        this.idDeliverer = idDeliverer;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIdTariff() {
        return idTariff;
    }
    public void setIdTariff(String idTariff) {
        this.idTariff = idTariff;
    }

    public Date getDateAdd() {
        return dateAdd;
    }
    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }
    public void setDateAdd(String date_add) {
        try {
            this.dateAdd = new SimpleDateFormat( "dd.MM.yyyy" ).parse(date_add);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateOfBurn() {
        return dateOfBurn;
    }
    public void setDateOfBurn(String dateOfBurn) {
        this.dateOfBurn = dateOfBurn;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPasportSer() {
        return pasportSer;
    }
    public void setPasportSer(String pasportSer) {
        this.pasportSer = pasportSer;
    }

    public String getPasportNum() {
        return pasportNum;
    }
    public void setPasportNum(String pasportNum) {
        this.pasportNum = pasportNum;
    }

    public String getPasportVydan() {
        return pasportVydan;
    }
    public void setPasportVydan(String pasportVydan) {
        this.pasportVydan = pasportVydan;
    }

    public String getPasportDate() {
        return pasportDate;
    }
    public void setPasportDate(String pasportDate) {
        this.pasportDate = pasportDate;
    }

    public String getInn() {
        return inn;
    }
    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getIdGroupOfRisk() {
        return idGroupOfRisk;
    }
    public void setIdGroupOfRisk(String idGroupOfRisk) {
        this.idGroupOfRisk = idGroupOfRisk;
    }

    public String getCardNumber() {
        return CardNumber;
    }
    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCardType() {
        return CardType;
    }
    public void setCardType(String cardType) {
        CardType = cardType;
    }

    public Date getDateEdit() {
        return dateEdit;
    }
    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }
    public void setDateEdit(String date_edit) {
        try {
            if(date_edit.equals("30.12.1899")){
                this.dateEdit = null;
            }else {
                this.dateEdit = new SimpleDateFormat("dd.MM.yyyy").parse(date_edit);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getAdressOfBorn() {
        return adressOfBorn;
    }
    public void setAdressOfBorn(String adressOfBorn) {
        this.adressOfBorn = adressOfBorn;
    }

    public String getAdress2() {
        return adress2;
    }
    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getChanel() {
        return chanel;
    }
    public void setChanel(String chanel) {
        this.chanel = chanel;
    }

    @Override
    public String toString() {
        return "Deliverer{" +
                "codeFilial=" + codeFilial +
                ", idDeliverer=" + idDeliverer +
                ", name='" + name + '\'' +
                ", idTariff=" + idTariff +
                ", dateAdd=" + dateAdd +
                ", telephone='" + telephone + '\'' +
                ", dateOfBurn='" + dateOfBurn + '\'' +
                ", adress='" + adress + '\'' +
                ", pasportSer='" + pasportSer + '\'' +
                ", pasportNum='" + pasportNum + '\'' +
                ", pasportVydan='" + pasportVydan + '\'' +
                ", pasportDate='" + pasportDate + '\'' +
                ", inn='" + inn + '\'' +
                ", idGroupOfRisk='" + idGroupOfRisk + '\'' +
                ", CardNumber='" + CardNumber + '\'' +
                ", CardType='" + CardType + '\'' +
                ", dateEdit=" + dateEdit +
                ", adressOfBorn='" + adressOfBorn + '\'' +
                ", adress2='" + adress2 + '\'' +
                ", nationality='" + nationality + '\'' +
                ", chanel='" + chanel + '\'' +
                '}';
    }
}
