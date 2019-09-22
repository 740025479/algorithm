package org.wy.donggui;

import java.util.ArrayList;
import java.util.List;

public class Num78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int length = nums.length;
        if (length == 0) return res;
        for (int i = 0; i < length; i++) {
            List<List<Integer>> tar = copy(res);
            for (List<Integer> list : tar) {
                list.add(nums[i]);
            }
            res.addAll(tar);
        }
        return res;
    }

    private List<List<Integer>> copy(List<List<Integer>> src) {
        List<List<Integer>> tar = new ArrayList<>();
        for (int i = 0; i < src.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < src.get(i).size(); j++) {
                temp.add(src.get(i).get(j));
            }
            tar.add(temp);
        }
        return tar;
    }
}
