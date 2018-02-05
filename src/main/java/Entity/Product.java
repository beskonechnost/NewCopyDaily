package Entity;

/**
 * Created by Андрей on 25.01.2018.
 */
public class Product {

    private int codeFilial;
    private int idProduct;
    private String product;
    private String metal;
    private int num;
    private int test;
    private String price;
    private String weight;
    private String weightNet;
    private String estimatedAmount;
    private int idContract;
    private boolean productStatus;
    private int currencyCode;
    private String currencyRate;
    private String serialNumber;
    private String pKod;

    public Product() {
    }
    public Product(int codeFilial, int idProduct, String product, String metal, int num, int test, String price, String weight, String weightNet, String estimatedAmount, int idContract,
                   boolean productStatus, int currencyCode, String currencyRate, String serialNumber, String pKod) {
        this.codeFilial = codeFilial;
        this.idProduct = idProduct;
        this.product = product;
        this.metal = metal;
        this.num = num;
        this.test = test;
        this.price = price;
        this.weight = weight;
        this.weightNet = weightNet;
        this.estimatedAmount = estimatedAmount;
        this.idContract = idContract;
        this.productStatus = productStatus;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
        this.serialNumber = serialNumber;
        this.pKod = pKod;
    }

    public int getCodeFilial() {
        return codeFilial;
    }
    public void setCodeFilial(int codeFilial) {
        this.codeFilial = codeFilial;
    }

    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public String getMetal() {
        return metal;
    }
    public void setMetal(String metal) {
        this.metal = metal;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public int getTest() {
        return test;
    }
    public void setTest(int test) {
        this.test = test;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightNet() {
        return weightNet;
    }
    public void setWeightNet(String weightNet) {
        this.weightNet = weightNet;
    }

    public String getEstimatedAmount() {
        return estimatedAmount;
    }
    public void setEstimatedAmount(String estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public int getIdContract() {
        return idContract;
    }
    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public boolean getProductStatus() {
        return productStatus;
    }
    public void setProductStatus(int productStatus) {
        if(productStatus!=0){
            this.productStatus = true;
        }else {
            this.productStatus = false;
        }
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

    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getpKod() {
        return pKod;
    }
    public void setpKod(String pKod) {
        this.pKod = pKod;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codeFilial=" + codeFilial +
                ", idProduct=" + idProduct +
                ", product='" + product + '\'' +
                ", metal='" + metal + '\'' +
                ", num=" + num +
                ", test=" + test +
                ", price='" + price + '\'' +
                ", weight='" + weight + '\'' +
                ", weightNet='" + weightNet + '\'' +
                ", estimatedAmount='" + estimatedAmount + '\'' +
                ", idContract=" + idContract +
                ", productStatus=" + productStatus +
                ", currencyCode=" + currencyCode +
                ", currencyRate='" + currencyRate + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", pKod='" + pKod + '\'' +
                '}';
    }
}
