package yobdc.linkedlist;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class Problem25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmpHead = null;
        ListNode tmpLast = null;
        ListNode preLast = null;
        ListNode newHead = null;
        ListNode cur = head;

        int index = 0;
        boolean firstReverse = false;
        while (index < k && cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            if (tmpHead == null) {
                tmpHead = tmp;
                tmpLast = tmp;
                tmp.next = null;
            } else {
                tmp.next = tmpHead;
                tmpHead = tmp;
            }
            if (++index == k) {
                if (preLast != null) {
                    preLast.next = tmpHead;
                }
                preLast = tmpLast;
                if (!firstReverse) {
                    firstReverse = true;
                    newHead = tmpHead;
                }
                tmpHead = null;
                index = 0;
            }

            if (index < k && cur == null) {
                ListNode lastSrc = tmpHead;
                ListNode lastDest = null;
                while (lastSrc != null) {
                    ListNode lastTmp = lastSrc;
                    lastSrc = lastSrc.next;
                    if (lastDest == null) {
                        lastDest = lastTmp;
                        lastDest.next = null;
                    } else {
                        lastTmp.next = lastDest;
                        lastDest = lastTmp;
                    }
                }
                preLast.next = lastDest;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        Problem25 app = new Problem25();

        ListNode n1 = app.new ListNode(1);
        ListNode n2 = app.new ListNode(2);
        ListNode n3 = app.new ListNode(3);
        ListNode n4 = app.new ListNode(4);
        ListNode n5 = app.new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        app.reverseKGroup(n1, 3);
    }
}
