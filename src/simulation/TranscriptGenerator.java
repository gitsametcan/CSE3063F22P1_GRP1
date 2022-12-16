package simulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Debt_LRA_Transcript.Transcript;
import Enums.FilterType;
import Enums.LetterGrade;
import data.DataManager;
import lecture.Lecture;
import lecture.Schedule;

public class TranscriptGenerator {
	
	private Map<String, Integer> termAndyear;
	
	public TranscriptGenerator(StudentGenerator student, Schedule schedule) {
		
		
		Transcript transcript = new Transcript(null, null);
		
		List<Lecture> lecture = DataManager.getInstance().searchLectureUntilTerm(schedule.getTerm(), schedule.getTermYear());
		
		
		
		Map<Lecture, LetterGrade> listOfLecture = new HashMap<Lecture, LetterGrade>();
		
		for(int i = 0; i<= termAndYear.)
		
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
	
}
	
	

