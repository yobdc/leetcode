package yobdc.offer;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class Problem06 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode newHead = head;
        ListNode next = null;
        if (head == null) {
            return new int[]{};
        }
        int size = 0;
        if (head.next != null) {
            next = head.next;
            newHead.next = null;
            size++;
        } else {
            size = 1;
        }
        while (next != null) {
            ListNode tmp = next.next;
            next.next = newHead;
            newHead = next;
            next = tmp;
            size++;
        }
        int[] result = new int[size];
        int i = 0;
        while (newHead != null) {
            result[i] = newHead.val;
            i++;
            newHead = newHead.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem06 app = new Problem06();
        int[] list = new int[]{3};
        Problem06.ListNode head = null;
        Problem06.ListNode tail = null;
        for (int i = 0; i < list.length; i++) {
            Problem06.ListNode tmp = app.new ListNode(list[i]);
            if (head == null) {
                head = tmp;
            } else {
                tail.next = tmp;
            }
            tail = tmp;
        }
        System.out.println(app.reversePrint(head));
    }
}
