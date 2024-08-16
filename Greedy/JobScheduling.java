import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Job {
    int start, end;

    Job(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class JobScheduling {

    public static List<Job> getMaxJobs(Job[] jobs) {
        // Sort jobs according to their finish time
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));

        List<Job> result = new ArrayList<>();
        result.add(jobs[0]);
        int lastEndTime = jobs[0].end;

        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i].start >= lastEndTime) {
                result.add(jobs[i]);
                lastEndTime = jobs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(start[i], end[i]);
        }

        List<Job> maxJobs = getMaxJobs(jobs);

        System.out.println("The maximum number of non-overlapping jobs are:");
        for (Job job : maxJobs) {
            System.out.println("Job starts at: " + job.start + ", ends at: " + job.end);
        }
    }
}
