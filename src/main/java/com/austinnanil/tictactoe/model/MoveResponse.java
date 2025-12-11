package com.austinnanil.tictactoe.model;

public class MoveResponse {
	private char[] board;
    private int aiMove;
    private String status;

    public MoveResponse(char[] board, int aiMove, String status) {
        this.board = board;
        this.aiMove = aiMove;
        this.status = status;
    }

	public MoveResponse() {
	}

	public int getAiMove() {
		return aiMove;
	}

	public void setAiMove(int aiMove) {
		this.aiMove = aiMove;
	}

	public char[] getBoard() {
		return board;
	}

	public void setBoard(char[] board) {
		this.board = board;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}