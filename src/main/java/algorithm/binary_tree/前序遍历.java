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
 * 1 2 4 5 3 6 7
 * @author Ethan Zhang
 * @date 2022/4/13
 */
public class 前序遍历 {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        preOrder1(root);
    }

    public static void preOrder1(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);

        preOrder1(root.left);
        preOrder1(root.right);
    }

    public static void preOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.value);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
}
