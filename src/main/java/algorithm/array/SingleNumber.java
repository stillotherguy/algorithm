package algorithm.array;

import java.util.Arrays;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[1];
        }

        Arrays.sort(nums);

        Integer prev = nums[0];
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            } else {
                if (count == 1) {
                    result = nums[i];
                    break;
                }

                count = 1;
            }

            prev = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        new SingleNumber().singleNumber(new int[]{2, 2, 1});
    }
}
