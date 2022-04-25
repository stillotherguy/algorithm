package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ethan Zhang
 * @date 2022/4/24
 */
public class 二叉树的按层打印 {

    public static void main(String[] args) {
        TreeNode head = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        printByLevel(head);
    }

    public static void printByLevel(TreeNode head) {
        if (head == null) {
            return;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        int level = 1;

        System.out.print(String.format("Level %d:", level++));

        TreeNode last = head;
        TreeNode nLast = null;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            System.out.print(cur.value);

            if (cur.left != null) {
                nLast = cur.left;
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                nLast = cur.right;
                queue.offer(cur.right);
            }

            // 最后一行就不打印了
            if (last == cur && !queue.isEmpty()) {
                last = nLast;

                System.out.print(String.format("\nLevel %d:", level++));
            }
        }
    }
}
