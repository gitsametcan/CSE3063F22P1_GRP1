package simulation;

import java.util.List;

import person.Advisor;
import person.Instructor;
import person.Student;

public class Simulation {

	private List<Student> listOfStudents;
	private List<Advisor> listOfAdvisors;
	private List<Instructor> listOfInstructors;

	public void simulation() {
		for (int semesterCount = 0; semesterCount < 8; semesterCount++) {
			newSemester(semesterCount);
		}
	}

	private void newSemester(int semesterCount) {
		for (int studentCount = 0; studentCount < 50; studentCount++) {
			int year = (semesterCount / 2) + 18;
			StudentGenerator studentGenerator = new StudentGenerator(this, year, studentCount);
		}

	}

	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}

	public List<Advisor> getListOfAdvisors() {
		return listOfAdvisors;
	}

	public void setListOfAdvisors(List<Advisor> listOfAdvisors) {
		this.listOfAdvisors = listOfAdvisors;
	}

	public List<Instructor> getListOfInstructors() {
		return listOfInstructors;
	}

	public void setListOfInstructors(List<Instructor> listOfInstructors) {
		this.listOfInstructors = listOfInstructors;
	}

}
