package yobdc;

public class Problem2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lNode = l1;
        ListNode rNode = l2;
        int sum = lNode.val + rNode.val;
        int stage = sum >= 10 ? 1 : 0;
        ListNode start = new ListNode(sum % 10);
        ListNode current = start;
        lNode = l1.next;
        rNode = l2.next;

        ListNode tmp = null;
        while (lNode != null || rNode != null) {
            sum = 0;
            if (lNode != null) {
                sum += lNode.val;
            }
            if (rNode != null) {
                sum += rNode.val;
            }
            sum += stage;
            stage = sum >= 10 ? 1 : 0;
            tmp = new ListNode(sum % 10);
            current.next = tmp;
            current = current.next;
            if (lNode != null) {
                lNode = lNode.next;
            }
            if (rNode != null) {
                rNode = rNode.next;
            }
        }
        if(stage>0) {
            tmp = new ListNode(stage);
            current.next = tmp;
        }
        return start;
    }

    ListNode makeL1() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }
    ListNode makeL2() {
        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        return r1;
    }
}
