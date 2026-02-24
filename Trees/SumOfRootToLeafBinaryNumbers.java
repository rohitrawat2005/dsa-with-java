// Problem: Sum of Root To Leaf Binary Numbers
// Source: LeetCode
// Approach: Depth First Search (DFS)
//
// Idea:
//  - Traverse from root to leaf
//  - Treat each path as a binary number
//  - Convert binary to decimal while traversing
//  - Add values when a leaf node is reached
//
// Time Complexity: O(n)  (n = number of nodes)
// Space Complexity: O(h) (h = height of tree due to recursion)

public class SumOfRootToLeafBinaryNumbers {

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }

        // Shift left (multiply by 2) and add current node value
        current = current * 2 + node.val;

        // If leaf node, return the binary number formed
        if (node.left == null && node.right == null) {
            return current;
        }

        // Recurse for left and right subtree
        return dfs(node.left, current) + dfs(node.right, current);
    }
}
