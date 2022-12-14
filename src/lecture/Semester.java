package lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Debt_LRA_Transcript.Transcript;
import Enums.LetterGrade;
import Enums.Term;
import Enums.TermYear;

//Serdar Alsan	150120034 
public class Semester {

	private Map<Lecture, LetterGrade> listOfLecturesTaken;
	private int creditsTaken;
	private int creditsCompleted;
	private double points;
	private double yano;
	private Term term;
	private TermYear termYear;

	public Semester(HashMap<Lecture, LetterGrade> listOfLecturesTaken) {
		super();
		this.listOfLecturesTaken = listOfLecturesTaken;
		this.creditsTaken = creditsTakenCalculator(listOfLecturesTaken);
		this.creditsCompleted = creditsCompletedCalculator(listOfLecturesTaken);
		this.points = pointsCalculator(listOfLecturesTaken);
		this.yano = points / creditsTaken;
		if (this.listOfLecturesTaken == null) {
			this.listOfLecturesTaken = new HashMap<Lecture, LetterGrade>();
		}
	}

	// Creating get and set methods for variables
	public Map<Lecture, LetterGrade> getListOfLecturesTaken() {
		return listOfLecturesTaken;
	}

	public int getCreditsTaken() {
		return creditsTaken;
	}

	public int getCreditsCompleted() {
		return creditsCompleted;
	}

	public double getPoints() {
		return points;
	}

	public double getYano() {
		return yano;
	}

	private boolean hasPreqLectureTaken(Lecture preqLecture, List<Lecture> listOfLecture) {
		for(Lecture lecture : listOfLecture) {
			if(lecture.getName() == preqLecture.getName())
				return true;
		}
		return false;
	}
	
	private boolean takenPoint(Lecture lecture, Map<Lecture, LetterGrade> listOfLecturesTaken) {
		boolean point = true;
		if(listOfLecturesTaken.get(lecture).getLetterGradeValue() > 1.99)
			point = false;
		return point;
	}
	
	private boolean canTakeLecture(Lecture lecture, Transcript transcript) {
		boolean canTake;
		
		List<Lecture> listOfTaken = new ArrayList<>();
		
		int a = 0;
		boolean in = false;
		
		for (int i = 0 ; i< transcript.getListOfSemester().size(); i++) {
			Semester semester = transcript.getListOfSemester().get(i);
			for (Lecture lectureTaken : semester.getListOfLecturesTaken().keySet()) {
				listOfTaken.add(lectureTaken);
				if (lectureTaken.getName() == lecture.getName()) {
					a = i;
					in = true;
				}
			}
		}
		if(canTake = hasPreqLectureTaken(lecture.getPrerequisite(),listOfTaken)) {
			if(in) {
				canTake = takenPoint(lecture, transcript.getListOfSemester().get(a).getListOfLecturesTaken());
			}
		}
		return canTake;
	}

	public void setListOfLecturesTaken(Map<Lecture, LetterGrade> listOfLecturesTaken) {
		this.listOfLecturesTaken = listOfLecturesTaken;
	}
	
	private int creditsTakenCalculator(Map<Lecture, LetterGrade> listOfLecturesTaken){
		int totalCredit = 0;
		for(Lecture lecture : listOfLecturesTaken.keySet()) {
			totalCredit = totalCredit + lecture.getCredit();
		}
		
		return totalCredit;
	}
	
	private int creditsCompletedCalculator(Map<Lecture, LetterGrade> listOfLecturesTaken){
		int totalCredit = 0;
		for(Lecture lecture : listOfLecturesTaken.keySet()) {
			if(listOfLecturesTaken.get(lecture) != LetterGrade.FD && listOfLecturesTaken.get(lecture) != LetterGrade.FF)
				totalCredit = totalCredit + lecture.getCredit();
		}
		
		return totalCredit;
	}
	
	private double pointsCalculator(Map<Lecture, LetterGrade> listOfLecturesTaken) {
		double points = 0;
		for(Lecture lecture : listOfLecturesTaken.keySet()) {
			points = points + (lecture.getCredit() * listOfLecturesTaken.get(lecture).getLetterGradeValue());
		}
		
		return points;
	}

}