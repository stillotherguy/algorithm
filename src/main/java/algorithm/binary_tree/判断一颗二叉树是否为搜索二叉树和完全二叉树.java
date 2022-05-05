package algorithm.binary_tree;

import algorithm.data_structure.BinarySearchTree;
import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;

/**
 * @author Ethan Zhang
 * @date 2022/5/5
 */
public class 判断一颗二叉树是否为搜索二叉树和完全二叉树 {

    public static void main(String[] args) {
        TreeNode head = BinarySearchTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        System.out.println(isBST(head));

        head = BinaryTree.create(Lists.newArrayList(1, 3, 2, 4, 0, 6, 7));

        System.out.println(isBST(head));
    }

    public static boolean isBST(TreeNode head) {
        if (head == null) {
            return true;
        }

        boolean result = true;
        TreeNode pre = null;
        TreeNode mostRight = null;
        while (head != null) {
            mostRight = head.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != head) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = head;
                    head = head.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            if (pre != null && pre.value > head.value) {
                result = false;
            }

            pre = head;
            head = head.right;
        }

        return result;
    }
}
