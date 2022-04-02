package algorithm.bit;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.util.Assert;

/**
 * @author Ethan Zhang
 * @date 2022/2/11
 */
public class TwoSolitaryNumber {

    public static void main(String[] args) {
        int[] input = new int[0];
        Assert.isTrue(solitary(input) == null, "illegal result");

        input = new int[]{111, 111, 222, 222, 333, 333, 444, 444, 555, 666};
        Assert.isTrue(Arrays.stream(solitary(input)).anyMatch(i -> i == 555), "illegal result");
        Assert.isTrue(Arrays.stream(solitary(input)).anyMatch(i -> i == 666), "illegal result");
    }

    public static int[] solitary(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int xor = xor(nums);
        int mask = 2;
        while ((xor ^ mask) == 0) {
            mask *= 2;
        }

        List<Integer> a = Lists.newArrayList();
        List<Integer> b = Lists.newArrayList();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] ^ mask) == 0) {
                a.add(nums[i]);
            } else {
                b.add(nums[i]);
            }
        }

        int resultA = xor(a.stream()
                           .filter(Objects::nonNull)
                           .mapToInt(Integer::intValue)
                           .toArray());

        int resultB = xor(b.stream()
                           .filter(Objects::nonNull)
                           .mapToInt(Integer::intValue)
                           .toArray());

        return new int[]{resultA, resultB};
    }

    public static int xor(int[] nums) {
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
