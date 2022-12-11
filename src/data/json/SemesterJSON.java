package data.json;

import java.util.Map;

public class SemesterJSON {

	private Map<LectureJSON, String> listOfLecturesTaken;
	private int creditsTaken;
	private int creditsCompleted;
	private double points;
	private double yano;

	public SemesterJSON(int creditsTaken, int creditsCompleted, double points, double yano) {
		super();
		this.creditsTaken = creditsTaken;
		this.creditsCompleted = creditsCompleted;
		this.points = points;
		this.yano = yano;
	}

	public Map<LectureJSON, String> getListOfLecturesTaken() {
		return listOfLecturesTaken;
	}

	public void setListOfLecturesTaken(Map<LectureJSON, String> listOfLecturesTaken) {
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
