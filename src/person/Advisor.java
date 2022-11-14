package person;
//Kaan Camci 150119063
public class Advisor extends Instructor{
	
	private List<Student> listOfStudents;
	private List<LectureRegistirationApplication> listOfApplications;
	
	public List<Student> getListOfStudents() {
		return listOfStudents;
	}
	public List<LectureRegistirationApplication> getListOfApplications() {
		return listOfApplications;
	}
	public void approveApplication(LectureRegistirationApplication lectureRegistirationApplication){
		lectureRegistirationApplication.approveApplication();
	}
	
	
}
