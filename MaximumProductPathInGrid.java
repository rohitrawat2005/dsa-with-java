// Problem: Maximum Product Path in a Grid
// Source: LeetCode
// Approach: Dynamic Programming (Track Max & Min)
//
// Idea:
//  - Due to negative numbers, track both max and min product
//  - At each cell, compute possible values from top and left
//  - Choose max and min accordingly
//
// Time Complexity: O(m * n)
// Space Complexity: O(n)

public class MaximumProductPathInGrid {

    public static int maxProductPath(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        long MOD = 1_000_000_007;

        long[] max = new long[n];
        long[] min = new long[n];

        max[0] = min[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            max[j] = max[j - 1] * grid[0][j];
            min[j] = max[j];
        }

        for (int i = 1; i < m; i++) {

            max[0] = max[0] * grid[i][0];
            min[0] = max[0];

            for (int j = 1; j < n; j++) {

                long val = grid[i][j];

                long topMax = max[j];
                long topMin = min[j];
                long leftMax = max[j - 1];
                long leftMin = min[j - 1];

                long a = topMax * val;
                long b = topMin * val;
                long c = leftMax * val;
                long d = leftMin * val;

                max[j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long res = max[n - 1];

        return res < 0 ? -1 : (int)(res % MOD);
    }
}
