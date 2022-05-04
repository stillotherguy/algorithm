package algorithm.binary_tree;

import algorithm.data_structure.BinarySearchTree;
import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;

/**
 * @author Ethan Zhang
 * @date 2022/4/16
 */
public class Morris遍历 {

    public static void main(String[] args) {
        TreeNode head = BinarySearchTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        morrisTraverse(head);
        morrisTraverseToPreOrder(head);
        morrisTraverseToInOrder(head);
    }

    public static void morrisTraverse(TreeNode head) {
        if (head == null) {
            return;
        }

        TreeNode mostRight = null;
        TreeNode cur = head;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            cur = cur.right;
        }
    }

    public static void morrisTraverseToPreOrder(TreeNode head) {
        TreeNode mostRight = null;
        TreeNode cur = head;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    System.out.println(cur.value);

                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
            }

            cur = cur.right;
        }
    }

    public static void morrisTraverseToInOrder(TreeNode head) {
        TreeNode mostRight = null;
        TreeNode cur = head;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            System.out.println(cur.value);

            cur = cur.right;
        }
    }

    public static void morrisTraverseToPostOrder(TreeNode head) {
        if (head == null) {
            return;
        }

        TreeNode mostRight = null;
        TreeNode cur = head;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                if (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;

                    printEdge(cur.left);
                }
            }

            cur = cur.right;
        }

        printEdge(head);
    }

    private static void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.println(cur.value);

            cur = cur.right;
        }

        reverseEdge(tail);
    }

    private static TreeNode reverseEdge(TreeNode head) {
        TreeNode pre = null;
        TreeNode cur = head;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
