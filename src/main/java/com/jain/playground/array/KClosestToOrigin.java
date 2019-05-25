package com.jain.playground.array;

import java.util.Arrays;

class KClosestToOrigin {

    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void sort(int i, int j, int K) {
        if (i >= j) {
            return;
        }
        // int k = ThreadLocalRandom.current().nextInt(i, j);
        // swap(i, k);

        int mid = partition(i, j);
        int leftLength = mid - i + 1;
        if (K < leftLength) {
            sort(i, mid - 1, K);
        } else if (K > leftLength) {
            sort(mid + 1, j, K - leftLength);
        }
    }

    public int partition(int left, int right) {
        int pivot = dist(right);
        // 1. move pivot to end
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (dist(i) < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}