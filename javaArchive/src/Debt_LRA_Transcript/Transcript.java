package Debt_LRA_Transcript;

import java.util.List;
import java.util.ArrayList;

import lecture.Semester;
import person.Student;

//Sena VATANSEVER 150119755

public class Transcript {

	private Student student;
	private List<Semester> listOfSemester;
	private double gano;
	private int totalCreditsTaken;
	private int totalCreditsCompleted;
	private double points;

	public Transcript(Student student, List<Semester> listOfSemester) {
		super();
		this.student = student;
		this.listOfSemester = listOfSemester;
		if (this.listOfSemester == null) {
			this.listOfSemester = new ArrayList<Semester>();
		}
		this.totalCreditsTaken = totalCreditsTakenCalculator(this.listOfSemester);
		this.totalCreditsCompleted = totalCreditsCompletedCalculator(this.listOfSemester);
		this.points = pointsCalculator(this.listOfSemester);
		this.gano = points / totalCreditsTaken;
		
	}

	// Creating get and set methods for variables
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Semester> getListOfSemester() {
		return listOfSemester;
	}

	public double getGano() {
		return gano;
	}

	public int getTotalCreditsTaken() {
		return totalCreditsTaken;
	}

	public int getTotalCreditsCompleted() {
		return totalCreditsCompleted;
	}

	public double getPoints() {
		return points;
	}

	public void addSemester(Semester semester) {
		listOfSemester.add(semester);
	}
	public void setListOfSemester(List<Semester> listOfSemester) {
		this.listOfSemester = listOfSemester;
	}
	public void setGano(double gano) {
		this.gano = gano;
	}
	public void setTotalCreditsTaken(int totalCreditsTaken) {
		this.totalCreditsTaken = totalCreditsTaken;
	}
	public void setTotalCreditsCompleted(int totalCreditsCompleted) {
		this.totalCreditsCompleted = totalCreditsCompleted;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	
	private int totalCreditsTakenCalculator(List<Semester> listOfSemester) {
		int totalCreditsTaken = 0;
		for(Semester semester : listOfSemester) {
			totalCreditsTaken = totalCreditsTaken + semester.getCreditsTaken();
		}
		return totalCreditsTaken;
	}
	
	private int totalCreditsCompletedCalculator(List<Semester> listOfSemester) {
		int totalCreditsCompleted = 0;
		for(Semester semester : listOfSemester) {
			totalCreditsCompleted = totalCreditsCompleted + semester.getCreditsCompleted();
		}
		return totalCreditsCompleted;
	}
	
	private double pointsCalculator(List<Semester> listOfSemester) {
		double points = 0;
		for(Semester semester : listOfSemester) {
			points = points + semester.getPoints();
		}
		return points;
	}
}
