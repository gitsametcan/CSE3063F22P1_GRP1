package person;

import java.util.Calendar;
import java.util.List;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import IDs.StudentID;
import lecture.LectureSession;

//Kaan Camci 150119063
public class Student extends Person {

	private transient Advisor advisor;
	private StudentID id;
	private List<LectureSession> listOfLectureSessions;
	private Transcript transcript;
	private Calendar dateOfEntry;
	private Debt debt;
	private LectureRegistrationApplication registirationApplication;

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public Debt getDebt() {
		return debt;
	}

	public void setDebt(Debt debt) {
		this.debt = debt;
	}

	public LectureRegistrationApplication getRegistirationApplication() {
		return registirationApplication;
	}

	public void setRegistirationApplication(LectureRegistrationApplication registirationApplication) {
		this.registirationApplication = registirationApplication;
	}

	public String getId() {
		return id.getID();
	}

	public List<LectureSession> getListOfLectureSessions() {
		return listOfLectureSessions;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}

	public Student(StudentID id, List<LectureSession> listOfLectureSessions, Transcript transcript,
			Calendar dateOfEntry) {
		super();
		this.id = id;
		this.listOfLectureSessions = listOfLectureSessions;
		this.transcript = transcript;
		this.dateOfEntry = dateOfEntry;
	}

}
