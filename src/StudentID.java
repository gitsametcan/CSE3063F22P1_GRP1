
public class StudentID implements UniqueID {
	
	private int departmentCode;
	private int yearCode;
	private int lectureCode;
	
	public void setID(int DepartmentCode, int YearCode, int LectureCode) {
		this.departmentCode = DepartmentCode;
		this.yearCode = YearCode;
		this.lectureCode = LectureCode;
	}
	
	public String getID() {
		return departmentCode +""+ yearCode +""+ lectureCode;
	}
	

	public void setID(String string) {
		
	}

}
