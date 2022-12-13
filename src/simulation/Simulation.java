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
		for (int i = 0; i < 8; i++) {
			newSemester();
		}
	}

	private void newSemester() {
		StudentGenerator studentGenerator = new StudentGenerator();
		TranscriptGenerator transcriptGenerator = new TranscriptGenerator();
	}
}
