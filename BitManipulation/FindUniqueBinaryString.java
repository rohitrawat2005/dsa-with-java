// Problem: Find Unique Binary String
// Source: LeetCode
// Approach: HashSet + Generate Binary Numbers
//
// Idea:
//  - Store given binary strings in a HashSet
//  - Generate all possible binary numbers of length n
//  - Return the first one that does not exist in the set
//
// Time Complexity: O(n * 2^n)
// Space Complexity: O(n)

import java.util.HashSet;

public class FindUniqueBinaryString {

    public static String findDifferentBinaryString(String[] nums) {

        int n = nums.length;

        HashSet<String> set = new HashSet<>();
        for (String s : nums) {
            set.add(s);
        }

        int limit = (int) Math.pow(2, n);

        for (int i = 0; i < limit; i++) {

            String bin = Integer.toBinaryString(i);

            while (bin.length() < n) {
                bin = "0" + bin;
            }

            if (!set.contains(bin)) {
                return bin;
            }
        }

        return "";
    }
}
