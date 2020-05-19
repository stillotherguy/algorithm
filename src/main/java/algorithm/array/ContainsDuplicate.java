package algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicateI(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
