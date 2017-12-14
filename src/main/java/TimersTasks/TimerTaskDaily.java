package TimersTasks;

import Entity.AllInformation;
import WorkWithFile.WorkWithQueue;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by Андрей on 14.12.2017.
 */
public class TimerTaskDaily extends TimerTask {
    @Override
    public void run() {
        List<AllInformation> queue = WorkWithQueue.filesForYesterdayInQueue();
        Date startDate = new Date();
        WorkWithQueue wwq = new WorkWithQueue();
        wwq.FirstPart(queue,startDate);
    }
}
