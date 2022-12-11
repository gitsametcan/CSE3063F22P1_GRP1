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

	public Transcript(Student student, List<Semester> listOfSemester, double gano, int totalCreditsTaken,
			int totalCreditsCompleted, double points) {
		super();
		this.student = student;
		student.setTranscript(this);
		this.listOfSemester = listOfSemester;
		this.gano = gano;
		this.totalCreditsTaken = totalCreditsTaken;
		this.totalCreditsCompleted = totalCreditsCompleted;
		this.points = points;
		if (this.listOfSemester == null) {
			this.listOfSemester = new ArrayList<Semester>();
		}
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
}
