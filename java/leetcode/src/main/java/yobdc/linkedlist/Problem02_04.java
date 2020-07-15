package yobdc.linkedlist;

/**
 * 面试题 02.04. 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
 * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 */
public class Problem02_04 {
    class ListNode {
        int val;
        Problem02_04.ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, Problem02_04.ListNode n) {
            val = x;
            next = n;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode leftCur = null;
        ListNode leftPre = null;
        ListNode right = null;
        ListNode rightCur = null;
        ListNode rightPre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                if (left == null) {
                    left = cur;
                    leftCur = cur;
                    leftPre = cur;
                } else {
                    leftCur = cur;
                    leftPre.next = leftCur;
                    leftPre = leftPre.next;
                }
            } else {
                if (right == null) {
                    right = cur;
                    rightCur = cur;
                    rightPre = cur;
                } else {
                    rightCur = cur;
                    rightPre.next = rightCur;
                    rightPre = rightPre.next;
                }
            }
            cur = next;
        }

        if (leftCur != null) {
            leftCur.next = right;
        } else {
            return right;
        }
        return left;
    }

    public static void main(String[] args) {
        Problem02_04 app = new Problem02_04();

        ListNode node7 = app.new ListNode(1);
        ListNode node6 = app.new ListNode(2, node7);
//        ListNode node5 = app.new ListNode(1, node6);
//        ListNode node4 = app.new ListNode(5, node5);
//        ListNode node3 = app.new ListNode(3, node4);
//        ListNode node2 = app.new ListNode(1, node3);
//        ListNode node1 = app.new ListNode(2, node2);

        app.partition(node6, 2);
    }
}
