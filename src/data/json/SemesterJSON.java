package data.json;

import java.util.HashMap;
import java.util.Map;

public class SemesterJSON {

	// LectureID, LetterGrade
	private Map<String, String> listOfLecturesTaken;
	private int creditsTaken;
	private int creditsCompleted;
	private double points;
	private double yano;

	public SemesterJSON(int creditsTaken, int creditsCompleted, double points, double yano, Map<String, String> listOfLecturesTaken) {
		super();
		this.creditsTaken = creditsTaken;
		this.creditsCompleted = creditsCompleted;
		this.points = points;
		this.yano = yano;
		
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

	public int getCreditsTaken() {
		return creditsTaken;
	}

	public void setCreditsTaken(int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}

	public int getCreditsCompleted() {
		return creditsCompleted;
	}

	public void setCreditsCompleted(int creditsCompleted) {
		this.creditsCompleted = creditsCompleted;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public double getYano() {
		return yano;
	}

	public void setYano(double yano) {
		this.yano = yano;
	}
}
