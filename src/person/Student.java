package person;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.ApprovalState;
import IDs.StudentID;
import lecture.LectureSession;
import lecture.Schedule;

//Kaan Camci 150119063
public class Student extends Person {

	private transient Advisor advisor;
	private StudentID id;
	private Schedule schedule;
	private Transcript transcript;
	private Calendar dateOfEntry;
	private Debt debt;
	private LectureRegistrationApplication registirationApplication;

	public Student(String firstName, String lastName, StudentID id, Schedule schedule, Transcript transcript,
			Calendar dateOfEntry) {
		super(firstName, lastName);
		this.id = id;
		this.schedule = schedule;
		this.transcript = transcript;
		this.dateOfEntry = dateOfEntry;
	}

	// Creating get and set methods for variables
	public void setID(String nID) {
		this.id.setID(nID);
	}
	
	public void setID(int DepartmentCode, int YearCode, int OrderOfPlacement) {
		this.setID(DepartmentCode, YearCode, OrderOfPlacement);
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public void setDateOfEntry(Calendar dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

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

	public String getID() {
		return id.getID();
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}

	public void sendForApproval(List<LectureSession> chosenLectureSessions) {
		HashMap<LectureSession, ApprovalState> approvalList = new HashMap<LectureSession, ApprovalState>();
		for (LectureSession ls : chosenLectureSessions) {
			approvalList.put(ls, ApprovalState.Pending);
		}
		this.registirationApplication = new LectureRegistrationApplication(approvalList, this.advisor, this);
		this.advisor.getListOfApplications().add(this.registirationApplication);
	}

}
