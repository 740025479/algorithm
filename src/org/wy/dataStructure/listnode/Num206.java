package org.wy.dataStructure.listnode;

/**
 * 反转链表
 */
public class Num206 {

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){return head;}
        ListNode res = reverseList(head.next);
        /** 递归关键点，递归到倒数第二个节点时，把该节点的后面一个节点的next域赋值为该节点，形成了一个环，然后把该节点的next域置为null */
        head.next.next=head;
        head.next=null;
        return res;
    }


    /**
     * 迭代解法
     */
    public ListNode reverseList2(ListNode head) {
        if (head==null||head.next==null){return head;}
        ListNode previous = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=previous;
            previous=cur;
            cur=next;
        }
        return previous;
    }

}
