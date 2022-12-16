package simulation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.Transcript;
import Enums.FilterType;
import Enums.Term;
import Enums.TermYear;
import IDs.StudentID;
import data.DataManager;
import data.json.NamePool;
import lecture.Schedule;
import person.Advisor;
import person.Student;

public class StudentGenerator {

	private Transcript transcript;
	private NamePool namePool;

	public StudentGenerator( ) {
		
		Optional<NamePool> optNamePool = DataManager.getInstance().getNamePool();
		namePool = null;
		if (optNamePool.isPresent()) {
			namePool = optNamePool.get();
		}

	}
	
	public Student generate(int year, int semesterCount) {
		
		Calendar dateOfEntry = new GregorianCalendar(2000 + year + 18, 1, 22);
		
		Student student = new Student(getRandomFirstName(),getRandomLastName(),studentIdGenerator(year + 18, semesterCount),null,null, dateOfEntry);
		
		Schedule schedule = new Schedule(student, Term.values()[semesterCount % 2],TermYear.values()[semesterCount / 2]);
		
		student.setSchedule(schedule);
		student.setDebt(studentDebtGenerator());
		student.setAdvisor(getRandomAdvisor());
		
		return student;
	}
	
	
	
	private String getRandomFirstName() {
		return namePool.getRandomName();
	}
	
	private String getRandomLastName() {
		return namePool.getRandomLastName();
	}
	
	private StudentID studentIdGenerator(int year, int orderOf) {
		return new StudentID(150, year, orderOf);
	}
	private Debt studentDebtGenerator() {
		Debt debt;

		int min = 1;
		int max = 10;
		int a = (int) Math.random() * (max - min + 1) + min;
		if (a <= 3) {
			debt = new Debt(20000, null);
		} else {
			debt = new Debt(0, null);
		}
		return debt;
	}
	
	private Advisor getRandomAdvisor() {
		return DataManager.getInstance().searchAdvisor("", FilterType.Name).get((int) (Math.random() * 13));
	}

}
