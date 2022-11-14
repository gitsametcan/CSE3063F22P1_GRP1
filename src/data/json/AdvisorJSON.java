package data.json;

import java.util.ArrayList;
import java.util.List;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import person.Student;

public class AdvisorJSON extends InstructorJSON {
	
	
	
	private List<String> listOfStudentIDs;
	
	public AdvisorJSON(String firstName, String lastName) {
		super(firstName,lastName);
		listOfStudentIDs = new ArrayList<String>();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public void addStudent(String id) {
		listOfStudentIDs.add(id);
		
	}
}
