package yobdc.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Problem82 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (map.containsKey(tmp.val)) {
                map.put(tmp.val, map.get(tmp.val) + 1);
            } else {
                map.put(tmp.val, 1);
            }
            tmp = tmp.next;
        }

        tmp = head;
        ListNode newHead = null;
        ListNode pre = null;
        while (tmp != null) {
            ListNode tmpNext = tmp.next;
            tmp.next = null;
            if (map.get(tmp.val) == 1) {
                if (newHead == null) {
                    newHead = tmp;
                    pre = tmp;
                } else {
                    pre.next = tmp;
                    pre = pre.next;
                }
            }
            tmp = tmpNext;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Problem82 app = new Problem82();

        int[] list = new int[]{1, 1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8};
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

        app.deleteDuplicates(head);
    }
}
