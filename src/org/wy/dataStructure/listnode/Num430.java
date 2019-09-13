package org.wy.dataStructure.listnode;


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

public class Num430 {


    /**
     * 递归，必须知道哪些是要递归的，也就是哪些是重复的
     *
     *
     * 循环加递归
     * 此题中，while循环保证了长度，递归保证了深度  可参照下图思考   因此 要先从整体看，就应该是个循环，直到末尾，中间遇到有child的就处理
     *
     * 1-2-3-4-null
     *   | |
     *   | 5-null
     *   |
     *   6-7-null
     *
     *
     *
     * @param head
     * @return
     */
    public Node flatten1(Node head) {

        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur.child == null && cur.next != null) {
            cur = cur.next;
        }
        if ( cur.child == null) {
            return head;
        }

        while (cur!=null){
            Node next = cur.next;
            if (cur.child!=null){
                Node k = flatten1(cur.child);
                cur.next = k;
                cur.child = null;
                k.prev = cur;
                while (cur.next!=null){
                    cur=cur.next;
                }
                cur.next=next;
                if (next!=null) {
                    next.prev=cur;
                }
            }
            cur=next;
        }
        return head;

    }


    private Node dfs(Node head){


        Node cur = head;


        while (cur!=null){
            Node next = cur.next;
            head.prev = cur;
            if (cur.child!=null){
                Node k = dfs(cur.child);
                k.prev.next=next;
                if (next!=null) {
                    next.prev=k.prev;
                }
                cur.next = k;
                cur.child = null;
                head.prev=k.prev;
                k.prev = cur;
            }
            cur=next;
        }

        return head;

    }

    public Node flatten(Node head){
        if (head==null) {
            return null;
        }
        dfs(head);
        head.prev=null;
        return head;
    }


}
