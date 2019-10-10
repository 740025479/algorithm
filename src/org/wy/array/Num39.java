package org.wy.array;

import java.util.*;

public class Num39 {



    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        digui(candidates,target,0,new ArrayList<>(),res);

        return res;
    }


    private void digui(int[] candidates, int target,int index,List<Integer> temp, List<List<Integer>> res){

        if (target==0){
            res.add(temp);
            return ;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i]<=target){
                List<Integer> can = new ArrayList<>();
                for (Integer member : temp) {
                    can.add(member);
                }
                can.add(candidates[i]);
                digui(candidates,target-candidates[i],i,can,res);
            }
        }

    }


}
