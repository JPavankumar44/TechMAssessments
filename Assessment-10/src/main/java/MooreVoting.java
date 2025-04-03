public class MooreVoting {
    public static int findMajorityElement(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Verify the candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        return count > nums.length / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + findMajorityElement(nums));
    }
}
/*Moore Voting Algorithm (Majority Element)
Problem Statement:
Find the majority element in an array that appears more than n/2 times.

Approach (Moore's Voting Algorithm):
Keep a candidate element.

If the current element is the same as the candidate, increase the count.

If different, decrease the count.

If the count reaches zero, change the candidate.

Verify the candidate at the end.*/