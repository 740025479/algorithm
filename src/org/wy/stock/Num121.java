package org.wy.stock;


/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票
 * <p>
 * <p>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */

public class Num121 {

    /**
     * 时间复杂度O（n2）
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }


    /**
     * 时间复杂度O（n）
     * 只交易一次
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int minCost = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minCost){
                minCost = prices[i];
            }else if (prices[i]-minCost>maxProfit){
                maxProfit = prices[i]-minCost;
            }
        }
        return maxProfit;
    }


    /**
     * 状态转移方程 k=1
     */
    public int maxProfit3(int[] prices){
        if (prices.length<1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }


}
