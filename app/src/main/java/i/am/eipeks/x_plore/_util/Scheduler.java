package i.am.eipeks.x_plore._util;

import android.app.job.JobParameters;
import android.app.job.JobService;



public class Scheduler extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
