package org.wy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        digui(candidates,target,0,new ArrayList<>(),res);
        return res;
    }

    private void digui(int[] candidates,int target, int index,List<Integer> temp,List<List<Integer>> res){

        if (target==0){
            res.add(temp);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            /** 剪枝，去重 */
            if (i>index&&candidates[i]==candidates[i-1])continue;

            if (candidates[i]<=target){
                List<Integer> can = new ArrayList<>();
                for (Integer member : temp) {
                    can.add(member);
                }
                can.add(candidates[i]);
                digui(candidates,target-candidates[i],i+1,can,res);
            }
        }

    }


}
