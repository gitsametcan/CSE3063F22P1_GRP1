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
	double yano;

	public Semester(HashMap<Lecture, LetterGrade> listOfLecturesTaken, int creditsTaken, int creditsCompleted,
			double points, double yano) {
		super();
		this.listOfLecturesTaken = listOfLecturesTaken;
		this.creditsTaken = creditsTaken;
		this.creditsCompleted = creditsCompleted;
		this.points = points;
		this.yano = yano;
		if (this.listOfLecturesTaken == null) {
			this.listOfLecturesTaken = new HashMap<Lecture, LetterGrade>();
		}
	}
	//Creating get and set methods for variables
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
	
	public void setCreditsTaken(int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}

	public void setCreditsCompleted(int creditsCompleted) {
		this.creditsCompleted = creditsCompleted;
	}

	public void setPoints(double points) {
		this.points = points;
	}

}