package org.wy.stock;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num122 {

    /**
     * 波峰波谷法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int valley = 0;
        int peak = 0;
        int maxProfit = 0;
        int i=0;
        /** 外层循环的条件的减一 */
        while (i<prices.length-1){
            /** 内层的两个while循环不能换顺序 */
            while (i<prices.length-1 && prices[i]>=prices[i+1]){
                i++;
            }
            valley = prices[i];
            while (i<prices.length-1 && prices[i]<=prices[i+1]){
                i++;
            }
            peak = prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }


    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1]>prices[i]){
                maxProfit+=prices[i+1]-prices[i];
            }
        }
        return maxProfit;
    }


    /**
     * 状态转移方程 k=无穷
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
