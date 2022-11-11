//Kaan Camci 150119063
public class Instructor extends Person{

	protected InstructorID id;
	private List<Lecture> listOfLectures;
	protected Calendar dateOfEntry;

	public InstructorID getId() {
		return id;
	}
	public List<Lecture> getListOfLectures() {
		return listOfLectures;
	}
	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}
	
	public void addLecture(Lecture lecture) {
		this.listOfLectures.add(lecture);
	}
	public void removeLecture(Lecture lecture) {
		this.listOfLectures.remove(lecture);
	}
	
}
