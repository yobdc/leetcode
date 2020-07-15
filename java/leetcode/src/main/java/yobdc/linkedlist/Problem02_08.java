package yobdc.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 02.08. 环路检测
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 */
public class Problem02_08 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, true);
            }
            if (map.containsKey(cur.next)) {
                return cur.next;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Problem02_08 app = new Problem02_08();
//        app.detectCycle();
    }
}
