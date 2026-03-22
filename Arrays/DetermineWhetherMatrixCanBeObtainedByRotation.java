// Problem: Determine Whether Matrix Can Be Obtained By Rotation
// Source: LeetCode
// Approach: Bitmask + Matrix Transformation
//
// Idea:
//  - Track 4 possible rotations using a bitmask
//  - For each cell, invalidate rotations that don't match
//  - If any rotation remains valid, return true
//
// Time Complexity: O(n^2)
// Space Complexity: O(1)

public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public static boolean findRotation(int[][] mat, int[][] target) {

        int n = mat.length;

        int mask = 0b1111;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] != target[i][j])
                    mask &= 0b1110;

                if (mat[i][j] != target[j][n - 1 - i])
                    mask &= 0b1101;

                if (mat[i][j] != target[n - 1 - i][n - 1 - j])
                    mask &= 0b1011;

                if (mat[i][j] != target[n - 1 - j][i])
                    mask &= 0b0111;

                if (mask == 0)
                    return false;
            }
        }

        return mask != 0;
    }
}
