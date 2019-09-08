package org.wy.dataStructure.listnode;

public class Num92 {

    public ListNode reverseBetween2(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }
        int index = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode k = null;
        ListNode previous = null;
        while (index < m && cur != null) {

            if (index == m - 1) {
                k = cur;
            }
            cur = cur.next;
            index++;
        }
        while (index >= m && index <= n) {

            ListNode next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
            index++;
        }

        k.next.next = cur;
        k.next = previous;
        return dummy.next;
    }


    /**
     * 递归解法
     * 好处在于：通过归的过程，也就是回溯，可以拿到前面的节点，因为单链表只能通过前面的节点拿到后面的节点，根据后面的节点无法推出前面的节点，此乃递归的究极好处
     */
    ListNode left;
    boolean isStop;
    void recurseAndReverse(ListNode right, int m, int n) {
        if (n==1){return;}
        if (m>1){left=left.next;}
        right=right.next;
        recurseAndReverse(right,m-1,n-1);
        if (left==right||right.next==left){isStop=true;}
        if (!isStop){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;

            /** 更新操作不要忘了 */
            left=left.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {

        left=head;
        isStop=false;
        recurseAndReverse(head,m,n);
        return head;
    }





}
