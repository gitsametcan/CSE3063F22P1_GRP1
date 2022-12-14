package simulation;

import java.util.List;

import Debt_LRA_Transcript.Transcript;
import lecture.Semester;
import person.Student;

public class TranscriptGenerator {

	private Student student;
	private List<Semester> listOfSemester;
	

	Transcript transcript = new Transcript(student, listOfSemester);
}
