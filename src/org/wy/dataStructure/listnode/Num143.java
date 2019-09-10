package org.wy.dataStructure.listnode;

public class Num143 {

    /**
     * 第一种方法利用递归做的
     */
    ListNode left;
    boolean isStop;
    public void reorderList1(ListNode head) {

        if (head == null) {
            return;
        }
        left = head;
        isStop = false;
        digui(head);

    }

    private void digui(ListNode right) {
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
            if (next == right) {
                right.next = null;
                isStop = true;
            } else {
                right.next = left;
            }
        }
    }


    /**
     * 第二种用迭代做，
     * 1.遍历得到总长度
     * 2.取到中间长度，并从其位置开始反转
     * 3.合并两链表
     * @param head
     */
    public void reorderList2(ListNode head) {


        if (head==null){return;}
        int length = 0;
        int startReverse = 0;
        ListNode cur = head;
        ListNode reverseHead = null;
        ListNode cur2 = head;
        while (cur!=null){
            cur=cur.next;
            length++;
        }
        startReverse = (length+1)/2;
        for (int i = 1; i < startReverse; i++) {
            cur2 = cur2.next;
        }

        reverseHead = reverse(cur2.next);
        cur2.next=null;
        merge(head,reverseHead);

    }

    private ListNode reverse(ListNode head){
        if (head==null){return null;}
        ListNode cur = head;
        ListNode previous = null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        return previous;
    }

    private void merge(ListNode head1,ListNode head2){
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1!=null&&p2!=null){
//            ListNode next = p1.next;
//            p1.next=p2;
//            p2.next=next;
//            p1=p1.next;
//            p2=p2.next;
            /** 上面的是错的，因为p1.next被赋了别的值，想往前进就不能p1=p1.next */
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }




}
