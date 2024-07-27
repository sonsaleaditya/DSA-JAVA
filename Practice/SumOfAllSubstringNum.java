public class SumOfAllSubstringNum {
    public static void main(String[] args) {
        System.out.println(sumSubstrings("1234"));
    }

    
        public static long sumSubstrings(String s) {
            long mod = (long) 1e9 + 7; // Modulo value
            long multiplier = 1; // Multiplier for digit position
            long totalSum = 0; // Total sum of substrings
    
            // Iterate over the characters of the string from right to left
            for (int i = s.length() - 1; i >= 0; i--) {
                long digit = s.charAt(i) - '0'; // Convert character to digit
                long substringSum = (i + 1) * multiplier * digit; // Sum contributed by substrings ending at position i
                totalSum += substringSum; // Add substring sum to the total sum
                multiplier = (multiplier * 10 + 1) % mod; // Update the multiplier
                totalSum %= mod; // Take modulo of the total sum
            }
    
            return totalSum; // Return the final total sum
        }
    
    
}
