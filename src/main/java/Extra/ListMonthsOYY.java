package Extra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ������ on 13.12.2017.
 */
public class ListMonthsOYY {

    private static List<MonthFormOYY> month;

    private ListMonthsOYY() {
    }

    public static List<MonthFormOYY> getInstance(){
        if(month==null){
            month = new ArrayList<MonthFormOYY>();
            month.add(new MonthFormOYY("01","01_������"));
            month.add(new MonthFormOYY("02","02_�������"));
            month.add(new MonthFormOYY("03","03_����"));
            month.add(new MonthFormOYY("04","04_������"));
            month.add(new MonthFormOYY("05","05_���"));
            month.add(new MonthFormOYY("06","06_����"));
            month.add(new MonthFormOYY("07","07_����"));
            month.add(new MonthFormOYY("08","08_������"));
            month.add(new MonthFormOYY("09","09_��������"));
            month.add(new MonthFormOYY("10","10_�������"));
            month.add(new MonthFormOYY("11","11_������"));
            month.add(new MonthFormOYY("12","12_�������"));
        }
        return month;
    }
}
