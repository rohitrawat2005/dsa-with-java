// Problem: Fancy Sequence
// Source: LeetCode
// Approach: Lazy Transformation + Modular Arithmetic
//
// Idea:
// Maintain transformation: real_value = a * stored_value + b
//
// append(val):
//   store reversed value using modular inverse
//
// addAll(inc):
//   b += inc
//
// multAll(m):
//   a *= m
//   b *= m
//
// getIndex(i):
//   return a * stored + b

import java.util.*;

class Fancy {

    private static final int MOD = 1000000007;

    private ArrayList<Long> values;

    private long a;
    private long b;

    public Fancy() {
        values = new ArrayList<>();
        a = 1;
        b = 0;
    }

    private long modPow(long x, long y) {
        long res = 1;

        x %= MOD;

        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % MOD;

            x = (x * x) % MOD;
            y >>= 1;
        }

        return res;
    }

    public void append(int val) {

        long x = (val - b + MOD) % MOD;

        long inv = modPow(a, MOD - 2);

        values.add((x * inv) % MOD);
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }

    public void multAll(int m) {

        a = (a * m) % MOD;

        b = (b * m) % MOD;
    }

    public int getIndex(int idx) {

        if (idx >= values.size())
            return -1;

        return (int)((a * values.get(idx) + b) % MOD);
    }
}
