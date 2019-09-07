package org.wy.dataStructure.listnode;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 */
public class Num2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        /** 注释的代码没有保证末位是0的数字只有一位，即验证某链表代表的数字是0的条件不够充分 */
//        if (l1==null || l1.val==0){return l2;}
//        if (l2==null || l2.val==0){return l1;}

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int internal = 0;
        while (l1!=null&&l2!=null){
            int temp = l1.val+l2.val+internal;
            internal = temp>9?1:0;
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int temp = l1.val + internal;
            internal = temp>9?1:0;
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            l1=l1.next;
        }
        while (l2!=null){
            int temp = l2.val + internal;
            internal = temp>9?1:0;
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            l2=l2.next;
        }
        if (internal==1){
            cur.next=new ListNode(1);
        }
        return dummy.next;
    }


}
