package yobdc.linkedlist;

/**
 * 86. 分隔链表
 */
public class Problem86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode cur = head;
        ListNode left = null;
        ListNode right = null;
        while (cur != null) {
            if (cur.val < x) {
                if (leftHead == null) {
                    leftHead = cur;
                    left = cur;
                } else {
                    left.next = cur;
                    left = left.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = cur;
                    right = cur;
                } else {
                    right.next = cur;
                    right = right.next;
                }
            }
            cur = cur.next;
        }
        if (left == null) {
            return rightHead;
        }
        if (right != null) {
            right.next = null;
        }
        left.next = rightHead;
        return leftHead;
    }

    public static void main(String[] args) {
        Problem86 app = new Problem86();

        int[] list = new int[]{1, 4, 3, 2, 5, 2};
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

        app.partition(head, 3);
    }
}
