package com.jain.playground.array;

class SingleNumber {

    // a ^ a = 0
    // 0 ^ b = b
    // a ^ b ^ a = (a^a) ^b = 0 ^b = b
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}