// Problem: Check if Binary String Has at Most One Segment of Ones
// Source: LeetCode
// Approach: Scan and count blocks of consecutive '1's
//
// Idea:
//  - Traverse the string
//  - Count segments of consecutive '1's
//  - If more than one segment appears, return false
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public static boolean checkOnesSegment(String s) {

        int count = 0;
        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '1') {
                count++;

                while (i < s.length() && s.charAt(i) == '1') {
                    i++;
                }

                if (count > 1) {
                    return false;
                }
            } else {
                i++;
            }
        }

        return true;
    }
}
