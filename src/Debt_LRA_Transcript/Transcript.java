package Debt_LRA_Transcript;
import java.util.ArrayList;

//Sena VATANSEVER 150119755

public class Transcript {

	Student student;
	ArrayList <Semester> listOfSemester;
	double gano;
	double yano;
	int totalCreditsTaken;
	int totalCreditsCompleted;
	double points;
	
	
	public Student getStudent() {
		return student;
	}
	
	public ArrayList<Semester> getListOfSemester() {
		return listOfSemester;
	}
	
	public double getGano() {
		return gano;
	}
	
	public double getYano() {
		return yano;
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
		Semester semester = new Semester;
		listOfSemester.add(semester);
		
	}
}
