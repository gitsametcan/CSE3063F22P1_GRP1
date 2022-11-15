package IDs;

//Samet CAN 150120528
public class LectureID implements UniqueID, Cloneable {

	private String departmentCode;
	private int yearCode;
	private int lectureCode;

	public LectureID(String departmentCode, int yearCode, int lectureCode) {
		super();
		this.departmentCode = departmentCode;
		this.yearCode = yearCode;
		this.lectureCode = lectureCode;
	}

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
		return digitFixer(Integer.parseInt(departmentCode)) + digitFixer(yearCode) + digitFixer(lectureCode);
	}

	public String digitFixer(int integer) {
		String tempOrder = "" + integer;
		if (integer < 10) {
			tempOrder = "00" + tempOrder;
		} else if (integer < 100) {
			tempOrder = "0" + tempOrder;
		}
		return tempOrder;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}