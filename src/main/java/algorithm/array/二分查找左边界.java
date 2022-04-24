package algorithm.array;

/**
 * @author Ethan Zhang
 * @date 2022/4/23
 */
public class 二分查找左边界 {

    public static int leftBoundary(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 检查target比数组所有元素都大的越界情况以及非越界情况但找不到target的情况
        if (left >= array.length || array[left] != target) {
            return -1;
        }

        return left;
    }
}
