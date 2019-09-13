package org.wy.dataStructure.listnode;

public class MyLinkedList {

    private class MyListNode {
        private int val;
        private MyListNode next;

        public MyListNode(int val) {
            this.val = val;
        }
    }

    private MyListNode head;
    private MyListNode tail;
    private int length;
    private MyListNode dummy;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

        dummy = new MyListNode(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index + 1 > length||index<0) {
            return -1;
        }
        MyListNode cur = dummy.next;
        int temp = 0;
        while (temp < index) {
            cur = cur.next;
            temp++;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyListNode next = dummy.next;
        dummy.next = new MyListNode(val);
        dummy.next.next = next;
        head = dummy.next;
        length++;
        if (length == 1) {
            tail = dummy.next;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (length == 0) {
            dummy.next = new MyListNode(val);
            head = dummy.next;
            tail = dummy.next;
        } else {
            tail.next = new MyListNode(val);
            tail.next.next = null;
            tail = tail.next;
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index  > length) {
            return;
        }
        if (index  == length) {
            addAtTail(val);
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        MyListNode cur = dummy.next;
        int temp = 0;
        while (temp < index - 1) {
            cur = cur.next;
            temp++;
        }
        MyListNode next = cur.next;
        cur.next = new MyListNode(val);
        cur.next.next = next;
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index + 1 > length) {
            return;
        }
        if (index == 0) {
            dummy.next = head.next;
            head = dummy.next;
        } else {
            MyListNode cur = dummy.next;
            int temp = 0;
            while (temp < index - 1) {
                cur = cur.next;
                temp++;
            }
            MyListNode next = cur.next.next;
            cur.next = next;
            if (index==length-1){
                tail=cur;
            }

        }
        length--;
    }


}
