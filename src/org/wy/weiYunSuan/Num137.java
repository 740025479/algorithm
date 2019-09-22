package org.wy.weiYunSuan;

public class Num137 {

    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 31; j >=0 ; j--) {

                bit[j]+=nums[i]&1;
                nums[i]>>=1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res<<=1;
            res=bit[i]%3;
        }
        return res;
    }
}
