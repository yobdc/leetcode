package yobdc.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 142. 环形链表 II
 */
public class Problem142 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (map.containsKey(cur)) {
                return cur;
            } else {
                map.put(cur, 1);
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Problem142 app = new Problem142();

        int[] list = new int[]{3, 2, 0, -4};
        ListNode head = null;
        ListNode tail = null;
        ListNode cycle = null;
        for (int i = 0; i < list.length; i++) {
            ListNode tmp = app.new ListNode(list[i]);
            if (i == 1) {
                cycle = tmp;
            }
            if (head == null) {
                head = tmp;
            } else {
                tail.next = tmp;
            }
            tail = tmp;
        }

        tail.next = cycle;

        app.detectCycle(head);
    }
}
