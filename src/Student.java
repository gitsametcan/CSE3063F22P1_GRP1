//Kaan Camci 150119063
public class Student extends Person{

	private transient Advisor advisor;
	private StudentID id;
	private List<LectureSession> listOfLectureSessions;
	private Transcript transcript;
	private Calendar dateOfEntry;
	private Debt debt;
	private LectureRegistirationApplication registirationApplication;
	
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
	public LectureRegistirationApplication getRegistirationApplication() {
		return registirationApplication;
	}
	public void setRegistirationApplication(LectureRegistirationApplication registirationApplication) {
		this.registirationApplication = registirationApplication;
	}
	public StudentID getId() {
		return id;
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
	
	
	
	
}
