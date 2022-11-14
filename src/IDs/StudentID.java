package IDs;

//Samet CAN 150120528
public class StudentID implements UniqueID {
	
	private int departmentCode;
	private int yearCode;
	private int orderOfPlacement;
	
	public void setID(int DepartmentCode, int YearCode, int OrderOfPlacement) {
		this.departmentCode = DepartmentCode;
		this.yearCode = YearCode;
		this.orderOfPlacement = OrderOfPlacement;
	}
	
	public String getID() {
		return departmentCode +""+ yearCode +""+ orderOfPlacement;
	}
	
	public void setID(String string) {
		try {
			Integer.parseInt(string);
		}
		catch(NumberFormatException e) {
			
		}
		finally {
			this.departmentCode = Integer.parseInt(string.substring(0,3));
			this.yearCode = Integer.parseInt(string.substring(3,6));
			this.orderOfPlacement = Integer.parseInt(string.substring(6));
		}
			
	}

}