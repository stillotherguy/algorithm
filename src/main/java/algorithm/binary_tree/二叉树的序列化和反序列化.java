package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ethan Zhang
 * @date 2022/4/27
 */
public class 二叉树的序列化和反序列化 {

    private static final String EMPTY_NODE = "#";

    public static void main(String[] args) {
        TreeNode head = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6));

        System.out.println(preSerialize(head));
        System.out.println(preSerialize1(head));
    }


    public static String preSerialize(TreeNode head) {
        // 先序遍历序列化
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
        // 先序遍历序列化
        if (head == null) {
            return "#!";
        }

        String result = head.value + "!";
        result += preSerialize1(head.left);
        result += preSerialize1(head.right);

        return result;
    }

    public static TreeNode preDeserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] segments = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String segment : segments) {
            queue.offer(segment);
        }

        return preDeserializeRecursive(queue);
    }

    private static TreeNode preDeserializeRecursive(Queue<String> queue) {
        String value = queue.poll();
        if (EMPTY_NODE.equals(value)) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = preDeserializeRecursive(queue);
        head.right = preDeserializeRecursive(queue);

        return head;
    }
}
