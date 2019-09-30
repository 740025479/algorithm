package org.wy.array;

public class Num674 {

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length==0)return 0;
        if (nums.length<2){return 1;}
        int res = 1;
        int count= 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){count++;}
            else {
                res=Math.max(res,count);
                count=1;
            }
        }
        return Math.max(res,count);
    }

}
