package algorithm.data_structure;

import algorithm.utils.TreeNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author Ethan Zhang
 * @date 2022/4/12
 */
public class BinarySearchTree {

    private TreeNode root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }

        if (current.value == value) {
            return true;
        }

        return value > current.value ? containsRecursive(current.right, value) : containsRecursive(current.left, value);
    }

    public static TreeNode create(List<Integer> values) {
        Preconditions.checkNotNull(values);

        BinarySearchTree binaryTree = new BinarySearchTree();
        for (Integer value : values) {
            binaryTree.add(value);
        }

        return binaryTree.root;
    }

    public static TreeNode create(Integer... values) {
        Preconditions.checkNotNull(values);

        return create(Lists.newArrayList(values));
    }

    public TreeNode getRoot() {
        return root;
    }
}
