package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethan Zhang
 * @date 2022/4/17
 */
public class 未排序数组中累加和为给定值的最长子数组系列问题 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, -3, 3};

        System.out.println(maxLength(array, 6));
        System.out.println(maxLength(array, -100));
    }

    /**
     * @see algorithm.binary_tree.在二叉树中找到累加和合为指定值的最长路径长度
     */
    public static int maxLength(int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, -1);

        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (cache.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - cache.get(sum - target));
            }

            // TODO 顺序有关系吗
            if (!cache.containsKey(sum)) {
                cache.put(sum, i);
            }
        }

        return maxLen;
    }
}
