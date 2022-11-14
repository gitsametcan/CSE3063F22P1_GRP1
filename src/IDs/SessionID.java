package IDs;

//Samet CAN 150120528
public class SessionID implements UniqueID {

	private int id;

	public void setID(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {

		} finally {
			this.id = Integer.parseInt(string);
		}

	}

	public void setID(int Id) {
		this.id = Id;
	}

	public String getID() {
		return "" + id;
	}

}
