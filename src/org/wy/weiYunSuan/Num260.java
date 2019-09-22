package org.wy.weiYunSuan;

public class Num260 {
    /**
     * 数a位与－a得到的是为1的最低位
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {

        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        res&=(-res);
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num&res)==0){
                ans[0]^=num;
            }else {
                ans[1]^=num;
            }
        }
        return ans;
    }
}
