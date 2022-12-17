package Enums;

public enum Term {

	Spring , Fall;
	
	private final int evenOrOdd;
	
	private Term() {
		this.evenOrOdd = ordinal();
	}
}
