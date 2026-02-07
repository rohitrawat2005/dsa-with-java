// Problem: Remove Duplicates from Sorted Array
// Source: LeetCode
// Approach: Two Pointers
//
// Idea:
//  - Use one pointer to track position of unique elements
//  - Traverse array and overwrite duplicates
//  - Return count of unique elements
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int index = 1; // position for next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
