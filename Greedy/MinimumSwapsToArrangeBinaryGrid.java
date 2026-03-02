// Problem: Minimum Swaps to Arrange a Binary Grid
// Source: LeetCode
// Approach: Greedy + Simulation
//
// Idea:
//  - Count trailing zeros for each row
//  - For each row position, find the first row
//    with enough trailing zeros
//  - Bring it up using adjacent swaps
//
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

public class MinimumSwapsToArrangeBinaryGrid {

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> zeros = new ArrayList<>();

        // Count trailing zeros in each row
        for (int[] row : grid) {
            int count = 0;
            for (int j = n - 1; j >= 0 && row[j] == 0; j--) {
                count++;
            }
            zeros.add(count);
        }

        int swaps = 0;

        // Greedy row arrangement
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int j = 0;

            while (j < zeros.size() && zeros.get(j) < required) {
                j++;
            }

            if (j == zeros.size()) {
                return -1;
            }

            swaps += j;
            zeros.remove(j);
        }

        return swaps;
    }
}
