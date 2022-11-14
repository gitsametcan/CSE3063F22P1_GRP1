package lecture;
import java.util.HashMap;

import Enums.LetterGrade;

//Serdar Alsan	150120034 
public class Semester{
	
	private HashMap<Lecture, LetterGrade> listOfLecturesTaken;
	private int creditsTaken;
	private int creditsCompleted;
	private double points;
	
	public HashMap<Lecture,LetterGrade> getListOfLecturesTaken() {
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
	
	public void setLecture(Lecture lecture, LetterGrade lectureGrade) {
		this.listOfLecturesTaken = listOfLecturesTaken;
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