// Problem: Minimum Number of Seconds to Make Mountain Height Zero
// Source: LeetCode
// Approach: Binary Search on Answer
//
// Idea:
//  - Each worker removes blocks with increasing time
//  - Time for k blocks = time[i] * k(k+1)/2
//  - Use binary search to find minimum seconds where
//    total blocks removed >= height
//
// Time Complexity: O(n log answer)
// Space Complexity: O(1)

public class MinimumSecondsToMakeMountainHeightZero {

    public static long minNumberOfSeconds(int height, int[] times) {

        long lo = 1, hi = 10000000000000000L;

        while (lo < hi) {

            long mid = (lo + hi) >> 1;
            long total = 0;

            for (int i = 0; i < times.length && total < height; i++) {

                long blocks =
                        (long) (Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);

                total += blocks;
            }

            if (total >= height)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }
}
