// medium
// dynamic programming

class Solution {
    
    int[] dp;
    
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int n = 1; n <= amount; n++) {
            for (int c : coins) {
                if (n - c < 0) continue;
                if (dp[n - c] == -1) continue;
                dp[n] = (dp[n] == -1) ? dp[n -c] + 1 : Math.min(dp[n], dp[n - c] + 1);
            }
            //System.out.println("dp[" + n + "] = " + dp[n]);
        }
        return dp[amount];
    }
    
    
}