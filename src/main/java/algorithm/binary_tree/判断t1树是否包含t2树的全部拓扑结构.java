package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/4/26
 */
public class 判断t1树是否包含t2树的全部拓扑结构 {

    public static void main(String[] args) {
        final TreeNode t1 = BinaryTree.create(1, 2, 3, 4, 5, 6, 7, 8);
        final TreeNode t2 = BinaryTree.create(3, 4, 5, 8);
        final TreeNode t3 = BinaryTree.create(2, 4, 5, 8);

        System.out.println(contains(t1, t2));
        System.out.println(contains(t1, t3));
    }

    public static boolean contains(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }

        if (t1 == null) {
            return false;
        }

        return containsRecursive(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    private static boolean containsRecursive(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }

        if (t1 == null || t1.value != t2.value) {
            return false;
        }

        return containsRecursive(t1.left, t2.left) && containsRecursive(t1.right, t2.right);
    }
}
