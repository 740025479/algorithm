package org.wy.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列思路：新加的数在前面数的全排列基础上，每一个位置都插进去
 * 类似于动归
 */
public class Num46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            res = resolve(nums,i,res);
        }
        return res;
    }


    private List<List<Integer>> resolve(int[] nums,int index,List<List<Integer>> temp){
        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> list : temp) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> cur = copy(list);
                cur.add(i,nums[index]);
                res.add(cur);
            }
        }
        return res;
    }

    private List<Integer> copy(List<Integer> src){
        List<Integer> res = new LinkedList<>();
        for (Integer integer : src) {
            res.add(integer);
        }
        return res;
    }


}
