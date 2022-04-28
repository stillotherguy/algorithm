package algorithm.binary_tree;

import algorithm.data_structure.BinarySearchTree;
import algorithm.utils.TreeNode;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Ethan Zhang
 * @date 2022/4/26
 */
public class 调整搜索二叉树中两个错误的节点 {

    public static void main(String[] args) {
        TreeNode head = BinarySearchTree.create(5, 6, 3, 2, 1, 4, 9, 7, 8);
        head.left.left.left.value = 9;
        head.right.right.value = 1;

        System.out.println(Arrays.toString(correct(head)));

        head = BinarySearchTree.create(5, 6, 3, 2, 1, 4, 9, 7, 8);
        head.left.left.value = 4;
        head.left.right.value = 2;

        System.out.println(Arrays.toString(correct(head)));
    }

    public static Integer[] correct(TreeNode head) {
        if (head == null) {
            return null;
        }

        return inOrder(head);
    }

    public static Integer[] inOrder(TreeNode head) {
        TreeNode pre = null;
        Integer[] result = new Integer[2];
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();

                if (pre != null && pre.value > head.value) {
                    // 考虑两个错误的数字挨着的情况
                    result[0] = result[0] == null ? pre.value : result[0];
                    result[1] = head.value;
                }

                pre = head;
                head = head.right;
            }
        }

        return result;
    }
}
