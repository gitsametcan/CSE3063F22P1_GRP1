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

	private Transcript transcript = null;

	public StudentGenerator(Simulation simulation, int year, int orderOfPlacement, int semesterCount) {
		StudentID id = new StudentID(150, 100 + year, orderOfPlacement);
		Student student = new Student(null, null, id, null, null, null);
		String firstName = null;
		String lastName = null;
		
		Schedule schedule = new Schedule(student, Term.values()[semesterCount % 2], TermYear.values()[semesterCount / 2]);
		Calendar dateOfEntry = null;
		Debt debt = null;
		int min = 1;
		int max = 10;
		int a = (int) Math.random() * (max - min + 1) + min;
		if (a <= 3) {
			debt = new Debt(20000, student);
		} else {
			debt = new Debt(0, student);
		}

		dateOfEntry = new GregorianCalendar(2000 + year, 1, 22);

		Optional<NamePool> namePool = DataManager.getInstance().getNamePool();
		NamePool namePool1 = null;
		if (namePool.isPresent()) {
			namePool1 = namePool.get();
		}
		firstName = namePool1.getRandomName();
		lastName = namePool1.getRandomLastName();

		List<Advisor> advisors = DataManager.getInstance().searchAdvisor("", FilterType.Name);
		max = 13;
		a = (int) Math.random() * (max - min + 1) + min;
		student.setAdvisor(advisors.get(a));

		// send lectureSession registration of "first semester lecture sessions" to the
		// advisor of this object

		TranscriptGenerator transcriptGenerator = new TranscriptGenerator(this, schedule);

		student = new Student(firstName, lastName, id, schedule, this.transcript, dateOfEntry);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setSchedule(schedule);
		student.setTranscript(this.transcript);
		student.setDateOfEntry(dateOfEntry);
		student.setDebt(debt);

		simulation.getListOfStudents().add(student);
	}

}
