package org.wy.dataStructure.listnode;

public class Num25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = head;
            ListNode previous = null;
            while (count > 0) {
                ListNode next = cur.next;
                cur.next = previous;
                previous = cur;
                cur = next;
                count--;
            }
            if (cur!=null){
                head.next = reverseKGroup(cur,k);
            }
            return previous;
        }else {
            return head;
        }

    }
}
