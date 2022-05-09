package algorithm.binary_tree;

import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/5/9
 */
public class 在二叉树中找到两个节点的最近公共祖先 {

    public static TreeNode findParent(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }

        TreeNode left = findParent(head.left, o1, o2);
        TreeNode right = findParent(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }

        return left != null ? left : right;
    }
}
