package org.wy.stock;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num123 {

    public int maxProfit(int[] prices) {
        int valley = 0;
        int peak = 0;
        int[] top2Profit = new int[2];
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            int profit = peak - valley;

            if (profit >= top2Profit[0]) {
                top2Profit[1] = top2Profit[0];
                top2Profit[0] = profit;
            } else if (profit > top2Profit[1]) {
                top2Profit[1] = profit;
            }

        }
        return top2Profit[0] + top2Profit[1];
    }

    /**
     * 状态转移方程 k=2
     */
    public int maxProfit3(int[] prices) {
        int n =prices.length;
        if ( n< 1) return 0;

        int max_K = 2;
        int[][][] dp = new int[n][max_K+1][2];
        dp[0][1][0]=dp[0][2][0]=0;
        dp[0][1][1]=dp[0][2][1]=-prices[0];
        dp[0][0][0]=0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= max_K; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }

        }
        return dp[n-1][max_K][0];
    }

    public int maxProfit4(int[] prices) {
        int n =prices.length;
        if ( n< 1) return 0;

        int dp_i10 =0;
        int dp_i20 =0;
        int dp_i11 =-prices[0];
        int dp_i21 = -prices[0];
        for (int i = 1; i < n; i++) {

            dp_i20=Math.max(dp_i20,dp_i21+prices[i]);
            dp_i21=Math.max(dp_i21,dp_i10-prices[i]);
            dp_i10=Math.max(dp_i10,dp_i11+prices[i]);
            dp_i11=Math.max(dp_i11,-prices[i]);

        }
        return dp_i20;
    }

}
