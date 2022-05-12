package algorithm.binary_tree;

import algorithm.utils.TreeNode;
import org.springframework.util.Assert;

/**
 * @author Ethan Zhang
 * @date 2022/5/4
 */
public class 根据后序数组重建搜索二叉树 {

    public static void main(String[] args) {
        int[] post = new int[]{1, 3, 2, 5, 7, 6, 4};

        TreeNode head = restoreByPost(post);

        Assert.isTrue(head.value == 4);
        Assert.isTrue(head.left.value == 2);
        Assert.isTrue(head.right.value == 6);

        head = restoreByPost(new int[0]);

        Assert.isTrue(head == null);
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

        TreeNode head = new TreeNode(array[end]);
        if (more == less) {
            return head;
        }

        head.left = restoreByPostRecursively(array, start, less);
        head.right = restoreByPostRecursively(array, more, end - 1);

        return head;
    }
}
