package test;


class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class TestListNode {

    public static ListNode deepCopy(ListNode head){

        ListNode dummpy = new ListNode(1);
        ListNode cur = dummpy;
        ListNode random = dummpy.next;
        while (head!=null){
            cur.next = new ListNode(head.val);
            head=head.next;
            cur=cur.next;
        }
        return dummpy.next;

    }


    public static ListNode deepCopy2(ListNode head){
        if (head==null){return head;}
        ListNode newNode = new ListNode(head.val);
        newNode.next = deepCopy2(head.next);
        return newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode sec = new ListNode(4);
        head.next=sec;
        ListNode newHead = deepCopy2(head);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }

}
