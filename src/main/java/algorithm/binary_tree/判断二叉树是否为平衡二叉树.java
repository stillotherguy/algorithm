package algorithm.binary_tree;

import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/5/4
 */
public class 判断二叉树是否为平衡二叉树 {

    public static boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    private static ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }

        ReturnType left = process(head.left);
        ReturnType right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;

        boolean balanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;

        return new ReturnType(balanced, height);
    }


    private static class ReturnType {
        public boolean isBalanced;

        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
