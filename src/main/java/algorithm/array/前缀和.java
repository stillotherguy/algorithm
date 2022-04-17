package algorithm.array;

/**
 *   1 1 1 1 1 1
 * 0 1 1 1 1 1 1
 *
 *
 * @author Ethan Zhang
 * @date 2022/1/20
 */
public class 前缀和 {

    private final int[] nums;

    public 前缀和(int[] nums) {
        this.nums = new int[nums.length + 1];

        int sum = this.nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            this.nums[i + 1] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right > nums.length - 1 || left > right) {
            return 0;
        }

        return this.nums[right + 1] - this.nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new 前缀和(new int[]{1, 2, 3, 4, 5}).sumRange(0, 4));
        System.out.println(new 前缀和(new int[]{1, 2, 3, 4, 5}).sumRange(0, 2));
    }
}
