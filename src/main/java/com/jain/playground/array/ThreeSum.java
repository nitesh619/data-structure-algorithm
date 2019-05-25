package com.jain.playground.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < len - 2; i++) {
            int a = nums[i];
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                if (a + b + c == 0) {
                    set.add(Arrays.asList(a, b, c));
                    start++;
                    end--;
                } else if (a + b + c < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}