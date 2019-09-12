package org.wy.dataStructure.listnode;

public class Num725 {

    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] res = new ListNode[k];
        int length = 0;
        ListNode cur = root;
        while (cur!=null){
            length++;
            cur=cur.next;
        }
        cur=root;
        if (length<k){
            for (int i = 0; i < length; i++) {
                res[i]=cur;
                ListNode next=cur.next;
                cur.next=null;
                cur=next;
            }
            for (int i = length; i < k; i++) {
                res[i]=null;
            }
            return res;
        }
        int gap = length/k;
        int yuShu = length%k;
        for (int i = 0; i < k; i++) {
            res[i]=cur;
            for (int j = 0; j < gap-1; j++) {
                cur=cur.next;
            }
            if (yuShu-->0){
                cur=cur.next;
            }
            ListNode next = cur.next;
            cur.next=null;
            cur = next;

        }
        return res;
    }


}
