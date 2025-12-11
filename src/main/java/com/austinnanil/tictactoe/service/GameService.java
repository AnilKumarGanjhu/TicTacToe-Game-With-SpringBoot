package com.austinnanil.tictactoe.service;

import com.austinnanil.tictactoe.ai.MiniMaxAI;
import com.austinnanil.tictactoe.model.GameState;
import com.austinnanil.tictactoe.model.MoveRequest;
import com.austinnanil.tictactoe.model.MoveResponse;
import com.austinnanil.tictactoe.util.GameUtils;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    // Process player move + AI move
    public MoveResponse processMove(GameState gameState, MoveRequest req, String difficulty) {

        char[] board = gameState.getBoard();
        char player = req.getPlayer().charAt(0);
        char aiPlayer = (player == 'X') ? 'O' : 'X';

        int position = req.getPosition();

        // Invalid move
        if (position < 0 || position > 8 || board[position] != ' ') {
            return new MoveResponse(board, -1, "invalid");
        }

        // Player move
        board[position] = player;

        // Check if player wins
        if (GameUtils.checkWinner(board, player)) {
            return new MoveResponse(board, -1, "win|" + player);
        }

        // Check draw before AI moves
        if (GameUtils.isDraw(board)) {
            return new MoveResponse(board, -1, "draw");
        }

        // AI Move
        int aiMove = MiniMaxAI.findBestMove(board, aiPlayer, player, difficulty);

        if (aiMove != -1) {
            board[aiMove] = aiPlayer;
        }

        // Check if AI wins
        if (GameUtils.checkWinner(board, aiPlayer)) {
            return new MoveResponse(board, aiMove, "win|" + aiPlayer);
        }

        // Check draw after AI move
        if (GameUtils.isDraw(board)) {
            return new MoveResponse(board, aiMove, "draw");
        }

        // Normal move
        return new MoveResponse(board, aiMove, "ok");
    }


    // Restart game → fresh board
    public GameState restartGame() {
        return new GameState(
                "X",
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        );
    }
}