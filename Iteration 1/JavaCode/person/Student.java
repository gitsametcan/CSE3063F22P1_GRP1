package person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.ApprovalState;
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
	
	//Creating get and set methods for variables
	public void setId(StudentID id) {
		this.id = id;
	}

	public void setListOfLectureSessions(List<LectureSession> listOfLectureSessions) {
		this.listOfLectureSessions = listOfLectureSessions;
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

	public Student(String firstName, String lastName, StudentID id, List<LectureSession> listOfLectureSessions,
			Transcript transcript, Calendar dateOfEntry) {
		super(firstName, lastName);
		this.id = id;
		this.listOfLectureSessions = new ArrayList<LectureSession>();
		this.transcript = transcript;
		this.dateOfEntry = dateOfEntry;
	}
	
	public void sendForApproval(List <LectureSession> chosenLectureSessions) {
		HashMap <LectureSession, ApprovalState> approvalList = new HashMap <LectureSession, ApprovalState>();
		for(LectureSession ls: chosenLectureSessions) {
			approvalList.put(ls, ApprovalState.Pending);
		}
		this.registirationApplication = new LectureRegistrationApplication(approvalList, this.advisor, this);
		this.advisor.getListOfApplications().add(this.registirationApplication);
	}

}
