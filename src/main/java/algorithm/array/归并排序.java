package algorithm.array;

/**
 * TODO 待测试
 *
 * @author Ethan Zhang
 * @date 2022/3/20
 */
public class 归并排序 {

    public void sort(int[] nums) {
        if (nums == null) {
            return;
        }

        int[] temp = new int[nums.length];
        sortImpl(nums, 0, nums.length - 1, temp);
    }

    private void sortImpl(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sortImpl(nums, left, mid, temp);
        sortImpl(nums, mid + 1, right, temp);

        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        // TODO 这里的复制没看懂，为什么不在外层一次做掉
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }
}
