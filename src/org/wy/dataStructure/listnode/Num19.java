package org.wy.dataStructure.listnode;

public class Num19 {


    /**
     * 双指针删除倒数第n个节点
     * 时间复杂度O(n)  只遍历一遍链表
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        int distance = n;
        while (distance-->0&&right!=null){
            right=right.next;
        }
        while (right.next!=null){
            right=right.next;
            left=left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

}
