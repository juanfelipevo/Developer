package com.example.api.masivianroulette.utils;

public enum StateEnum {
	OPEN("OPEN"),
	CLOSED("CLOSED");

	private String state;
	
	StateEnum(String state) {
		this.setState(state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
