package algorithm.binary_tree;

import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/4/16
 */
public class 二叉树的最小深度 {

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return process(root, 1);
    }

    private int process(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            return level;
        }

        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(ans, process(root.left, level + 1));
        }

        if (root.right != null) {
            ans = Math.min(ans, process(root.right, level + 1));
        }

        return ans;
    }
}
