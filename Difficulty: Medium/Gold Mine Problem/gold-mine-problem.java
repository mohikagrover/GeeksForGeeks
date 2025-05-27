// User function Template for Java

class Solution {
    public int maxGold(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = mat[i][n - 1];
        }

        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                int right = dp[i][j + 1];
                int rightUp = (i > 0) ? dp[i - 1][j + 1] : 0;
                int rightDown = (i < m - 1) ? dp[i + 1][j + 1] : 0;

                dp[i][j] = mat[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
        
    }
}