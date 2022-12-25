package data.json;

import java.util.HashMap;
import java.util.Map;

public class ScheduleJSON {
	// LectureID / SessionID
	private Map<String, String> sessions;
	private String ID;
	private String term;
	private String termYear;

	public ScheduleJSON(String ID, String term, String termYear) {
		sessions = new HashMap<String, String>();
		this.ID = ID;
		this.term = term;
		this.termYear = termYear;
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

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTermYear(String termYear) {
		this.termYear = termYear;
	}

	public String getTermYear() {
		return termYear;
	}

}
