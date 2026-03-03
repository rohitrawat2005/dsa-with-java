// Problem: Find Kth Bit in Nth Binary String
// Source: LeetCode
// Approach: Recursion + Symmetry
//
// Key Idea:
//  - Length of Sn = 2^n - 1
//  - Middle element is always '1'
//  - Left half is S(n-1)
//  - Right half is reverse(invert(S(n-1)))
//
// Time Complexity: O(n)
// Space Complexity: O(n)

public class FindKthBitInNthBinaryString {

    public static char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int len = (1 << n) - 1;
        int mid = (len + 1) / 2;

        if (k == mid) return '1';

        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        char c = findKthBit(n - 1, len - k + 1);
        return c == '0' ? '1' : '0';
    }
}
