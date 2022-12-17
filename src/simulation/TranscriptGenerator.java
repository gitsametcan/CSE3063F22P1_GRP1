package simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Debt_LRA_Transcript.Transcript;
import Enums.LetterGrade;
import data.DataManager;
import lecture.Lecture;
import lecture.Schedule;
import lecture.Semester;
import person.Student;

public class TranscriptGenerator {

	private Map<String, Integer> termAndYear;

	public TranscriptGenerator() {

	}

	public Transcript generate(Student student, Schedule schedule) {
		build();
		Transcript transcript = new Transcript(student, null);
		
		transcript.setListOfSemester(setAllSemester(student, schedule));

		return student.getTranscript();
	}

	private void build() {
		termAndYear = new HashMap<String, Integer>();
		termAndYear.put("FallFreshman", 0);
		termAndYear.put("SpringFreshman", 1);
		termAndYear.put("FallSophomore", 2);
		termAndYear.put("SpringSophomore", 3);
		termAndYear.put("FallJunior", 4);
		termAndYear.put("SpringJunior", 5);
		termAndYear.put("FallSenior", 6);
		termAndYear.put("SpringSenior", 7);
	}

	private LetterGrade randomLetterGrade() {

		LetterGrade grade = LetterGrade.None;
		switch ((int) (Math.random() * 9)) {
		case 0:
			grade = LetterGrade.FF;
			break;
		case 1:
			grade = LetterGrade.FD;
			break;
		case 2:
			grade = LetterGrade.DD;
			break;
		case 3:
			grade = LetterGrade.DC;
			break;
		case 4:
			grade = LetterGrade.CC;
			break;
		case 5:
			grade = LetterGrade.CB;
			break;
		case 6:
			grade = LetterGrade.BB;
			break;
		case 7:
			grade = LetterGrade.BA;
			break;
		case 8:
			grade = LetterGrade.AA;
			break;
		}
		return grade;
	}

	private Semester semesterGenerator(Student student, Schedule schedule, int i) {

		Semester semester = new Semester(null);

		Map<Lecture, LetterGrade> listOfLecture = new HashMap<Lecture, LetterGrade>();
		for (Lecture l : DataManager.getInstance().searchLecture(i)) {
			if (student.canTakeLecture(l, student.getTranscript()))
				listOfLecture.put(l, randomLetterGrade());
		}
		semester.setListOfLecturesTaken(listOfLecture);

		return semester;
	}

	private List<Semester> setAllSemester(Student student, Schedule schedule) {
		List<Semester> semesterList = new ArrayList<Semester>();

		for (int i = 0; i < termAndYear.get(schedule.getTerm() + "" + schedule.getTermYear()); i++) {
			semesterList.add(semesterGenerator(student, schedule, i));
		}

		return semesterList;
	}

}
