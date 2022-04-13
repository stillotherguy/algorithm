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
 * 4 5 2 6 7 3 1
 *
 * @author Ethan Zhang
 * @date 2022/4/14
 */
public class 后序遍历 {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        postOrder1(root);

        postOrder2(root);
    }

    public static void postOrder1(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder1(root.left);
        postOrder1(root.right);

        System.out.println(root.value);
    }

    public static void postOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode top = null;
        while (!stack.isEmpty()) {
            top = stack.peek();
            if (top.left != null && root != top.left && root != top.right) {
                stack.push(top.left);
            } else if (top.right != null && root != top.right) {
                stack.push(top.right);
            } else {
                System.out.println(stack.pop().value);

                root = top;
            }
        }
    }
}
