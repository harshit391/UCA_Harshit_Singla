class Result
{
    static int solve(int[][] cost, int m, int n, int i, int j, int[][] dp){

        if (i == m - 1 && j == n - 1){
            return cost[i][j];
        }
        if (i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //recursive case
        int ans1 = solve(cost, m, n, i+1, j,dp);
        int ans2 = solve(cost, m, n, i, j+1, dp);
        int ans3 = solve(cost, m, n, i+1, j+1, dp);

        dp[i][j] = cost[i][j] + Math.min(ans1, (Math.min(ans2, ans3)));
        return dp[i][j];
    }
    static int minCostPath(int[][] cost, int m, int n){

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }

        return solve(cost, m, n,0,0,dp);
    }
}