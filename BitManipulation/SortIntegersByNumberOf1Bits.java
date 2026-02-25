// Problem: Sort Integers by The Number of 1 Bits
// Source: LeetCode
// Approach: Bit Manipulation + Custom Sorting
//
// Idea:
//  - Convert int[] to Integer[] for custom comparator
//  - Sort numbers by count of set bits
//  - If set bits are equal, sort by numeric value
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.Arrays;

public class SortIntegersByNumberOf1Bits {

    public static int[] sortByBits(int[] arr) {

        // Convert int[] to Integer[] to use custom comparator
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Sort using custom comparator
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            // If number of set bits is same, sort by value
            if (countA == countB) {
                return a - b;
            }

            // Otherwise, sort by set bit count
            return countA - countB;
        });

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}
