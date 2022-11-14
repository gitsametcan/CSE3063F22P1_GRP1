package IDs;

//Samet CAN 150120528
public class LectureID implements UniqueID {

	private String departmentCode;
	private int yearCode;
	private int lectureCode;

	public void setID(String string) {
		try {
			Integer.parseInt(string.substring(3));
		} catch (NumberFormatException e) {

		} finally {
			this.departmentCode = string.substring(0, 3);
			this.yearCode = Integer.parseInt(string.substring(3, 6));
			this.lectureCode = Integer.parseInt(string.substring(6));
		}

	}

	public void setID(String DepartmentCode, int YearCode, int LectureCode) {
		this.departmentCode = DepartmentCode;
		this.yearCode = YearCode;
		this.lectureCode = LectureCode;
	}

	public String getID() {
		return departmentCode + "" + yearCode + "" + lectureCode;
	}

}
