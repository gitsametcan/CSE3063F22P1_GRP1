package lecture;

import java.util.HashMap;
import java.util.Map;

import Enums.LetterGrade;

//Serdar Alsan	150120034 
public class Semester {

	private Map<Lecture, LetterGrade> listOfLecturesTaken;
	private int creditsTaken;
	private int creditsCompleted;
	private double points;
	private double yano;

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

	public void addLecture(Lecture lecture, LetterGrade lectureGrade) {
		this.listOfLecturesTaken.put(lecture, lectureGrade);
	}

	public void removeLecture(Lecture lecture, LetterGrade lectureGrade) {
		this.listOfLecturesTaken.remove(lecture, lectureGrade);
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