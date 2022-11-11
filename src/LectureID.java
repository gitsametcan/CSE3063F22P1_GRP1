
public class LectureID implements UniqueID {
	
	private String departmentCode;
	private int yearCode;
	private int lectureCode;
	
	public void setID(String string) {
		
	}
	
	public void setID(String DepartmentCode, int YearCode, int LectureCode) {
		this.departmentCode = DepartmentCode;
		this.yearCode = YearCode;
		this.lectureCode = LectureCode;
	}
	
	public String getID() {
		return departmentCode +""+ yearCode +""+ lectureCode;
	}

}
