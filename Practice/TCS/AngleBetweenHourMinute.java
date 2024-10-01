/**
 * Problem Statement:
 * Given a specific time in the format "hour:minute", calculate the smallest angle 
 * formed between the hour and minute hands on an analog clock.
 *
 * Input:
 * A string representing the time in "hour:minute" format.
 *
 * Output:
 * The smallest angle between the hour and minute hands.
 *
 * Example:
 * Input: "1:30"
 * Output: 135.0 degrees
 *
 * Explanation:
 * At 1:30, the hour hand is at 45 degrees (1 hour * 30 degrees + 30 minutes * 0.5 degrees per minute),
 * and the minute hand is at 180 degrees (30 minutes * 6 degrees per minute). The difference is 135 degrees,
 * which is the smallest angle.
 */

 public class AngleBetweenHourMinute {
    public static void main(String[] args) {
        String time = "1:30"; // Example input time
        findAngle(time);      // Call to method to find the angle between hands
    }

    /**
     * Finds the smallest angle between the hour and minute hands for the given time.
     * @param time The input time string in "hour:minute" format.
     */
    static void findAngle(String time) {
        // Splitting the input time string into hour and minute components
        String timeArr[] = time.split(":");
        int hour = Integer.parseInt(timeArr[0]);    // Extracting the hour part
        int minute = Integer.parseInt(timeArr[1]);  // Extracting the minute part

        // Convert to 12-hour format if hour is greater than or equal to 12
        if (hour >= 12) {
            hour -= 12;  // Normalize to a 12-hour clock format
        }

        // Minute hand moves 6 degrees for every minute
        double minuteAngle = minute * 6;

        // Hour hand moves 30 degrees for every hour, plus 0.5 degrees for every minute
        double hourAngle = hour * 30 + minute * 0.5;

        // Calculate the absolute difference between the two angles
        double angle = Math.abs(minuteAngle - hourAngle);
        
        // Find the smaller angle between the two possible angles (the other being 360 - angle)
        double ans = Math.min(angle, 360 - angle);

        // Output the calculated smallest angle
        System.out.println("Angle between hour and minute hand is: " + ans + " degrees");
    }
}
