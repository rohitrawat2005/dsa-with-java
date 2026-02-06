// Problem: Two Sum
// Source: LeetCode
// Approach: Brute Force
//
// Idea:
//  - Check all possible pairs
//  - If nums[i] + nums[j] == target, return indices
//
// Time Complexity: O(n^2)
// Space Complexity: O(1)

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
