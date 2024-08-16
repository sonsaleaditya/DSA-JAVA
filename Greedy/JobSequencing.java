import java.util.Arrays;

public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };
        
        Solution obj = new Solution();
        int[] result = obj.JobScheduling(jobs, jobs.length);
        System.out.println("Number of jobs done: " + result[0]);
        System.out.println("Maximum profit: " + result[1]);
    }
}

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs based on their profit in descending order
        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));

        // Find the maximum deadline
        int maxDeadLine = Integer.MIN_VALUE;
        for (Job k : arr) {
            maxDeadLine = Math.max(k.deadline, maxDeadLine);
        }

        // Initialize a slot array to keep track of free time slots
        int[] slots = new int[maxDeadLine];
        int[] result = new int[2]; // result[0] -> count of jobs done, result[1] -> total profit

        // Iterate through each job
        for (Job job : arr) {
            int deadline = job.deadline;

            // Find a free slot for this job (we start from the last possible slot)
            while (deadline > 0 && slots[deadline - 1] == 1) {
                deadline--;
            }

            // If a free slot is found
            if (deadline > 0) {
                slots[deadline - 1] = 1; // Mark this slot as occupied
                result[0]++; // Increment count of jobs done
                result[1] += job.profit; // Add this job's profit to the total profit
            }
        }

        return result;
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

/*
Problem Statement:
Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.

Input:
jobs = [
    {id: 1, deadline: 4, profit: 20},
    {id: 2, deadline: 1, profit: 10},
    {id: 3, deadline: 1, profit: 40},
    {id: 4, deadline: 1, profit: 30}
]

Output:
Number of jobs done: 2
Maximum profit: 60

Explanation:
Job 3 and Job 4 can be completed within their deadlines to earn the maximum profit of 60.
*/
