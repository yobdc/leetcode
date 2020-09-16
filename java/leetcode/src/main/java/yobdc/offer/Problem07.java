package yobdc.offer;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 前序第一项为root，在中序中找到root，root左边为左子树，右边为右子树。然后对左右子树递归。
 */
public class Problem07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1
                , inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder
            , int preStart
            , int preEnd
            , int[] inorder
            , int inStart
            , int inEnd) {
        if (preStart > preEnd
                || inStart > inEnd
                || preEnd >= preorder.length
                || inEnd >= inorder.length
        ) {
            return null;
        }
        int root = preorder[preStart];
        TreeNode node = null;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                node = new TreeNode(root);
                int leftSize = i - inStart;
                int rightSize = inEnd - i;
                TreeNode leftTree = buildTree(preorder
                        , preStart + 1
                        , preStart + leftSize
                        , inorder
                        , inStart
                        , inStart + leftSize - 1);
                TreeNode rightTree = buildTree(preorder
                        , preStart + leftSize + 1
                        , preStart + leftSize + rightSize
                        , inorder
                        , i + 1
                        , i + rightSize);
                node.left = leftTree;
                node.right = rightTree;
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Problem07 app = new Problem07();
        TreeNode root = app.buildTree(
                new int[]{1, 2, 3},
                new int[]{2, 3, 1}
        );
        System.out.println(root);
    }
}
