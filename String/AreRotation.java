import java.util.*;
public class AreRotation {
    public static void main(String[] args) {
        // String s1 = "geeksforgeeks";
        // String s2 = "forgeeksgeeks";
        String s1 = "mightandmagic";
        String s2 = "andmagicmigth";
        
        Solution s = new Solution();
        System.out.println("Are '" + s1 + "' and '" + s2 + "' rotations of each other?");
        if (s.areRotations(s1, s2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

class Solution
{
    //Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2 )
    {
    StringBuilder temp = new StringBuilder();
       temp.append(s1);
       temp.append(s1);
       
       System.out.println(temp.lastIndexOf(s2));
       if(temp.lastIndexOf(s2) == -1)
       return false;
       else return true;
    }
    
}