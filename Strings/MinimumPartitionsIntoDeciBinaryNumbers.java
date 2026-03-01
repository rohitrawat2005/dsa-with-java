// Problem: Partitioning Into Minimum Number Of Deci-Binary Numbers
// Source: LeetCode
// Approach: Greedy Observation
//
// Key Insight:
//  - Each deci-binary number can contribute at most 1 at any digit
//  - Therefore, the minimum number required equals the maximum digit in the string
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MinimumPartitionsIntoDeciBinaryNumbers {

    public static int minPartitions(String n) {
        int maxDigit = 0;

        for (int i = 0; i < n.length(); i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) - '0');
        }

        return maxDigit;
    }
}
