package org.wy.dataStructure.listnode;

public class Num147 {

    /**
     * 插入排序的思想：将无序序列的第一个插入到有序序列中
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            cur = insertSort(res, cur);
        }
        return dummy.next;
    }

    private ListNode insertSort(ListNode res, ListNode cur) {
        ListNode previous = res;
        res = res.next;
        ListNode next = cur.next;
        while (res != null) {
            if (res.val <= cur.val) {
                previous = res;
                res = res.next;
            } else {

                previous.next = cur;
                cur.next = res;
                return next;
            }
        }
        previous.next = cur;
        cur.next = null;
        return next;
    }


    public ListNode insertionSortList2(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previous = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val < cur.val) {
                while (previous != cur) {
                    if (previous.next.val > next.val) {
                        ListNode temp1 = previous.next;
                        ListNode temp2 = next.next;
                        previous.next = next;
                        next.next = temp1;
                        cur.next = temp2;
                        previous = dummy;
                        break;
                    }
                    previous = previous.next;
                }

            } else {
                cur = next;
            }
        }
        return dummy.next;
    }

}
