package com.austinnanil.tictactoe.model;

public class MoveRequest {
	private int position;
	private String player;

	public MoveRequest() {
	}

	public MoveRequest(int position, String player) {
		this.position = position;
		this.player = player;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}