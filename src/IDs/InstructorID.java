package IDs;

//Samet CAN 150120528
public class InstructorID implements UniqueID {

	private int departmentCode;
	private int orderOfEntry;
	
	public void setID(String string) {
		try {
			Integer.parseInt(string);
		}
		catch(NumberFormatException e) {
			
		}
		finally {
			this.departmentCode = Integer.parseInt(string.substring(0,3));
			this.orderOfEntry = Integer.parseInt(string.substring(3));
		}
		
	}
	
	public void SetId(int DepartmentCode, int OrderOfEntry) {
		this.departmentCode = DepartmentCode;
		this.orderOfEntry = OrderOfEntry;
	}
	
	public String getID() {
		return departmentCode +""+ orderOfEntry ;
	}
}
