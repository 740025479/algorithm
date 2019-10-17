package org.wy.array;

public class Num45 {

    public int jump(int[] nums) {

        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]+j>=i){
                    res[i]=res[j]+1;
                    break;
                }
            }
        }
        return res[nums.length-1];
    }

    /**
     * 贪心算法，每一步局部最优，最后全局最优
     * 从第一步开始，记录能达到的最远位置，并记为边界，然后在这段区间内继续记录能达到的最远位置，当到达边界后，步数+1，边界更新为当前最远步数
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i==end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
