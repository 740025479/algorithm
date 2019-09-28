package org.wy.array;

public class Num31 {


    /**
     * 找到此题的特点是什么，根据特点写代码，根据用例检测出的错误修改不严谨的逻辑
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        boolean isDESC = true;
        int lastAddIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                isDESC = false;
                lastAddIndex = i;
            }
        }
        if (isDESC) {
            int left = 0;
            int right = nums.length - 1;
            reverse(nums, left, right);
        } else {
            int k = lastAddIndex;
            while (k < nums.length - 1) {
                if (nums[k] > nums[lastAddIndex] && nums[lastAddIndex] >= nums[k + 1]) {
                    swap(nums, lastAddIndex, k);
                    break;
                } else if (k == nums.length - 2 && nums[k + 1] > nums[lastAddIndex]) {
                    swap(nums, lastAddIndex, k + 1);
                    break;
                }
                k++;
            }
            reverse(nums, lastAddIndex + 1, nums.length-1);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
