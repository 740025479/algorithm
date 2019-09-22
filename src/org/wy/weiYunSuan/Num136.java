package org.wy.weiYunSuan;

public class Num136 {
    public int singleNumber(int[] nums) {

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            start^=nums[i];
        }
        return start;
    }
}
