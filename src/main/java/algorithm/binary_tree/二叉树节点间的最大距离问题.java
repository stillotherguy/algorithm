package algorithm.binary_tree;

import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/5/18
 */
public class 二叉树节点间的最大距离问题 {

    public static void main(String[] args) {

    }

    public int maxDistance(TreeNode head) {
        return maxDistanceRecursive(head).maxDistance;
    }

    public ReturnType maxDistanceRecursive(TreeNode head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }

        ReturnType left = maxDistanceRecursive(head.left);
        ReturnType right = maxDistanceRecursive(head.right);

        int height = Math.max(left.height, right.height) + 1;
        int maxDistance = Math.max(left.height + right.height + 1, Math.max(left.maxDistance, right.maxDistance));

        return new ReturnType(maxDistance, height);
    }

    private static class ReturnType {
        private final int maxDistance;

        private final int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}
