package org.wy.dataStructure.listnode;

public class Num328 {

    public ListNode oddEvenList(ListNode head) {

        ListNode ji = new ListNode(-1);
        ListNode h = ji;
        ListNode ou = new ListNode(-1);
        ListNode nh = ou;
        int index =1;
        ListNode cur = head;
        while (cur!=null){
            if (index%2==1){
                ji.next=cur;
                ji=ji.next;
            }else {
                ou.next=cur;
                ou=ou.next;
            }
            cur=cur.next;
            index++;
        }
        ji.next=nh.next;
        ou.next=null;
        return h.next;
    }
}
