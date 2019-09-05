package org.wy.stock;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num714 {

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0]-fee;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[n-1][0];
    }

    public int maxProfit3(int[] prices, int fee) {

        int n = prices.length;
        int dp_i0 = 0;
        int dp_i1 = -prices[0]-fee;
        for (int i = 1; i < n; i++) {
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0,dp_i1+prices[i]);
            dp_i1 = Math.max(dp_i1,temp-prices[i]-fee);

        }
        return dp_i0;
    }



    public int maxProfit2(int[] prices, int fee) {

        int maxProfit = 0;
        int i = 0;
        int n = prices.length;
        while (i<n-1){
            if (prices[i+1]-fee>prices[i]){
                maxProfit+=prices[i+1]-prices[i]-fee;
            }
            i++;
        }
        return maxProfit;
    }


}
