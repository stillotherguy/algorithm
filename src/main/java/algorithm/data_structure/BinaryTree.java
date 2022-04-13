package algorithm.data_structure;

import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author Ethan Zhang
 * @date 2022/4/14
 */
public class BinaryTree {

    private TreeNode root;

    /**
     * 第i个节点的left在2i + 1, right在2i + 2
     */
    private static TreeNode createRecursive(List<Integer> nums, TreeNode cur, int i) {
        if (i < nums.size()) {
            cur = new TreeNode(nums.get(i));

            cur.left = createRecursive(nums, cur.left, 2 * i + 1);
            cur.right = createRecursive(nums, cur.right, 2 * i + 2);
        }

        return cur;
    }

    public static TreeNode create(List<Integer> nums) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = createRecursive(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7), binaryTree.root, 0);

        return binaryTree.root;
    }

}
