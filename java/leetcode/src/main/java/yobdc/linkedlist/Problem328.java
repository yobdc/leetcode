package yobdc.linkedlist;

import java.util.List;

/**
 * 328. 奇偶链表
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class Problem328 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddList = null;
        ListNode oddCur = null;
        ListNode oddPre = null;
        ListNode evenList = null;
        ListNode evenCur = null;
        ListNode evenPre = null;
        ListNode cur = head;

        int index = 0;
        while (cur != null) {
            index++;
            if (index % 2 == 1) {
                if (oddList == null) {
                    oddList = cur;
                    oddCur = cur;
                } else {
                    oddCur.next = cur;
                    oddPre = cur;
                    oddCur = oddCur.next;
                }
            } else {
                if (evenList == null) {
                    evenList = cur;
                    evenCur = cur;
                } else {
                    evenCur.next = cur;
                    evenPre = cur;
                    evenCur = evenCur.next;
                }
            }
            cur = cur.next;
        }
        if (index % 2 == 0) {
            if (oddPre != null) {
                oddPre.next = evenList;
            }
        } else {
            oddCur.next = evenList;
            if (evenPre != null) {
                evenPre.next = null;
            }
            if (evenCur != null) {
                evenCur.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Problem328 app = new Problem328();
        ListNode node7 = app.new ListNode(3);
        ListNode node6 = app.new ListNode(2, node7);
        ListNode node5 = app.new ListNode(1, node6);
        ListNode node4 = app.new ListNode(5, node5);
//        ListNode node3 = app.new ListNode(3, node4);
//        ListNode node2 = app.new ListNode(1, node3);
//        ListNode node1 = app.new ListNode(2, node2);
        app.oddEvenList(node4);
    }
}
