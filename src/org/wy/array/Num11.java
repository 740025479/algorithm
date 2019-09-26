package org.wy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num11 {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right){
            maxArea=Math.max(maxArea,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<height[right]){left++;}
            else right--;
        }
        return maxArea;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0)break;
            if (i!=0&&nums[i]==nums[i-1])continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                if (nums[i]+nums[left]+nums[right]==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (right>left&&nums[right]==nums[right-1]){
                        right--;
                    }
                }else if (nums[i]+nums[left]+nums[right]<0){
                    left++;
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                }else {
                    if (nums[left]>0)break;
                    right--;
                    while (right>left&&nums[right]==nums[right-1]){
                        right--;
                    }
                }
            }
        }
        return res;

    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }


}
