package org.wy.dataStructure.listnode;

public class Num143 {

    ListNode left;
    boolean isStop;

    public void reorderList(ListNode head) {

        if (head == null) return;
        left = head;
        isStop = false;
        digui(head);

    }

    void digui(ListNode right) {
        if (right.next == null) {
            return;
        }
        right = right.next;
        digui(right);
        if (!isStop) {
            if (left == right) {
                left.next = null;
                isStop = true;
            }

            ListNode next = left.next;
            left.next = right;
            left = next;
            if (left.next == right) {
                right.next = null;
                isStop = true;
            } else {
                right.next = left;
            }
        }
    }

}
