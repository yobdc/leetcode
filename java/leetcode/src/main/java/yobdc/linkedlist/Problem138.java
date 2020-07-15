package yobdc.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problem138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        for (Map.Entry<Node, Node> kv : map.entrySet()) {
            Node old = kv.getKey();
            Node newNode = kv.getValue();
            newNode.next = map.get(old.next);
            newNode.random = map.get(old.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Problem138 app = new Problem138();
        Node n1 = app.new Node(7);
        Node n2 = app.new Node(13);
        Node n3 = app.new Node(11);
        Node n4 = app.new Node(10);
        Node n5 = app.new Node(1);

        n1.next = n2;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n3.random = n5;
        n4.next = n5;
        n4.random = n3;
        n5.random = n1;

        app.copyRandomList(n1);
    }
}
