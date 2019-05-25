package com.jain.playground.array;

// idea is to take two pointers from left and right
class TrappingRainWater {

    public int trap(int[] height) {
        int pre = 0;
        int post = height.length - 1;
        int pre_max = 0, post_max = 0;
        int volumeCollected = 0;

        while (post > pre) {
            if (height[post] < height[pre]) {
                if (height[post] >= post_max) {
                    post_max = height[post];
                } else {
                    volumeCollected += post_max - height[post];
                }
                post--;
            } else {
                if (height[pre] >= pre_max) {
                    pre_max = height[pre];
                } else {
                    volumeCollected += pre_max - height[pre];
                }
                pre++;
            }
        }
        return volumeCollected;
    }
}