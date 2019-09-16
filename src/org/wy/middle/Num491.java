package org.wy.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Num491 {

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 2) return res;
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : res) {
                List<Integer> temp2 = new ArrayList<>();
                for (Integer element : list) {
                    temp2.add(element);
                }
                temp.add(temp2);
            }
            for (List<Integer> list : temp) {
                if (nums[i]>=list.get(list.size()-1)){
                    list.add(nums[i]);
                    res.add(list);
                }
            }
            for (int j = 0; j < i; j++) {
                if (nums[j]<=nums[i]){
                    List<Integer> k = new ArrayList<>();
                    k.add(nums[j]);
                    k.add(nums[i]);
                    res.add(k);
                }
            }
        }
        HashSet<List<Integer>> tool = new HashSet<>();
        for (List<Integer> list : res) {
            tool.add(list);
        }
        res.clear();
        for (List<Integer> list : tool) {
            res.add(list);
        }

        return res;
    }
}
