package bit;

import sun.jvm.hotspot.utilities.Assert;

/**
 * @author Ethan Zhang
 * @date 2022/2/11
 */
public class OneSolitaryNumber {

    public static void main(String[] args) {
        int[] input = null;
        Assert.that(solitary(input) == -1, "illegal result");

        input = new int[0];
        Assert.that(solitary(input) == -1, "illegal result");

        input = new int[]{111, 111, 222, 222, 333, 333, 444, 444, 555};
        Assert.that(solitary(input) == 555, "illegal result");
    }

    public static int solitary(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
