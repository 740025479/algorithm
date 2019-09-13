package org.wy.dataStructure.listnode;

import java.util.HashMap;

public class Num1171 {


    public ListNode removeZeroSumSublists(ListNode head) {

        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        map.put(0,dummy);
        ListNode cur = head;
        int preSum = 0;
        while (cur!=null){
            preSum+=cur.val;

            if (map.containsKey(preSum)){


                /** 在map中清除两个前缀和相等的节点之间的元素的前缀和
                 *  否则  若map中并没有删去两个前缀和相同的结点之间的结点，导致之后可能某些结点的前缀和错误匹配了本应该被删去的节点*/
                ListNode temp = map.get(preSum);
                int sum = preSum+temp.next.val;
                while (sum!=preSum){
                    map.remove(sum);
                    temp=temp.next;
                    sum+=temp.next.val;
                }






                map.get(preSum).next=cur.next;
            }else {
                map.put(preSum,cur);
            }
            cur=cur.next;
        }
        return dummy.next;

    }

}
