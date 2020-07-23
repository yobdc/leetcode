package yobdc.linkedlist;

import java.util.Stack;

/**
 * 445. 两数相加 II
 */
public class Problem445 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode tmp = l1;
        while (tmp != null) {
            s1.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = l2;
        while (tmp != null) {
            s2.push(tmp.val);
            tmp = tmp.next;
        }
        ListNode newHead = null;
        boolean needAdd = false;
        while (!s1.empty() || !s2.empty()) {
            Integer i1 = 0;
            Integer i2 = 0;
            if (!s1.empty()) {
                i1 = s1.pop();
            }
            if (!s2.empty()) {
                i2 = s2.pop();
            }
            Integer sum = i1 + i2;
            if (needAdd) {
                sum += 1;
                needAdd = false;
            }
            tmp = new ListNode(sum % 10);
            if (newHead != null) {
                tmp.next = newHead;
            }
            newHead = tmp;
            if (sum >= 10) {
                needAdd = true;
            }
        }
        if (needAdd) {
            tmp = new ListNode(1);
            if (newHead != null) {
                tmp.next = newHead;
                newHead = tmp;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Problem445 app = new Problem445();
        ListNode l1 = buildList(new int[]{9});
        ListNode l2 = buildList(new int[]{1});
        app.addTwoNumbers(l1, l2);
    }

    static ListNode buildList(int[] list) {
        Problem445 app = new Problem445();
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
