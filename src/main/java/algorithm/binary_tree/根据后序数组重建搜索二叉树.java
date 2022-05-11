package algorithm.binary_tree;

import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/5/4
 */
public class 根据后序数组重建搜索二叉树 {

    public static void main(String[] args) {

    }

    public static TreeNode restoreByPost(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        return restoreByPostRecursively(array, 0, array.length - 1);
    }

    private static TreeNode restoreByPostRecursively(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int less = start;
        int more = end;
        for (int i = start; i < end; i++) {
            if (array[end] > array[i]) {
                less = i;
            } else {
                more = more == end ? end - 1 : i;
            }
        }

        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(array[end]);
        head.left = restoreByPostRecursively(array, start, less);
        head.right = restoreByPostRecursively(array, more, end - 1);

        return head;
    }
}
