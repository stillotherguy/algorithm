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
public class 二叉树按Zigzag打印 {

    public static void main(String[] args) {
        TreeNode head = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        printByZigzag1(head);
    }

    public static void printByZigzag1(TreeNode head) {
        if (head == null) {
            return;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(head);

        int level = 0;
        boolean positive = true;

        printLevel(level++, positive);

        TreeNode last = head;
        TreeNode nLast = null;
        while (!deque.isEmpty()) {
            if (positive) {
                head = deque.pollFirst();
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    deque.offerLast(head.left);
                }

                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    deque.offerLast(head.right);
                }
            } else {
                head = deque.pollLast();
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    deque.offerFirst(head.right);
                }

                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    deque.offerFirst(head.left);
                }
            }

            System.out.print(head.value + " ");
            if (last == head && !deque.isEmpty()) {
                last = nLast;
                nLast = null;
                positive = !positive;

                System.out.println();
                printLevel(level++, positive);
            }
        }
    }

    public static void printLevel(int level, boolean positive) {
        System.out.print("Level " + level + " from ");
        System.out.print(positive ? "left to right:" : "right to left");
    }
}
