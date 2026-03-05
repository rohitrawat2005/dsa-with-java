// Problem: Minimum Changes to Make Alternating Binary String
// Source: LeetCode
// Approach: Pattern Comparison
//
// Idea:
//  - Only two valid alternating patterns exist:
//      010101...
//      101010...
//  - Count mismatches with both patterns
//  - Return the minimum number of flips required
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MinimumChangesToMakeAlternatingBinaryString {

    public static int minOperations(String s) {

        int count1 = 0; // pattern 010101
        int count2 = 0; // pattern 101010

        for (int i = 0; i < s.length(); i++) {

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected1) {
                count1++;
            }

            if (s.charAt(i) != expected2) {
                count2++;
            }
        }

        return Math.min(count1, count2);
    }
}
