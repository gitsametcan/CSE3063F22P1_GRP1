package simulation;

import java.util.Calendar;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.Transcript;
import IDs.StudentID;
import data.json.NamePool;
import lecture.Schedule;
import person.Student;

public class StudentGenerator {

	public Student studentGenerator(int year, int orderOfPlacement) {
		String firstName = null;
		String lastName = null;
		StudentID id = null;
		Schedule schedule = null;
		Transcript transcript = null;
		Calendar dateOfEntry = null;
		Debt debt = null;
		Student student = null;
		int min = 1;
		int max = 10;
		double a = Math.random() * (max - min + 1) + min;
		if (a <= 3) {
			debt = new Debt(20000, student);
		} else {
			debt = new Debt(0, student);
		}

		NamePool namePool = new NamePool();

		firstName = namePool.getRandomFirstName();
		lastName = namePool.getRandomLastName();
		id = new StudentID(150, 100 + year, orderOfPlacement);

		student = new Student(firstName, lastName, id, schedule, transcript, dateOfEntry);
		student.setDebt(debt);

		return student;
	}

}
