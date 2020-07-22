package yobdc.linkedlist;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 */
public class Problem1171 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        ListNode startSum = head;
        ListNode preStartSum = null;
        ListNode endSum = startSum;
        while (startSum != null && endSum != null) {
            sum = 0;
            boolean sumed = false;
            while (endSum != null) {
                sum += endSum.val;
                if (sum == 0) {
                    sumed = true;
                    if (startSum == head) {
                        head = endSum.next;
                        startSum = head;
                    } else {
                        if (preStartSum != null) {
                            preStartSum.next = endSum.next;
                        }
                        startSum = preStartSum.next;
                    }
                    endSum = head;
                    continue;
                }
                endSum = endSum.next;
            }
            if (!sumed) {
                preStartSum = startSum;
                if (startSum != null) {
                    startSum = startSum.next;
                }
                endSum = startSum;
            } else {
                preStartSum = null;
                startSum = head;
                endSum = startSum;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        Problem1171 app = new Problem1171();

        int[] list = new int[]{0};
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

        app.removeZeroSumSublists(head);
    }
}
