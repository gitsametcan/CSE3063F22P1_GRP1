package simulation;
import java.util.Calendar;

import IDs.StudentID;
//Samet CAN - 150120528
import person.Student;

public class StudentGenerator {
	
	private Student CreateStudent(String firstName, String lastName, Calendar dateOfEntry, StudentID studentId) {
		
		Student student = new Student(firstName, lastName, studentId, null, dateOfEntry);
		return student;
	}
	
	private StudentID studentIDGenerator(StudentID studentId) {
		if(studentId == null) {
			studentId.setDepartmentCode(150);
			studentId.setYearCode(18);
			studentId.setOrderOfPlacement(000);
		}
		if(studentId.getOrderOfPlacement() == 50) {
			studentId.setYearCode(studentId.getYearCode()+1);
			studentId.setOrderOfPlacement(000);
		}
		int newOrderOfPlacement = studentId.getOrderOfPlacement() + 1 ;
		StudentID newStudentID = new StudentID(studentId.getDepartmentCode(),studentId.getYearCode(), newOrderOfPlacement);
		return newStudentID;
	}

}
