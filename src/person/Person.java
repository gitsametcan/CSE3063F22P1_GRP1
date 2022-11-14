package person;

import IDs.UniqueID;

//Kaan Camci 150119063
public class Person {

	protected String firstName;
	protected String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
