package simulation;

import java.util.List;

import Debt_LRA_Transcript.Transcript;
import Enums.FilterType;
import data.DataManager;
import lecture.Lecture;
import lecture.Schedule;

public class TranscriptGenerator {
	
	public TranscriptGenerator(StudentGenerator student, Schedule schedule) {
		Transcript transcript = new Transcript(null, null);
		
		List<Lecture> lecture =DataManager.getInstance().searchLecture("", FilterType.ID);
	}
	
}
	
	

