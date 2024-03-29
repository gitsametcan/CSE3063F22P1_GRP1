//Samet CAN 150120528
package IDs;

public class InstructorID implements UniqueID{

	private int departmentCode;
	private int orderOfEntry;

	public InstructorID(int departmentCode, int orderOfEntry) {
		super();
		this.departmentCode = departmentCode;
		this.orderOfEntry = orderOfEntry;
	}
	//Another set method for ID
	public void setID(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {

		} finally {
			this.departmentCode = Integer.parseInt(string.substring(0, 3));
			this.orderOfEntry = Integer.parseInt(string.substring(3));
		}

	}
	//Set and get methods for ID
	public void SetId(int DepartmentCode, int OrderOfEntry) {
		this.departmentCode = DepartmentCode;
		this.orderOfEntry = OrderOfEntry;
	}

	public String getID() {
		return digitFixer(departmentCode) + digitFixer(orderOfEntry);
	}
	//A method for giving fixed amount of numbers according to input number 
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
