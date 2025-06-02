class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;

        // If starting or ending cell is blocked
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return 0;

        int[][] dp = new int[n][m];

        // Initialize the starting point
        dp[0][0] = 1;

        // Fill first column
        for (int i = 1; i < n; i++) {
            dp[i][0] = (grid[i][0] == 0 && dp[i - 1][0] != 0) ? 1 : 0;
        }

        // Fill first row
        for (int j = 1; j < m; j++) {
            dp[0][j] = (grid[0][j] == 0 && dp[0][j - 1] != 0) ? 1 : 0;
        }

        // Fill rest of the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n - 1][m - 1];
    }
};