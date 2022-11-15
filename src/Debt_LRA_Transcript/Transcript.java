package Debt_LRA_Transcript;

import java.util.ArrayList;

import lecture.Semester;
import person.Student;

//Sena VATANSEVER 150119755

public class Transcript {

	Student student;
	ArrayList<Semester> listOfSemester;
	double gano;
	int totalCreditsTaken;
	int totalCreditsCompleted;
	double points;

	public Transcript(Student student, ArrayList<Semester> listOfSemester, double gano, int totalCreditsTaken,
			int totalCreditsCompleted, double points) {
		super();
		this.student = student;
		student.setTranscript(this);
		this.listOfSemester = listOfSemester;
		this.gano = gano;
		this.totalCreditsTaken = totalCreditsTaken;
		this.totalCreditsCompleted = totalCreditsCompleted;
		this.points = points;
	}

	public Student getStudent() {
		return student;
	}

	public ArrayList<Semester> getListOfSemester() {
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
}