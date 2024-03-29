package algorithm.data_structure;

import algorithm.utils.TreeNode;
import com.google.common.base.Preconditions;
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
        Preconditions.checkNotNull(nums);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = createRecursive(nums, binaryTree.root, 0);

        return binaryTree.root;
    }

    public static TreeNode create(Integer... nums) {
        Preconditions.checkNotNull(nums);

        return create(Lists.newArrayList(nums));
    }
}
