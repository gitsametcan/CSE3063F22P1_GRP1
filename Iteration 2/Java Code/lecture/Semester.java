package lecture;

import java.util.HashMap;
import java.util.Map;

import Enums.LetterGrade;
import Enums.Term;
import Enums.TermYear;

public class Semester {

	private Map<Lecture, LetterGrade> listOfLecturesTaken;
	private int creditsTaken;
	private int creditsCompleted;
	private double points;
	private double yano;
	private Term term;
	private TermYear termYear;

	public Semester(Map<Lecture, LetterGrade> listOfLecturesTaken) {
		super();
		this.listOfLecturesTaken = listOfLecturesTaken;
		if (this.listOfLecturesTaken == null) {
			this.listOfLecturesTaken = new HashMap<Lecture, LetterGrade>();
		}
		this.creditsTaken = creditsTakenCalculator(this.listOfLecturesTaken);
		this.creditsCompleted = creditsCompletedCalculator(this.listOfLecturesTaken);
		this.points = pointsCalculator(this.listOfLecturesTaken);
		this.yano = points / creditsTaken;
		
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

	public void setListOfLecturesTaken(Map<Lecture, LetterGrade> listOfLecturesTaken) {
		this.listOfLecturesTaken = listOfLecturesTaken;
	}
	
	public void addLecture(Lecture lecture) {
		this.listOfLecturesTaken.put(lecture, LetterGrade.None);
	}
	
	public void addLecture(Lecture lecture, LetterGrade grade) {
		this.listOfLecturesTaken.put(lecture, grade);
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