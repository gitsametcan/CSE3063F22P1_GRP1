package IDs;

//Samet CAN 150120528
public class LectureID implements UniqueID {

	private String lectureCode;

	public LectureID(String lectureCode) {
		super();
		this.lectureCode = lectureCode;
	}

	// Another set method for ID
	public void setID(String string) {
		this.lectureCode = string;

	}

	public String getID() {
		return lectureCode;
	}

}

