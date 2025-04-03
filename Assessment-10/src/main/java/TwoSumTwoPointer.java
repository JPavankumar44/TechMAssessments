import java.util.Arrays;

public class TwoSumTwoPointer {
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums); // Sorting required for Two Pointer Approach
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // No solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Pair indices: " + Arrays.toString(twoSum(nums, target)));
    }
}
