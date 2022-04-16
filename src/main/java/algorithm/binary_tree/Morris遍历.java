package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;

/**
 * @author Ethan Zhang
 * @date 2022/4/16
 */
public class Morris遍历 {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        morrisTraverse(root);
    }

    public static void morrisTraverse(TreeNode head) {
        if (head == null) {
            return;
        }

        TreeNode cur = head;
        TreeNode mostRight = null;
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
}
