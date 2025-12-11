package com.austinnanil.tictactoe.controller;

import com.austinnanil.tictactoe.model.GameState;
import com.austinnanil.tictactoe.model.MoveRequest;
import com.austinnanil.tictactoe.model.MoveResponse;
import com.austinnanil.tictactoe.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

	private final GameService gameService;
	private GameState gameState;

	public GameController(GameService gameService) {
		this.gameService = gameService;
		resetGame();
	}

	@GetMapping("/start")
	public GameState startGame() {
	    gameState = gameService.restartGame();
	    return gameState;
	}

	@PostMapping("/move")
	public MoveResponse playerMove(@RequestBody MoveRequest req) {
		return gameService.processMove(gameState, req, "impossible");
	}

	private void resetGame() {
		this.gameState = new GameState("X", new char[] { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' });
	}
}