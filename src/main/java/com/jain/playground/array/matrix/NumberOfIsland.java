package com.jain.playground.array.matrix;

class NumberOfIsland {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    // convert adjacent land to water
                    changeLandToWater(grid, row, col);
                }
            }
        }
        return islandCount;
    }

    public void changeLandToWater(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        changeLandToWater(grid, r + 1, c); // up
        changeLandToWater(grid, r - 1, c); // down
        changeLandToWater(grid, r, c - 1); // left
        changeLandToWater(grid, r, c + 1); // right
    }
}