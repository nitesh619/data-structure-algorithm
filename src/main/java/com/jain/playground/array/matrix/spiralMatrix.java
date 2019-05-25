package com.jain.playground.array.matrix;

import java.util.ArrayList;
import java.util.List;

class spiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            if (rowStart < rowEnd && colStart < colEnd) {
                for (int i = colEnd - 1; i > colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                for (int i = rowEnd; i > rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }

            rowStart++;
            colEnd--;
            rowEnd--;
            colStart++;
        }
        return result;
    }
}