package com.jain.playground.math;

public class PowerOf3 {

    // max int possible which is power of 3 in java is 1162261467
    // therefore it is only divided by 3 and its multiple evenly to get zero
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}