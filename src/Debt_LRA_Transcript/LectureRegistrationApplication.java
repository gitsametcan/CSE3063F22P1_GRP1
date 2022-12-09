package Debt_LRA_Transcript;

import java.util.HashMap;
import java.util.Map;

import Enums.ApprovalState;
import lecture.LectureSession;
import person.Advisor;
import person.Student;

//Sena VATANSEVER 150119755

public class LectureRegistrationApplication {

	private Map<LectureSession, ApprovalState> sessionsSentForApproval;
	private Advisor advisor;
	private Student student;
	

	public LectureRegistrationApplication(Map<LectureSession, ApprovalState> sessionsSentForApproval, Advisor advisor,
			Student student) {
		super();
		this.sessionsSentForApproval = sessionsSentForApproval;
		this.advisor = advisor;
		this.student = student;
		
		if (this.sessionsSentForApproval == null) {
			this.sessionsSentForApproval = new HashMap<LectureSession, ApprovalState>();
		}
	}
	
	public Map<LectureSession, ApprovalState> getSessionsSentForApproval() {
		return this.sessionsSentForApproval;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public Student getStudent() {
		return student;
	}

	public void setSessionsSentForApproval(Map<LectureSession, ApprovalState> sessionsSentForApproval) {
		this.sessionsSentForApproval = sessionsSentForApproval;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
