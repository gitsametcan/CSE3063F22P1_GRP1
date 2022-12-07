package data.json;

import java.util.List;

public class InstructorJSON extends PersonJSON{
	
	private List<String> listOfLectureIDs;
	private String instructorType;
	private String instructorID;
	private String dateOfEntry;

	public InstructorJSON(String firstName, String lastName) {
		super(firstName, lastName);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	
	public List<String> getListOfLectureIDs() {
		return listOfLectureIDs;
	}

	public void setListOfLectureIDs(List<String> listOfLectureIDs) {
		this.listOfLectureIDs = listOfLectureIDs;
	}

	public String getInstructorType() {
		return instructorType;
	}

	public void setInstructorType(String instructorType) {
		this.instructorType = instructorType;
	}

	public String getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}

	

}
