package data.json;

import java.util.HashMap;
import java.util.Map;

public class ScheduleJSON {
	// LectureID / SessionID
	private Map<String, String> sessions;
	private String ID;

	public ScheduleJSON() {
		sessions = new HashMap<String, String>();
	}

	public Map<String, String> getSessions() {
		return sessions;
	}

	public void setSessions(Map<String, String> sessions) {
		this.sessions = sessions;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
