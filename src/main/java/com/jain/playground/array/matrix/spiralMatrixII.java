package com.jain.playground.array.matrix;
// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
class spiralMatrixII {

    // similar to matrix - I
    public int[][] spiralOrder(int n) {
        int[][] matrix = new int[n][n];
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int k = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = k;
                k++;
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                matrix[i][colEnd] = k;
                k++;
            }
            if (rowStart < rowEnd && colStart < colEnd) {
                for (int i = colEnd - 1; i > colStart; i--) {
                    matrix[rowEnd][i] = k;
                    k++;
                }
                for (int i = rowEnd; i > rowStart; i--) {
                    matrix[i][colStart] = k;
                    k++;
                }
            }

            rowStart++;
            colEnd--;
            rowEnd--;
            colStart++;
        }
        return matrix;
    }
}