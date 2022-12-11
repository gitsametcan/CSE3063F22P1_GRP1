package IDs;

//Samet CAN 150120528
public class SessionID implements UniqueID {

	private int id;

	public SessionID(int id) {
		super();
		this.id = id;
	}

	// Another set method for ID
	public void setID(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {

		} finally {
			this.id = Integer.parseInt(string);
		}

	}

	// Set and get methods for ID
	public void setID(int Id) {
		this.id = Id;
	}

	public String getID() {
		return id + "";
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
