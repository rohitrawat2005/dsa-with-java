// Problem: Minimum Absolute Difference in k x k Submatrix
// Source: LeetCode
// Approach: Brute Force + Sorting
//
// Idea:
//  - For each k×k submatrix, extract all elements
//  - Sort the elements
//  - Minimum difference will be between adjacent elements
//
// Time Complexity: O(n * m * k^2 log(k^2))
// Space Complexity: O(k^2)

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInSubmatrix {

    public static int[][] minAbsDiff(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] result = new int[n - k + 1][m - k + 1];

        if (k == 1) return result;

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {

                int[] arr = new int[k * k];
                int idx = 0;

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        arr[idx++] = grid[x][y];
                    }
                }

                Arrays.sort(arr);

                int min = Integer.MAX_VALUE;

                for (int l = 1; l < arr.length; l++) {
                    if (arr[l] != arr[l - 1]) {
                        min = Math.min(min, arr[l] - arr[l - 1]);
                    }
                }

                result[i][j] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }

        return result;
    }
}
