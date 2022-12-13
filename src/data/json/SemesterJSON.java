package data.json;

import java.util.HashMap;
import java.util.Map;

public class SemesterJSON {

	// LectureID, LetterGrade
	private Map<String, String> listOfLecturesTaken;

	public SemesterJSON(Map<String, String> listOfLecturesTaken) {
		super();
		
		if (listOfLecturesTaken == null) {
			this.listOfLecturesTaken = new HashMap<String, String>();
		}
	}

	public Map<String, String> getListOfLecturesTaken() {
		return listOfLecturesTaken;
	}

	public void setListOfLecturesTaken(Map<String, String> listOfLecturesTaken) {
		this.listOfLecturesTaken = listOfLecturesTaken;
	}
}