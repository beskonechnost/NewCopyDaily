package Extra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 13.12.2017.
 */
public class ListMonthsOYY {

    private static List<MonthFormOYY> month;

    private ListMonthsOYY() {
    }

    public static List<MonthFormOYY> getInstance(){
        if(month==null){
            month = new ArrayList<MonthFormOYY>();
            month.add(new MonthFormOYY("01","01_Январь"));
            month.add(new MonthFormOYY("02","02_Февраль"));
            month.add(new MonthFormOYY("03","03_Март"));
            month.add(new MonthFormOYY("04","04_Апрель"));
            month.add(new MonthFormOYY("05","05_Май"));
            month.add(new MonthFormOYY("06","06_Июнь"));
            month.add(new MonthFormOYY("07","07_Июль"));
            month.add(new MonthFormOYY("08","08_Август"));
            month.add(new MonthFormOYY("09","09_Сентябрь"));
            month.add(new MonthFormOYY("10","10_Октябрь"));
            month.add(new MonthFormOYY("11","11_Ноябрь"));
            month.add(new MonthFormOYY("12","12_Декабрь"));
        }
        return month;
    }
}
