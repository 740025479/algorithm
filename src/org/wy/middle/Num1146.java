package org.wy.middle;

import javafx.beans.binding.IntegerBinding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1146 {


    private Map<Integer,Map<Integer,Integer>> map;
    private int snapId;
    public Num1146(int length) {
        snapId=0;
        map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(i,new HashMap<>());
        }

    }

    public void set(int index, int val) {
        map.get(index).put(snapId,val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        Map<Integer,Integer> temp = map.get(index);
        while (snap_id>-1){
            if (temp.get(snap_id)!=null){
                return temp.get(snap_id);
            }
            snap_id--;
        }
        return 0;
    }



}
