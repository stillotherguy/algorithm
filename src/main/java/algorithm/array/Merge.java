package algorithm.array;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int index = m + n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
                nums1[index--] = nums1[left--];
            } else {
                nums1[index--] = nums2[right--];
            }
        }

        // 左边索引到-1之后，nums2还有数据，需要copy
        System.arraycopy(nums2, 0, nums1, 0, right + 1);
    }
}
