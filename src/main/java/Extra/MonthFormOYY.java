package Extra;

/**
 * Created by Андрей on 13.12.2017.
 */
public class MonthFormOYY {
    private String number;
    private String textMonth;

    public MonthFormOYY() {
    }
    public MonthFormOYY(String number, String textMonth) {
        this.number = number;
        this.textMonth = textMonth;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getTextMonth() {
        return textMonth;
    }
    public void setTextMonth(String textMonth) {
        this.textMonth = textMonth;
    }

    @Override
    public String toString() {
        return "MonthFormOYY{" +
                "number=" + number +
                ", textMonth='" + textMonth + '\'' +
                '}';
    }
}
