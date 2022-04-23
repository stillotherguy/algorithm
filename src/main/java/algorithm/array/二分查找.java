package algorithm.array;

/**
 * @author Ethan Zhang
 * @date 2022/4/21
 */
public class 二分查找 {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6};

        System.out.println(binarySearch(array, 1));
    }

    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}
