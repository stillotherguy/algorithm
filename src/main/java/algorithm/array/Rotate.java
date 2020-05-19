package algorithm.array;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class Rotate {

    // 暴力解法
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        int previous, temp;

        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // 占位法
    public void rotateI(int[] nums, int k) {
        k %= nums.length;

        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int prev = nums[i];
            int prevIndex = i;

            do {
                int next = (prevIndex + k) % nums.length;

                int temp = nums[next];
                nums[next] = prev;

                prev = temp;
                prevIndex = next;

                count++;
            } while (prevIndex != i);
        }
    }

    // 三次反转
    public void rotateII(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        };
    }
}
