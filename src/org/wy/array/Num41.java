package org.wy.array;

public class Num41 {
    /**
     * 要求时间复杂度为O(n)
     * 空间复杂度为O(1)
     * 难点：1.长度为N的数组，所求值的范围必在1-N+1之间,因此不在此范围内的值转为1
     *      2.
     */
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (nums[i]==1)flag=true;
            if (nums[i]<=0||nums[i]>n){
                nums[i]=1;
            }
        }
        if (!flag)return 1;

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a==n){
                nums[0]=-Math.abs(nums[0]);
            }else {
                nums[a]=-Math.abs(nums[a]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i]>0)return i;
        }
        if (nums[0]>0)return n;
        return n+1;
    }
}
