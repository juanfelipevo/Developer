package com.example.api.masivianroulette.utils;


public enum ColourEnum {
	RED("RED"),
	BLACK("BLACK");

	private String colour;
	
	ColourEnum(String colour) {
		this.setColour(colour);
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}	
}
