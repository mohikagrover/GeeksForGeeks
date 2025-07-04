// User function Template for Java

class Solution {
    public int longestPalinSubseq(String s) {
        // code here
        StringBuilder s2= new StringBuilder();
        s2.append(s);
        s2.reverse(); 
        int n= s.length();
        int m= s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } 
                
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}