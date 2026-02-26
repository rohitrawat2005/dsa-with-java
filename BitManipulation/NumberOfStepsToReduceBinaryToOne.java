// Problem: Number of Steps to Reduce a Number in Binary Representation to One
// Source: LeetCode
// Approach: Simulation using BigInteger
//
// Idea:
//  - Convert binary string to a BigInteger
//  - If number is even, divide by 2
//  - If number is odd, add 1
//  - Repeat until number becomes 1
//
// Time Complexity: Depends on number of operations on BigInteger
// Space Complexity: O(n) where n is length of binary string

import java.math.BigInteger;

public class NumberOfStepsToReduceBinaryToOne {

    public static int numSteps(String s) {

        // Convert binary string to BigInteger
        BigInteger num = new BigInteger(s, 2);
        int steps = 0;

        // Continue until number becomes 1
        while (!num.equals(BigInteger.ONE)) {

            // If even
            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.TWO);
            } 
            // If odd
            else {
                num = num.add(BigInteger.ONE);
            }

            steps++;
        }

        return steps;
    }
}
