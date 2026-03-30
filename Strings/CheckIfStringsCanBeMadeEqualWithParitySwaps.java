// Problem: Check if Strings Can Be Made Equal With Same-Parity Swaps
// Source: LeetCode
// Approach: HashMap Frequency Count
//
// Idea:
//  - Count frequencies separately for even and odd indices
//  - Compare frequencies using second string
//
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.HashMap;

public class CheckIfStringsCanBeMadeEqualWithParitySwaps {

    public static boolean checkStrings(String s1, String s2) {

        HashMap<Character, Integer> even = new HashMap<>();
        HashMap<Character, Integer> odd = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);

            if (i % 2 == 0) {
                even.put(ch, even.getOrDefault(ch, 0) + 1);
            } else {
                odd.put(ch, odd.getOrDefault(ch, 0) + 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (i % 2 == 0) {
                if (!even.containsKey(ch)) return false;

                even.put(ch, even.get(ch) - 1);

                if (even.get(ch) <= 0) {
                    even.remove(ch);
                }
            } else {
                if (!odd.containsKey(ch)) return false;

                odd.put(ch, odd.get(ch) - 1);

                if (odd.get(ch) <= 0) {
                    odd.remove(ch);
                }
            }
        }

        return true;
    }
}
