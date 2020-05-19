package algorithm.array;

import java.util.Arrays;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class QuickSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int basic = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (nums[right] >= basic && left < right) {
                right--;
            }

            while (nums[left] <= basic && left < right) {
                left++;
            }

            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }

        nums[start] = nums[left];
        nums[left] = basic;

        quickSort(nums, start, right - 1);
        quickSort(nums, right + 1, end);
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 1};
        new QuickSort().sort(input);

        System.out.println(Arrays.toString(input));
    }
}
