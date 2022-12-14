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

}
