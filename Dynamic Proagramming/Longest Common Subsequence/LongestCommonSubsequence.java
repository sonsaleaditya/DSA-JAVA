public class LongestCommonSubsequence {
    public static void main(String[] args) {

        String s = "agbcba";
        String revered = "";
        for(int i=s.length()-1;i>=0;i--){
            revered+=s.charAt(i);

        }

        LongestCommonSubsequence c

        System.out.println("longest Palindromic String is : ");
    }

    int longestPalindrome(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int i =m,j=n;
        StringBuilder sb  = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }

        }

        return sb.toString().length();
    }
}
