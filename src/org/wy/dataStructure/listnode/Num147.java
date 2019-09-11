package org.wy.dataStructure.listnode;

public class Num147 {

    /**
     * 插入排序的思想：将无序序列的第一个插入到有序序列中
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        if (head==null){return null;}
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode res = dummy;
        ListNode cur = head.next;
        head.next=null;
        while (cur!=null){
            cur = insertSort(res,cur);
        }
        return dummy.next;
    }

    private ListNode insertSort(ListNode res, ListNode cur) {
        ListNode previous = res;
        res=res.next;
        ListNode next = cur.next;
        while (res!=null){
            if (res.val<=cur.val){
                previous=res;
                res=res.next;
            }else {

                previous.next=cur;
                cur.next=res;
                return next;
            }
        }
        previous.next=cur;
        cur.next=null;
        return next;
    }

}
