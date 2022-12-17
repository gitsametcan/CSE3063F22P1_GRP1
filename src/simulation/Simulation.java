package simulation;

import java.util.ArrayList;
import java.util.List;

import person.Student;

public class Simulation {

	private List<Student> listOfStudents;
	private StudentGenerator studentGenerator;
	
	public Simulation() {
		studentGenerator = new StudentGenerator();
		listOfStudents = new ArrayList<Student>();
	}

	private void newSemester(int semesterCount) {
		for (int studentCount = 0; studentCount < 50; studentCount++) {
			
			Student student;
			try {
				student = studentGenerator.generate((studentCount+1), semesterCount);
				listOfStudents.add(student);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void run() {
		for (int i = 0; i<8; i++) {
			newSemester(i);
		}
	}

	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}

}
