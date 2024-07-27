import java.util.HashMap;

public class PickToys {
    public static void main(String[] args) {
        int k = 2; // Maximum number of different types of toys
        String arr[] = {"motorcycle", "bullet", "motorcycle", "train", "doll", "car", "helicopter", "car", "helicopter", "car"};
        System.out.println("Son can take " + pickToys(arr, k) + " toys");
    }

    // Function to find the maximum number of toys that can be picked with at most k types of toys
    static int pickToys(String[] arr, int k) {
        int s = 0, e = 0, max = 0, n = arr.length;
        HashMap<String, Integer> map = new HashMap<>();

        // Loop through the array with the end pointer 'e'
        while (e < n) {
            // Add the toy at position 'e' to the map or update its count
            map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);

            // If the map size exceeds 'k', shrink the window from the start pointer 's'
            while (map.size() > k && s <= e) {
                map.put(arr[s], map.getOrDefault(arr[s], 0) - 1);
                if (map.get(arr[s]) == 0) {
                    map.remove(arr[s]);
                }
                s++; // Move the start pointer forward
            }

            // Update the maximum number of toys if the map size is exactly 'k'
            if (map.size() == k) {
                max = Math.max(max, countToys(map));
            }
            e++; // Move the end pointer forward
        }
        return max;
    }

    // Helper function to count the total number of toys in the map
    static int countToys(HashMap<String, Integer> map) {
        int count = 0;
        for (int i : map.values()) {
            count += i;
        }
        return count;
    }
}
