// Problem: Count Prime Number of Set Bits in Binary Representation
// Source: LeetCode
// Approach:
//  - Iterate from left to right
//  - Count set bits using Integer.bitCount()
//  - Check if the count of set bits is a prime number
//
// Time Complexity: O(n * sqrt(k))
//   where n = (right - left + 1), k = number of set bits (small)
// Space Complexity: O(1)

public class CountPrimeSetBits {

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime(setBits)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
