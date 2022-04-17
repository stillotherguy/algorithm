package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethan Zhang
 * @date 2022/4/17
 */
public class 在二叉树中找到累加和合为指定值的最长路径长度 {

    public static void main(String[] args) {
        TreeNode head = BinaryTree.create(Lists.newArrayList(1, 2, 3, -3, -3, 6, 7));

        System.out.println(getMaxLen(head, 0));
    }

    /**
     * @see algorithm.array.未排序数组中累加和为给定值的最长子数组系列问题
     */
    public static int getMaxLen(TreeNode head, int target) {
        if (head == null) {
            return 0;
        }

        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);

        return getMaxLenRecursive(head, target, 0, 1, 0, cache);
    }

    private static int getMaxLenRecursive(TreeNode head, int target, int preSum, int level, int maxLen,
                                          Map<Integer, Integer> cache) {
        if (head == null) {
            return maxLen;
        }

        int sum = preSum + head.value;
        if (!cache.containsKey(sum)) {
            cache.put(sum, level);
        }

        // 注意和上面if的顺序
        if (cache.containsKey(sum - target)) {
            maxLen = Math.max(maxLen, cache.get(sum - target));
        }

        maxLen = getMaxLenRecursive(head.left, target, sum, level + 1, maxLen, cache);
        maxLen = getMaxLenRecursive(head.right, target, sum, level + 1, maxLen, cache);

        if (level == cache.get(sum)) {
            cache.remove(sum);
        }

        return maxLen;
    }
}
