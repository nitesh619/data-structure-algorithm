package com.jain.playground.array;

public class Jump {

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        // keep good, badd jumps
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                // mark good jump -- can reach to end from here, so rtry to reach here in next iteration :)
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}