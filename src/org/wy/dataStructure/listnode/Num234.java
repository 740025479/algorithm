package org.wy.dataStructure.listnode;


/**
 * 递归解法不改变原始链表的结构，但是迭代法改变了
 * 迭代法空间复杂度低
 */

public class Num234 {

    /**
     * 递归解法
     * 空间复杂度：O(n)  因为递归栈占用空间
     * 时间复杂度：O(n)
     * @param head
     * @return
     */
    ListNode left;
    boolean isStop;
    boolean res;

    public boolean isPalindrome(ListNode head) {

        left = head;
        isStop=false;
        res=true;
        digui(head);
        return res;
    }

    private void digui(ListNode right) {

        if (right == null) return;
        digui(right.next);
        if (left == right || right.next == left) {
            isStop = true;
        }
        if (!isStop&&res) {
            if (right.val != left.val) {
                res = false;
            }else {
                left=left.next;
            }
        }
    }


    /**
     * 迭代解法：从中间节点开始往后的链表翻转，跟前半部分比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {

        if (head==null)return true;
        /** 快慢指针找到中间节点,边界条件画图分析！！！ */
        ListNode fast = head;
        ListNode slow = head;
        /** while中的条件不能保证fast不为null
         *           条件可以为 fast!=null&&fast.next!=null */
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=slow.next;

        ListNode previous = null;
        ListNode cur = slow;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=previous;
            previous = cur;
            cur = next;
        }
        while (previous!=null){
            if (head.val!=previous.val)return false;
            head=head.next;
            previous=previous.next;
        }
        return true;
    }



}
