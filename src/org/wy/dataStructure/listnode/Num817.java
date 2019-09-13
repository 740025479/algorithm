package org.wy.dataStructure.listnode;

import java.util.HashSet;

public class Num817 {


    public int numComponents(ListNode head, int[] G) {

        int res = 0;
        boolean isStart  = false;
        HashSet<Integer> set = resolveArray(G);
        int[] hash = new int[10000];
        for (int i = 0; i < G.length; i++) {
            hash[G[i]]++;
        }
        ListNode cur = head;
        while (cur!=null){
            int temp = cur.val;
            if (hash[temp]>0&&!isStart){
                isStart=true;
            }
            if (hash[temp]==0&&isStart){
                res++;
                isStart=false;
            }
            cur=cur.next;
        }
        if (isStart==true){res++;}
        return res;

    }

    private HashSet resolveArray(int[] G){
        HashSet<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        return set;
    }



}
