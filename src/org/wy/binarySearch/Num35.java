package org.wy.binarySearch;

public class Num35 {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target<=nums[i]){
                return i;
            }
        }
        return nums.length+1;
    }


    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2 ;
            if (nums[mid]==target){return mid;}
            if (nums[mid]>target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if (nums[right]>=target){return right;}
        return right+1;
    }

}
