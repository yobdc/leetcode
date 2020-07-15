package yobdc.linkedlist;

/**
 * 1367. 二叉树中的列表
 * <p>
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，
 * 那么请你返回 True ，否则返回 False 。
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * <p>
 * 链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree
 */
public class Problem1367 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (head.val == root.val) {
            boolean left = isSubPath(head.next, root.left);
            if (left) {
                return true;
            }
            boolean right = isSubPath(head.next, root.right);
            if (right) {
                return true;
            }
        } else {
            boolean left = isSubPath(head, root.left);
            if (left) {
                return true;
            }
            boolean right = isSubPath(head, root.right);
            if (right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem1367 app = new Problem1367();

        int[] list = new int[]{1, 4, 2, 6, 8};
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

        TreeNode root = app.new TreeNode(1);
        TreeNode n1 = app.new TreeNode(4);
        TreeNode n2 = app.new TreeNode(2);
        TreeNode n3 = app.new TreeNode(1);
        TreeNode n4 = app.new TreeNode(4);
        TreeNode n5 = app.new TreeNode(2);
        TreeNode n6 = app.new TreeNode(6);
        TreeNode n7 = app.new TreeNode(8);
        TreeNode n8 = app.new TreeNode(1);
        TreeNode n9 = app.new TreeNode(3);

        root.left = n1;
        n1.right = n2;
        n2.left = n3;
        root.right = n4;
        n4.left = n5;
        n5.left = n6;
        n5.right = n7;
        n7.left = n8;
        n7.right = n9;

        System.out.println(app.isSubPath(head, root));
    }

}
