package com.austinnanil.tictactoe.ai;

import com.austinnanil.tictactoe.util.GameUtils;

public class MiniMaxAI {

    // Public entry — difficulty: "easy", "medium", "impossible"
    public static int findBestMove(char[] board, char aiPlayer, char humanPlayer, String difficulty) {

        if (difficulty == null)
            difficulty = "impossible";

        difficulty = difficulty.toLowerCase();

        int[] available = getAvailableMoves(board);
        if (available.length == 0)
            return -1;

        // EASY → pick first available move
        if (difficulty.equals("easy")) {
            return available[0];
        }

        // MEDIUM → pick any middle move
        if (difficulty.equals("medium")) {
            return available.length > 1 ? available[1] : available[0];
        }

        // IMPOSSIBLE → Use Minimax (Unbeatable AI)
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int move : available) {
            board[move] = aiPlayer;

            int score = minimax(board, 0, false, aiPlayer, humanPlayer);

            board[move] = ' '; // undo

            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private static int[] getAvailableMoves(char[] board) {
        return java.util.stream.IntStream.range(0, board.length)
                .filter(i -> board[i] == ' ')
                .toArray();
    }

    // Minimax Algorithm — returns score
    private static int minimax(char[] board, int depth, boolean isMaximizing, char aiPlayer, char humanPlayer) {

        // Terminal states
        if (GameUtils.checkWinner(board, aiPlayer)) return 10 - depth;
        if (GameUtils.checkWinner(board, humanPlayer)) return depth - 10;
        if (isBoardFull(board)) return 0; // Draw

        int bestScore;

        if (isMaximizing) {
            bestScore = Integer.MIN_VALUE;
            for (int i : getAvailableMoves(board)) {

                board[i] = aiPlayer;

                int score = minimax(board, depth + 1, false, aiPlayer, humanPlayer);
                board[i] = ' '; // undo

                bestScore = Math.max(bestScore, score);
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i : getAvailableMoves(board)) {

                board[i] = humanPlayer;

                int score = minimax(board, depth + 1, true, aiPlayer, humanPlayer);
                board[i] = ' '; // undo

                bestScore = Math.min(bestScore, score);
            }
        }

        return bestScore;
    }

    private static boolean isBoardFull(char[] board) {
        for (char c : board)
            if (c == ' ')
                return false;
        return true;
    }
}