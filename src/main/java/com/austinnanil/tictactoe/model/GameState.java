package com.austinnanil.tictactoe.model;

public class GameState {
	private char[] board;
	private String currentPlayer;

	public GameState() {
	}

	public GameState(String currentPlayer, char[] board) {
		this.currentPlayer = currentPlayer;
		this.board = board;
	}

	public char[] getBoard() {
		return board;
	}

	public void setBoard(char[] board) {
		this.board = board;
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}