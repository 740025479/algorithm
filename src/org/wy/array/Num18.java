package org.wy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Num18 {

    public static List<List<Integer>> fourSum1(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
        }
        return res;

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    /**
     * @param src    排序好的数组
     * @param target
     * @param k
     * @return
     */
    public static List<List<Integer>> kSum(int[] src, int target, int k, int begin) {

        List<List<Integer>> res = new ArrayList<>();
        int n = src.length;
        if (k == 2) {
            int left = begin;
            int right = n - 1;
            while (left < right) {
                int sum = src[left] + src[right];
                if (sum == target) {
                    /** Arrays.asList()返回的数组是其内部类数组，与util包下的ArrayList不一样，不能进行add，remove等操作 */
                    //res.add(Arrays.asList(src[left], src[right]));
                    List<Integer> list = new ArrayList<>(2);
                    list.add(src[left]);
                    list.add(src[right]);
                    res.add(list);
                    while (left < right && src[left] == src[++left]) ;
                    while (left < right && src[right] == src[--right]) ;
                } else if (sum < target) {
                    left++;
                } else right--;
            }
            return res;
        }
        if (k > 2) {
            for (int i = begin; i < n - k + 1; i++) {
                //3种剪枝操作
                //1:该轮循环的最小值与target比较
                if (src[i] + sum(src, k, i + 1) > target) break;
                //2:该轮循环最大值与target比较
                if (src[i] + sum(src, k, -1) < target) continue;
                //3:当前i值与前面相同
                if (i > begin && src[i] == src[i - 1]) continue;

                /** 变量i和常量begin混淆了 */
                List<List<Integer>> temp = kSum(src, target - src[i], k - 1, i + 1);
                if (temp != null) {
                    for (List<Integer> list : temp) {
                        list.add(src[i]);
                    }
                    res.addAll(temp);
                }
            }
        }
        return res;


    }

    private static int sum(int[] src, int k, int start) {
        int sum = 0;
        int n = src.length - 1;
        if (start == -1) {
            for (int i = 0; i < k - 1; i++) {
                sum += src[n - i];
            }
            return sum;
        } else {
            for (int i = 0; i < k - 1; i++) {
                sum += src[start + i];
            }
            return sum;
        }
    }

}
