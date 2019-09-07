package org.wy.dataStructure.listnode;

public class Num24 {

    public ListNode swapPairs(ListNode head) {

        if (head==null){
            return null;
        }
        ListNode cur = head;
        int count = 2;
        while (cur!=null && count>0){
            cur = cur.next;
            count--;
        }
        if (count==0){
            cur = head;
            ListNode res = cur.next;
            ListNode next = cur.next.next;
            cur.next.next = cur;
            cur.next = swapPairs(next);
            return res;
        }else {
            return head;
        }
    }


}
