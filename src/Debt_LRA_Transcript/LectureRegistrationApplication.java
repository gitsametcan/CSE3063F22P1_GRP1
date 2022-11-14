package Debt_LRA_Transcript;

import java.util.Map;

import Enums.ApprovalState;
import lecture.LectureSession;
import person.Advisor;
import person.Student;

//Sena VATANSEVER 150119755

public class LectureRegistrationApplication {

	Map<LectureSession, ApprovalState> sessionsSentForApproval;
	Advisor advisor;
	Student student;

	public LectureRegistrationApplication(Map<LectureSession, ApprovalState> sessionsSentForApproval, Advisor advisor,
			Student student) {
		super();
		this.sessionsSentForApproval = sessionsSentForApproval;
		this.advisor = advisor;
		this.student = student;
	}

	public void approveApplication() {

	}

}
