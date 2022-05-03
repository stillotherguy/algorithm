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

    private static final String EMPTY_VALUE = "#";

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
        if (EMPTY_VALUE.equals(value)) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = preDeserializeRecursive(queue);
        head.right = preDeserializeRecursive(queue);

        return head;
    }

    public static String serializeByLevel(TreeNode head) {
        if (head == null) {
            return EMPTY_VALUE;
        }

        String res = head.value + "!";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += EMPTY_VALUE;
            }

            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += EMPTY_VALUE;
            }
        }

        return res;
    }

    public static TreeNode deserializeByLevel(String str) {
        String[] segments = str.split("!");

        int index = 0;

        TreeNode head = generateNode(segments[index++]);

        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left = generateNode(segments[index++]);
            cur.right = generateNode(segments[index++]);

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return head;
    }

    private static TreeNode generateNode(String segment) {
        if (segment.equals("#")) {
            return null;
        }

        return new TreeNode(Integer.parseInt(segment));
    }
}
