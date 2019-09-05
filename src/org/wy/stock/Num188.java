package org.wy.stock;

public class Num188 {


    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if (n < 1) return 0;

        int max_K = k;
        int[][][] dp = new int[n][max_K + 1][2];

        if (k>n/2){
            return maxProfit3(prices);
        }

        for (int i = 0; i < k + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= max_K; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }

        }
        return dp[n - 1][max_K][0];

    }


    /**
     * 无交易次数限制
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices){
        if (prices.length<1) return 0;

        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,temp-prices[i]);
        }
        return dp_i_0;
    }

}
