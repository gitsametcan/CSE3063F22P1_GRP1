package person;
//Kaan Camci 150119063
public class Person {

	protected String firstName;
	protected String lastName;
	protected UniqueID id;
	
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
	public String getId() {
		return id.getID();
	}
	
	
	
}
