// Problem: Concatenation of Consecutive Binary Numbers
// Source: LeetCode
// Approach: Bit Manipulation
//
// Idea:
//  - Keep track of the number of bits required for current number
//  - Left shift the accumulated result by that many bits
//  - Add the current number
//  - Take modulo at each step
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class ConcatenationOfConsecutiveBinaryNumbers {

    public static int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long result = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // If i is power of 2, binary length increases
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            // Append binary representation of i
            result = ((result << bits) + i) % MOD;
        }

        return (int) result;
    }
}
