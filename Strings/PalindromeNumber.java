// Problem: Palindrome Number
// Source: LeetCode
// Approach: Convert number to String and use two pointers
//
// Idea:
//  - Negative numbers cannot be palindrome
//  - Convert number to string
//  - Compare characters from both ends using two pointers
//
// Time Complexity: O(n)
// Space Complexity: O(n)

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        if (x < 0) {
            return false;
        }

        String num = Integer.toString(x);
        int left = 0;
        int right = num.length() - 1;

        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
