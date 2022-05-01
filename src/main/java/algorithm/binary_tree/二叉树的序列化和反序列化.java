package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.Stack;

/**
 * @author Ethan Zhang
 * @date 2022/4/27
 */
public class 二叉树的序列化和反序列化 {

    public static void main(String[] args) {
        TreeNode head = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6));

        System.out.println(preSerialize(head));
        System.out.println(preSerialize1(head));
    }

    public static String preSerialize(TreeNode head) {
        if (head == null) {
            return "";
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur == null) {
                builder.append("#!");
            } else {
                builder.append(cur.value)
                       .append("!");
            }

            if (cur != null) {
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }

        return builder.toString();
    }

    public static String preSerialize1(TreeNode head) {
        if (head == null) {
            return "#!";
        }

        String result = head.value + "!";
        result += preSerialize1(head.left);
        result += preSerialize1(head.right);

        return result;
    }
}
