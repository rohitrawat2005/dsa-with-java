// Problem: Minimum Operations to Convert Binary String
// Source: LeetCode
// Approach: BFS on state space (number of zeros)
//
// Key Insight:
//  - Instead of tracking the string, track the count of '0's
//  - Each operation changes the count in a predictable range
//  - BFS is used to find the minimum number of operations
//
// This is an optimized solution using parity and TreeSet
// to efficiently explore valid transitions.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

public class MinOperationsToConvertBinaryString {

    public static int minOperations(String s, int k) {
        int n = s.length();
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<TreeSet<Integer>> sets = new ArrayList<>();
        sets.add(new TreeSet<>());
        sets.add(new TreeSet<>());

        for (int i = 0; i <= n; i++) {
            sets.get(i % 2).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(zeros);
        dist[zeros] = 0;
        sets.get(zeros % 2).remove(zeros);

        while (!q.isEmpty()) {
            int cur = q.poll();

            int minFlipZero = Math.max(k - n + cur, 0);
            int maxFlipZero = Math.min(cur, k);

            int left = cur + k - 2 * maxFlipZero;
            int right = cur + k - 2 * minFlipZero;

            TreeSet<Integer> set = sets.get(left % 2);

            for (Integer nxt = set.ceiling(left);
                 nxt != null && nxt <= right;
                 nxt = set.ceiling(left)) {

                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
                set.remove(nxt);
            }
        }

        return dist[0] == Integer.MAX_VALUE ? -1 : dist[0];
    }
}
