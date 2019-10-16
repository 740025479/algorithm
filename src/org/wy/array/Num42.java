package org.wy.array;

public class Num42 {
    /**
     * 积雨量等于当前列的左右两边最高列的较小值减去当前列的高度
     * 对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * @return
     */
    public int trap(int[] height) {

        int length = height.length;
        int leftMax[] = new int[length];
        int rightMax[] = new int[length];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        for (int i = length-2; i >=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }
        int res = 0;
        for (int i = 1; i < length-1; i++) {
            int k = Math.min(leftMax[i],rightMax[i])-height[i];
            res+= k>0?k:0;
        }
        return res;
    }
}
