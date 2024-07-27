import java.util.*;

public class JobScheduling {

    public static void main(String[] args) {
        // Define job details directly
        Job j1 = new Job(1, 2, 100);
        Job j2 = new Job(2, 1, 19);
        Job j3 = new Job(3, 2, 27);
        Job j4 = new Job(4, 1, 25);
        Job j5 = new Job(5, 1, 15);
        
        // Create an array of jobs
        Job[] arr = {j1, j2, j3, j4, j5};
        
        // Call JobScheduling function and print the result
        int[] jobs = jobScheduling(arr, arr.length);
        System.out.println("Number of jobs scheduled: " + jobs[0]);
        System.out.println("Total profit: " + jobs[1]);
    }
    
    // Function to find the maximum profit and the number of jobs done.
    static int[] jobScheduling(Job arr[], int n) {
        // Sort jobs based on profit in descending order
        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));
        
        int maxDeadline = Integer.MIN_VALUE;
        // Finding max deadline
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        int result[] = new int[2];
        int jobsToBeScheduled[] = new int[maxDeadline];

        // Iterate through all jobs
        for (Job job : arr) {
            int deadline = job.deadline;
            // Find the earliest deadline for the job
            while (deadline > 0 && jobsToBeScheduled[deadline - 1] == 1) {
                deadline--;
            }
            // If a slot is available before the deadline, schedule the job
            if (deadline > 0) {
                result[0]++;
                result[1] += job.profit;
                jobsToBeScheduled[deadline - 1] = 1;
            }
        }

        return result;
    }

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
