package org.wy.dataStructure.listnode;

public class Num445 {


    /**
     * 1.补齐链表，短的链表在前面添0；
     * 2.递归至链表末尾，相加之后返回进位        利用递归的回溯特性，即可以得到前驱节点
     * 3.判断首位的进位
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int length1 = 0;
        int length2 = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1!=null){
            p1=p1.next;
            length1++;
        }
        while (p2!=null){
            p2=p2.next;
            length2++;
        }
        if (length1>length2){
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            for (int i = 0; i < length1 - length2; i++) {
                temp.next=new ListNode(0);
                temp=temp.next;
            }
            temp.next=l2;
            l2  = head.next;
        }
        if (length2>length1){
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            for (int i = 0; i < length2 - length1; i++) {
                temp.next=new ListNode(0);
                temp=temp.next;
            }
            temp.next=l1;
            l1  = head.next;
        }
        int internal = add(l1,l2);
        if (internal==1){
            ListNode res= new ListNode(1);
            res.next=l1;
            return  res;
        }
        return l1;

    }

    private int add(ListNode l1,ListNode l2){
        if (l1==null){return 0;}
        int internal = add(l1.next,l2.next);
        int sum = l1.val+l2.val+internal;
        l1.val=sum%10;
         internal = sum>9?1:0;
         return internal;

    }


}
