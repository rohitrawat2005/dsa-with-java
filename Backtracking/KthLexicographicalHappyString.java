// Problem: The k-th Lexicographical Happy String of Length n
// Source: LeetCode
// Approach: Greedy + Combinatorics
//
// Idea:
//  - Total happy strings = 3 * 2^(n-1)
//  - At each position choose the correct character
//    by skipping branches of size 2^(remaining length)
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class KthLexicographicalHappyString {

    public static String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        k--;
        StringBuilder res = new StringBuilder();
        char last = '\0';

        for (int pos = 0; pos < n; pos++) {

            int branch = 1 << (n - pos - 1);

            List<Character> choices = new ArrayList<>();
            for (char c : new char[]{'a','b','c'})
                if (c != last) choices.add(c);

            int idx = k / branch;

            res.append(choices.get(idx));
            last = choices.get(idx);

            k %= branch;
        }

        return res.toString();
    }
}
