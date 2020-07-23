package yobdc.linkedlist;

import java.util.Stack;

/**
 * 143. 重排链表
 */
public class Problem143 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode tmp = head;
        ListNode newHead = tmp;
        ListNode cur = newHead;
        tmp = tmp.next;
        tmp = reverseList(tmp);
        while (tmp != null) {
            cur.next = tmp;
            cur = tmp;
            ListNode tmpNext = tmp.next;
            tmp = reverseList(tmpNext);
        }
        head = newHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode tmp = head;
        while (tmp != null) {
            if (newHead == null) {
                newHead = tmp;
                tmp = tmp.next;
                newHead.next = null;
            } else {
                ListNode nextTmp = tmp.next;
                ListNode tmp2 = tmp;
                tmp2.next = newHead;
                newHead = tmp2;
                tmp = nextTmp;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Problem143 app = new Problem143();
        ListNode l1 = buildList(new int[]{1});
        app.reorderList(l1);
    }

    static ListNode buildList(int[] list) {
        Problem143 app = new Problem143();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < list.length; i++) {
            ListNode tmp = app.new ListNode(list[i]);
            if (head == null) {
                head = tmp;
            } else {
                tail.next = tmp;
            }
            tail = tmp;
        }
        return head;
    }
}
