// Problem: Count Special Positions in a Binary Matrix
// Source: LeetCode
// Approach: Row and Column Counting
//
// Idea:
//  - Count number of 1s in each row and column
//  - A position is special if:
//      mat[i][j] == 1
//      row[i] == 1
//      col[j] == 1
//
// Time Complexity: O(m * n)
// Space Complexity: O(m + n)

public class CountSpecialPositionsInBinaryMatrix {

    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        // Count 1s in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;

        // Find special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
