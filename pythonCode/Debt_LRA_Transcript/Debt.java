package Debt_LRA_Transcript;
// Sena VATANSEVER 150119755

import person.Student;

public class Debt {

	double amount;
	Student student;

	public Debt(double amount, Student student) {
		super();
		this.amount = amount;
		this.student = student;
	}

	// Creating get and set methods for variables
	public double getAmount() {
		return amount;
	}

	public Student getStudent() {
		return student;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
