// Problem: Complement of Base 10 Integer
// Source: LeetCode
// Approach: Convert to Binary + Flip Bits
//
// Steps:
// 1. Convert integer to binary string
// 2. Flip each bit (0 -> 1, 1 -> 0)
// 3. Convert the result back to decimal
//
// Time Complexity: O(log n)
// Space Complexity: O(log n)

public class ComplementOfBase10Integer {

    public static int bitwiseComplement(int n) {

        if (n == 0) return 1;

        String binary = Integer.toBinaryString(n);
        StringBuilder flipped = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                flipped.append('1');
            } else {
                flipped.append('0');
            }
        }

        return Integer.parseInt(flipped.toString(), 2);
    }
}
