public class Practice {
    public static void main(String[] args) {
        System.out.println("hii");
        int arr[]=  {0,0,1,1,1,2,2,3,3,4};
        System.out.println(testFunction(arr));
    }

     static int testFunction(int[] nums) {
        if (nums.length == 0) return 0;
    
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Assign the new unique value to the next position
            }
        }
        return i + 1; // The length of the array with unique elements
    }
    
}
