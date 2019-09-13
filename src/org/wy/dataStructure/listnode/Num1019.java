package org.wy.dataStructure.listnode;

import java.util.*;

public class Num1019 {


    public int[] nextLargerNodes(ListNode head) {


        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        Object[] arrList = list.toArray();
        int[] res = new int[arrList.length];
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = res.length-1; i >=0 ; i--) {
            if ((int)arrList[i]>=max){
                max=(int)arrList[i];
                res[i]=0;
                stack.push((int)arrList[i]);
                continue;
            }
            if ((int)arrList[i]>(int)arrList[i+1]&&(int)arrList[i]<res[i+1]){
                res[i]=res[i+1];
                stack.push((int)arrList[i]);
                continue;
            }
            while (!stack.isEmpty()){
                int temp = stack.peek();
                if (temp>(int)arrList[i]){
                    res[i]=temp;
                    stack.push((int)arrList[i]);
                    break;
                }else {
                    stack.pop();
                }
            }
        }
        return res;
    }

}
