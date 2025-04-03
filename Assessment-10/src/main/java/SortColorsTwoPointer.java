import java.util.Arrays;

public class SortColorsTwoPointer {
    public static void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, right--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
/*Time Complexity: O(n)
Space Complexity: O(1)
Expected Output: [0, 0, 1, 1, 2, 2]*/