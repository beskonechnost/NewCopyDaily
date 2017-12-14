import TimersTasks.TimerTaskDaily;
import WorkWithFile.WorkWithQueue;

import java.util.Date;
import java.util.Timer;

/**
 * Created by Андрей on 14.12.2017.
 */
public class Main {

    private static Timer mTimer;

    public static void main(String[] args) {
        if (mTimer != null) {
            mTimer.cancel();
        }

        Date d = new Date();
        d.setHours(8);
        d.setMinutes(30);
        d.setSeconds(0);
        d.setDate(d.getDate());

        mTimer = new Timer();
        TimerTaskDaily ttd = new TimerTaskDaily();

        mTimer.schedule(ttd,d,86400000);
    }
}
