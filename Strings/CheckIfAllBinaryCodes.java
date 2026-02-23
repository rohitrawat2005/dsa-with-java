// Problem: Check If a String Contains All Binary Codes of Size K
// Source: LeetCode
// Approach: Sliding Window + HashSet
//
// Idea:
//  - Generate all substrings of length k using a sliding window
//  - Store each substring in a HashSet
//  - If the number of unique substrings equals 2^k,
//    then all binary codes of size k are present
//
// Time Complexity: O(n * k)
// Space Complexity: O(2^k)

import java.util.HashSet;

public class CheckIfAllBinaryCodes {

    public static boolean hasAllCodes(String s, int k) {

        HashSet<String> set = new HashSet<>();

        // Sliding window of size k
        for (int i = 0; i + k <= s.length(); i++) {
            set.add(s.substring(i, i + k));
        }

        // Total possible binary codes of length k = 2^k
        return set.size() == (int) Math.pow(2, k);
    }
}
