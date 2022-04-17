package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;

/**
 * @author Ethan Zhang
 * @date 2022/4/17
 */
public class 找到二叉树中的最大搜索二叉子树 {

    public static void main(String[] args) {
        TreeNode head = BinaryTree.create(Lists.newArrayList(9, 10, 13, 4, 14, 20, 16, 2, 5, 11, 15));

        TreeNode maxBSTHead = findMaxBST(head);
        System.out.println(maxBSTHead.value);
    }

    public static TreeNode findMaxBST(TreeNode head) {
        return findSearchTreeRecursive(head).maxBSTHead;
    }

    private static ReturnType findSearchTreeRecursive(TreeNode head) {
        if (head == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ReturnType left = findSearchTreeRecursive(head.left);
        ReturnType right = findSearchTreeRecursive(head.right);

        int min = Math.min(head.value, Math.min(left.min, right.min));
        int max = Math.max(head.value, Math.max(left.max, right.max));
        int maxBSTSize = Math.max(left.maxBSTSize, right.maxBSTSize);
        TreeNode maxBSTHead = left.maxBSTSize > right.maxBSTSize ? left.maxBSTHead : right.maxBSTHead;
        if (left.maxBSTHead == head.left && left.max < head.value && right.maxBSTHead == head.right && right.min > head.value) {
            maxBSTSize = left.maxBSTSize + right.maxBSTSize + 1;
            maxBSTHead = head;
        }

        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

    private static class ReturnType {
        private final TreeNode maxBSTHead;

        private final int maxBSTSize;

        private final int min;

        private final int max;

        private ReturnType(TreeNode maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
        }
    }
}
