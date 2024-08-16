public class Valid_IP_Address {
    public static void main(String[] args) {
        Solution obj = new Solution();

        String str = "01.01.01.01";
        System.out.println(obj.isValid(str));
    }
}

class Solution {

    public boolean isValid(String str) {
        String arr[] = str.split("[.]");
        for (String k : arr) {
            if (k.length() > 3 ||  k.length()<=0 || k.charAt(0)=='0')
                return false;

            int n = Integer.parseInt(k);
            if (n < 0 || n > 255)
                return false;

        }

        return true;
    }
}