package org.wy.azl397985856;

public class Num0053 {

    public int maxSubArraySum(int[] nums){
        if (nums.length<1){return -1;}
        int res = Integer.MIN_VALUE;
        int[] maxToI = new int[nums.length];
        maxToI[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxToI[i] = Math.max(maxToI[i-1]+nums[i],nums[i]);
            res=Math.max(res,maxToI[i]);
        }
        return res;
    }





    





}
