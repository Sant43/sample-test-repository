package com.enumarate;

public class EnumDirections {

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
	};
	
	public static void main(String[] args) {

		Directions dir = Directions.EAST;
		System.out.println(dir.getDirectionCode());
	}

}
