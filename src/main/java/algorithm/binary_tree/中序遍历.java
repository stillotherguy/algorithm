package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.Stack;

/**
 *       1
 *   2      3
 * 4   5  6   7
 *
 * 4 2 5 1 6 3 7
 * @author Ethan Zhang
 * @date 2022/4/13
 */
public class 中序遍历 {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        inOrder1(root);
    }

    public static void inOrder1(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder1(root.left);

        System.out.println(root.value);

        inOrder1(root.right);
    }

    public static void inOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode left = stack.pop();

                System.out.println(left.value);

                stack.push(left.right);
            }
        }
    }
}
