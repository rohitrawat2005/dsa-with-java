// Problem: Check if Grid Can Be Partitioned Into Two Equal Sum Parts
// Source: LeetCode
// Approach: Prefix Sum (Row & Column)
//
// Idea:
//  - Compute total sum
//  - If odd → return false
//  - Check horizontal cuts
//  - Check vertical cuts
//
// Time Complexity: O(m * n)
// Space Complexity: O(1)

public class PartitionGridIntoEqualSum {

    public static boolean canPartitionGrid(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        long totalSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }

        if (totalSum % 2 != 0) return false;

        long target = totalSum / 2;

        long rowSum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == target) return true;
        }

        long colSum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            if (colSum == target) return true;
        }

        return false;
    }
}
