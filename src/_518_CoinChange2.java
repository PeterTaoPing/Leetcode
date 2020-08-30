public class _518_CoinChange2 {
    /**
     * Time O(m * n)
     * Space O(m)
     */
    class Solution1 {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length+1][amount+1];
            dp[0][0] = 1;

            for (int i = 1; i <= coins.length; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= amount; j++) {
                    dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
                }
            }
            return dp[coins.length][amount];
        }
    }

    /**
     * Time O(m * n)
     * Space O(m)
     */
    class Solution2 {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for(int coin : coins) {
                for(int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }
}
