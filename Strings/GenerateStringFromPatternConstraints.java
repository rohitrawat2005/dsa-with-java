// Problem: Generate String From T/F Constraints
// Source: LeetCode
// Approach: Greedy + Constructive String
//
// Idea:
// 1. First satisfy all T constraints
// 2. Fill remaining positions with 'a'
// 3. For each F constraint, ensure substring != t
//
// Time Complexity: O(n * m)
// Space Complexity: O(n + m)

import java.util.Arrays;

public class GenerateStringFromPatternConstraints {

    public static String generateString(String S, String t) {
        char[] s = S.toCharArray();

        int n = s.length;
        int m = t.length();

        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');

        for (int i = 0; i < n; i++) {
            if (s[i] != 'T') continue;

            for (int j = 0; j < m; j++) {
                char v = ans[i + j];

                if (v != '?' && v != t.charAt(j)) {
                    return "";
                }

                ans[i + j] = t.charAt(j);
            }
        }

        char[] oldAns = ans.clone();

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a';
            }
        }

        for (int i = 0; i < n; i++) {
            if (s[i] != 'F') continue;

            if (!new String(ans, i, m).equals(t)) {
                continue;
            }

            boolean ok = false;

            for (int j = i + m - 1; j >= i; j--) {
                if (oldAns[j] == '?') {
                    ans[j] = 'b';
                    ok = true;
                    break;
                }
            }

            if (!ok) return "";
        }

        return new String(ans);
    }
}
