// Problem: Reverse Columns of k x k Submatrix
// Source: LeetCode
// Approach: In-place Matrix Manipulation
//
// Idea:
//  - For each column in the k×k submatrix
//  - Swap top and bottom elements
//  - Continue until middle
//
// Time Complexity: O(k^2)
// Space Complexity: O(1)

public class ReverseSubmatrixColumns {

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for (int col = 0; col < k; col++) {

            for (int row = 0; row < k / 2; row++) {

                int temp = grid[x + row][y + col];

                grid[x + row][y + col] =
                        grid[x + k - row - 1][y + col];

                grid[x + k - row - 1][y + col] = temp;
            }
        }

        return grid;
    }
}
