//Samet CAN 150120528
public class InstructorID implements UniqueID {

	private int departmentCode;
	private int orderOfEntry;
	
	public void setID(String string) {
		
	}
	
	public void SetId(int DepartmentCode, int OrderOfEntry) {
		this.departmentCode = DepartmentCode;
		this.orderOfEntry = OrderOfEntry;
	}
	
	public String getID() {
		return departmentCode +""+ orderOfEntry ;
	}
}
