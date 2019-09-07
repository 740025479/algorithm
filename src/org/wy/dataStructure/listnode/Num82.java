package org.wy.dataStructure.listnode;

public class Num82 {


    public ListNode deleteDuplicates2(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        ListNode cur = head;
        while (cur != null) {
            int count = 1;
            while (cur.next != null && cur.val == cur.next.val) {
                count++;
                cur = cur.next;
            }
            if (count == 1) {
                res.next = cur;
                res = res.next;
            }
            if (cur.next == null) {
                res.next = null;
                return dummy.next;
            }
            cur = cur.next;
        }
        return null;

    }


    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head==null) return null;

        if (head.next!=null && head.val == head.next.val){
            while (head!=null && head.next!=null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

}
