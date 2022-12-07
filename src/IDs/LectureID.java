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

	// A method for giving fixed amount of numbers according to input number
	public String digitFixer(int integer) {
		String tempOrder = "" + integer;
		if (integer < 10) {
			tempOrder = "00" + tempOrder;
		} else if (integer < 100) {
			tempOrder = "0" + tempOrder;
		}
		return tempOrder;
	}

}
