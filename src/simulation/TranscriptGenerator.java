package simulation;

import java.util.List;

import Debt_LRA_Transcript.Transcript;
import lecture.Semester;
import person.Student;

public class TranscriptGenerator {

	private Student student;
	private List<Semester> listOfSemester;

	private void setGano(List<Semester> listOfSemester) {
		double tempGano = 0;
		int numberOfSemester = 0;
		for (int i = 0; i < listOfSemester.size(); i++) {
			double yano = listOfSemester.get(i).getYano();
			tempGano = tempGano + yano;
			numberOfSemester++;
		}

	}

	Transcript transcript = new Transcript(student, listOfSemester);
}
