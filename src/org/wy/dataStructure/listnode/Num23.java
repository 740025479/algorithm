package org.wy.dataStructure.listnode;


/**
 * 分治思想＋合并两个有序链表
 */
public class Num23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length==0){return null;}
        return mergeKLists(lists,0,lists.length-1);

    }

    private ListNode mergeKLists(ListNode[] lists,int start,int end){

        if (start>=end){return lists[start];}
        int mid = start+(end-start)/2;
        ListNode left = mergeKLists(lists,start,mid);
        ListNode right = mergeKLists(lists,mid+1,end);
        return mergeTwo(left,right);

    }

    /** 合并两个有序链表 */
    private ListNode mergeTwo(ListNode h1, ListNode h2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (cur != null && h1 != null && h2 != null) {
            if (h1.val<=h2.val){
                cur.next=h1;
                h1 = h1.next;
            }else {
                cur.next=h2;
                h2=h2.next;
            }
            cur=cur.next;
        }
        if (h1==null){
            cur.next=h2;
        }
        if (h2==null){
            cur.next=h1;
        }
        return dummy.next;

    }

}
