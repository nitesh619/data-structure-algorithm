package com.jain.playground.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueenProblem {

    public int[][] chessBoard;

    public List<List<String>> solveNQueens(int n) {
        chessBoard = new int[n][n];
        List<List<String>> sol = new ArrayList<>();
        if (setQueen(0)) {
            for (int i = 0; i < chessBoard.length; i++) {
                String x = "";
                for (int j = 0; j < chessBoard.length; j++) {
                    x += chessBoard[i][j] == 1 ? "Q" : ".";
                }
                sol.add(Arrays.asList(x));
            }
            return sol;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean setQueen(final int columnIndex) {
        if (columnIndex == chessBoard.length) {
            return true;
        }
        for (int rowIndex = 0; rowIndex < chessBoard.length; rowIndex++) {
            for (int k = 0; k < chessBoard.length; k++) {
                if (isPlaceValid(rowIndex, k)) {
                    chessBoard[rowIndex][k] = 1;
                    if (setQueen(columnIndex + 1)) {
                        return true;
                    }
                }
                chessBoard[rowIndex][k] = 0;
            }
        }
        return false;
    }

    private boolean isPlaceValid(final int rowIndex, final int colIndex) {
        for (int i = 0; i < colIndex; i++) {
            if (chessBoard[rowIndex][i] == 1) {
                return false;
            }
        }
        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }
        for (int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}