// Problem: Binary Gap
// Source: LeetCode
// Approach: Bit Manipulation + Index Tracking
//
// Idea:
//  - Traverse all 32 bits of the number
//  - Store positions of bits that are '1'
//  - Find the maximum difference between consecutive positions
//
// Time Complexity: O(32) -> O(1)
// Space Complexity: O(32) -> O(1)

public class BinaryGap {

    public static int binaryGap(int N) {

        int[] positions = new int[32]; // stores positions of set bits
        int count = 0;                 // number of set bits found

        // Step 1: find positions of all 1s
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) != 0) {
                positions[count++] = i;
            }
        }

        int maxGap = 0;

        // Step 2: find maximum gap between consecutive 1s
        for (int i = 0; i < count - 1; i++) {
            maxGap = Math.max(maxGap, positions[i + 1] - positions[i]);
        }

        return maxGap;
    }
}
