package data.json;

import java.util.HashMap;
import java.util.Map;

public class ScheduleJSON {
	// LectureID / SessionID
	private Map<String, String> sessions;

	public ScheduleJSON() {
		sessions = new HashMap<String, String>();
	}

	public Map<String, String> getSessions() {
		return sessions;
	}

	public void setSessions(Map<String, String> sessions) {
		this.sessions = sessions;
	}
}
