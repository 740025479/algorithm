package org.wy.dataStructure.listnode;

public class Num83 {


    public ListNode deleteDuplicates2(ListNode head) {

        ListNode first = head;
        ListNode second = head;
        while (first != null) {
            while (first != null && first.val == second.val) {
                first = first.next;
            }
            if (first==null){
                /** 这一行不加就错了 */
                second.next = null;
                return head;}
            second.next = first;
            second = second.next;
            first = first.next;

        }
        return head;

    }

    /**
     * 官网题解
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head==null) return null;
        ListNode cur = head;
        while (cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

}
