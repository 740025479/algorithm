package org.wy.dataStructure.listnode;

public class Num86 {



    public ListNode partition(ListNode head, int x) {

        if (head==null) return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode xiao = dummy1;
        ListNode daDeng = dummy2;
        ListNode cur = head;
        while (cur!=null){
            if (cur.val<x){
                xiao.next = cur;
                xiao = xiao.next;
            }else {
                daDeng.next = cur;
                daDeng = daDeng.next;
            }
            cur = cur.next;
        }

        /** 截断后面的节点 */
        daDeng.next=null;

        xiao.next=dummy2.next;
        return dummy1.next;

    }

}
