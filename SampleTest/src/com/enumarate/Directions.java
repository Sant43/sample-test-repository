package com.enumarate;

public enum Directions {
	EAST("E"),
	WEST("W"),
	NORTH("N"),
	SOUTH("S")
	;
	
	private String directionCode = "";
	
	Directions(String str) {
		directionCode = str;
	}
	
	private String getDirectionCode() {
		return directionCode;
	}
}
