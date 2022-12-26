package Enums;

public enum TermYear {
	Freshman, Sophomore, Junior, Senior;
	
	private final int year;
	
	private TermYear() {
		this.year = ordinal();
	}

}
