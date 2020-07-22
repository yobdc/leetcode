package yobdc.linkedlist;

/**
 * 148. 排序链表
 */
public class Problem148 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode newHead =  sortList(head, null);
        return newHead;
    }

    public ListNode sortList(ListNode head, ListNode end) {
        if (head == end) {
            return head;
        }
        if (end != null) {
            end.next = null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2Start = slow.next;
        ListNode l2End = fast.next;
        if (l2End != null) {
            l2End.next = null;
        }
        slow.next = null;

        ListNode l1 = sortList(head, slow);
        ListNode l2 = sortList(l2Start, l2End);

        ListNode newHead = null;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (newHead == null) {
                    newHead = l1;
                    pre = newHead;
                } else {
                    pre.next = l1;
                    pre = pre.next;
                }
                l1 = l1.next;
            } else {
                if (newHead == null) {
                    newHead = l2;
                    pre = newHead;
                } else {
                    pre.next = l2;
                    pre = pre.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            newHead = append(newHead, l1);
        }
        if (l2 != null) {
            newHead = append(newHead, l2);
        }
        return newHead;
    }

    public ListNode append(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        if (cur == null) {
            return l2;
        }
        if (cur.next == null) {
            cur.next = l2;
            return cur;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = l2;
        return l1;
    }

    public static void main(String[] args) {
        Problem148 app = new Problem148();

        int[] list = new int[]{4};
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

        app.sortList(head);
    }
}
