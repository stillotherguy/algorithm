package algorithm.binary_tree;

import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/5/6
 */
public class 通过有序数组生成平衡搜索二叉树 {

    public static TreeNode generateBST(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            return null;
        }

        return generateBSTRecursive(sortedArray, 0, sortedArray.length - 1);
    }

    private static TreeNode generateBSTRecursive(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(sortedArray[mid]);
        head.left = generateBSTRecursive(sortedArray, 0, mid - 1);
        head.right = generateBSTRecursive(sortedArray, mid + 1, end);

        return head;
    }
}
