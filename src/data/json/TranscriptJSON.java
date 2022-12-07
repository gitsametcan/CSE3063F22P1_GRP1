package data.json;

import java.util.List;

public class TranscriptJSON {
	
	private String studentID;
	private List<SemesterJSON> listOfSemesters;
	private double gano;
	private int totalCreditsTaken;
	private int totalCreditsCompleted;
	private double points;
	
	public TranscriptJSON(String studentID, double gano, int totalCreditsTaken, int totalCreditsCompleted,
			double points) {
		super();
		this.studentID = studentID;
		this.gano = gano;
		this.totalCreditsTaken = totalCreditsTaken;
		this.totalCreditsCompleted = totalCreditsCompleted;
		this.points = points;
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public List<SemesterJSON> getListOfSemesters() {
		return listOfSemesters;
	}
	public void setListOfSemesters(List<SemesterJSON> listOfSemesters) {
		this.listOfSemesters = listOfSemesters;
	}
	public double getGano() {
		return gano;
	}
	public void setGano(double gano) {
		this.gano = gano;
	}
	public int getTotalCreditsTaken() {
		return totalCreditsTaken;
	}
	public void setTotalCreditsTaken(int totalCreditsTaken) {
		this.totalCreditsTaken = totalCreditsTaken;
	}
	public int getTotalCreditsCompleted() {
		return totalCreditsCompleted;
	}
	public void setTotalCreditsCompleted(int totalCreditsCompleted) {
		this.totalCreditsCompleted = totalCreditsCompleted;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	
	
}
