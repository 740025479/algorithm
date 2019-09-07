package org.wy.binarySearch;

public class Num34 {

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        res[0] = getLeft(nums,target);
        res[1] = getRight(nums,target);
        return res;

    }

    private int getLeft(int[] nums,int target){

        int left = 0;
        int right = nums.length;
        while (left<right){
            int mid = left + (right-left)/2 ;
            if (nums[mid]==target){
                right = mid;
            }else if (nums[mid]>target){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        if (left==nums.length){return -1;}
        return nums[left]==target?left:-1;

    }


    private int getRight(int[] nums,int target){

        int left = 0;
        int right = nums.length;
        while (left<right){
            int mid = left + (right-left)/2 ;
            if (nums[mid]==target){
                left = mid+1;
            }else if (nums[mid]>target){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        if (left==nums.length){return -1;}
        return nums[left]==target?left:-1;

    }


}
