package org.wy.hard;

import java.util.Stack;


/**
 * 将业务问题，应用问题转换为代码问题
 * 比如这道题的按行算，按列算
 * 这就是切入点，否则很难做出来
 */

public class Num42 {


    /**
     * 思路：
     * 按照高度i来逐行求雨水，  变量 ans，temp
     * IF i>HEIGHT 往后遍历  第一个HEIGHT>=i 则开始准备计算 ，之后的HEIGHT<i temp++  直到下一个HEIGHT>=i ans+=temp，temp＝0
     * 可以这么理解变量temp和ans  temp相当于勺子舀水，准备计算就是准备舀水，到最后水舀完了倒不倒到ans盆子里去则看后面的条件满足没有
     *
     * 时间复杂度：O(m*n) m代表墙最大高度，n代表数组长度
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        /** 获取墙的最大高度 */
        int maxHeight = getMax(height);
        int ans = 0;
        for (int i = 1; i <= maxHeight; i++) {
            int temp = 0;
            boolean start = false;
            for (int j = 0; j < height.length; j++) {
                if (start && i>height[j]){temp++;}
                if (i<=height[j]){
                    ans+=temp;
                    temp=0;
                    start=true;
                }
            }
        }
        return ans;
    }


    /**
     * 思路：
     * 按列求雨水，每列的雨水累加。 每列的雨水＝（其左右两边墙的最大高度的较小值－该列的高度）*（列的宽度）
     *                                   = ( Math.min( left_MaxHeight, right_maxHeight ) - cur_height）* 1
     * 用两个数组maxLeft[i],maxRight[i]存储第i列左边墙的最大高度和右边墙的最大高度
     * maxLeft[i] = Math.max( maxLeft[i-1], height[i-1] )
     * maxRight[i] = Math.max( maxRight[i+1] , height[i+1] )
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {

        int ans = 0;
        int count = height.length;
        int[] maxLeft = new int[count];
        int[] maxRight = new int[count];

        /** 初始化数组 */
        for (int i = 1; i < count; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }
        for (int i = count-2; i >=0 ; i--) {
            maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
        }

        /** 遍历列 */
        for (int i = 0; i < count; i++) {
            int min = Math.min(maxLeft[i],maxRight[i]);
            if (min>height[i]){
                ans+=min-height[i];
            }
        }


        return ans;
    }


    /**
     * 用栈
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {

        int ans = 0;
        Stack<Integer> stack = new Stack();
        int cur = 0;
        while (cur<height.length){
            while (!stack.isEmpty() && height[stack.peek()]<height[cur]){
                int index = stack.pop();
                if (stack.isEmpty()){break;}
                int leftIndex = stack.peek();
                int distance = cur - leftIndex -1 ;
                int gao = Math.min(height[leftIndex],height[cur])-height[index];
                ans+=(distance*gao);
            }
            stack.push(cur);
            cur++;
        }

        return ans;
    }





    private int getMax(int[] height) {

        int maxHeight = 0;
        for (int i : height) {
            if (i>maxHeight){
                maxHeight = i;
            }
        }
        return maxHeight;
    }


}
