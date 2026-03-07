// Problem: Minimum Number of Flips to Make the Binary String Alternating
// Source: LeetCode
// Approach: Sliding Window + Pattern Matching
//
// Idea:
//  - Maintain mismatch counts with both alternating patterns
//  - Simulate rotations by adjusting mismatch counts
//  - Track the minimum flips needed
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MinimumFlipsToMakeBinaryStringAlternating {

    public static int minFlips(String s) {

        int n = s.length();
        int res = n;

        int[] op = {0, 0};

        // Initial mismatch count
        for (int i = 0; i < n; i++) {
            op[(s.charAt(i) ^ i) & 1]++;
        }

        // Simulate rotations
        for (int i = 0; i < n; i++) {
            op[(s.charAt(i) ^ i) & 1]--;
            op[(s.charAt(i) ^ (n + i)) & 1]++;
            res = Math.min(res, Math.min(op[0], op[1]));
        }

        return res;
    }
}
