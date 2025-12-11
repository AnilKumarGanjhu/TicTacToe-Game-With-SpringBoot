package com.austinnanil.tictactoe.util;

public class GameUtils {

    private static final int[][] WIN_POSITIONS = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    public static boolean checkWinner(char[] board, char player) {
        for (int[] pos : WIN_POSITIONS) {
            if (board[pos[0]] == player &&
                board[pos[1]] == player &&
                board[pos[2]] == player) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBoardFull(char[] board) {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }

    // 🔥 NEW: Check draw
    public static boolean isDraw(char[] board) {
        return !checkWinner(board, 'X')
                && !checkWinner(board, 'O')
                && isBoardFull(board);
    }
}
