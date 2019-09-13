package org.wy.dataStructure.listnode;

public class Num876 {

    public ListNode middleNode(ListNode head) {

        if (head==null){return null;}
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

}
