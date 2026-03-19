// Problem: Count Submatrices With Equal X and Y
// Source: LeetCode
// Approach: 2D Prefix Sum (Optimized)
//
// Idea:
//  - Maintain prefix counts of X and Y
//  - For each cell (i,j), track total X and Y in submatrix (0,0) → (i,j)
//  - If counts are equal and > 0, count it
//
// Time Complexity: O(rows * cols)
// Space Complexity: O(cols)

public class CountSubmatricesWithEqualXY {

    public static int numberOfSubmatrices(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[] sumX = new int[cols];
        int[] sumY = new int[cols];

        int res = 0;

        for (int i = 0; i < rows; i++) {

            int rowX = 0;
            int rowY = 0;

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 'X') rowX++;
                else if (grid[i][j] == 'Y') rowY++;

                sumX[j] += rowX;
                sumY[j] += rowY;

                if (sumX[j] > 0 && sumX[j] == sumY[j]) {
                    res++;
                }
            }
        }

        return res;
    }
}
