package data.json;

import java.util.List;

public class LectureJSON {

	private String ID;
	private String Name;
	private String prerequisiteID;
	private String lectureType;
	private int quota;
	private int credit;
	private String term;
	private String termYear;
	private List<LectureSessionJSON> lectureSessions;

	public LectureJSON(String ID, String Name, String prerequisiteID, String lectureType, int quota, int credit, String term, String termYear) {
		this.ID = ID;
		this.Name = Name;
		this.prerequisiteID = prerequisiteID;
		this.lectureType = lectureType;
		this.quota = quota;
		this.credit = credit;
		this.term = term;
		this.termYear = termYear;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getPrerequisiteID() {
		return prerequisiteID;
	}

	public void setPrerequisiteID(String prerequisiteID) {
		this.prerequisiteID = prerequisiteID;
	}

	public String getLectureType() {
		return lectureType;
	}

	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public List<LectureSessionJSON> getLectureSessions() {
		return lectureSessions;
	}

	public void setLectureSessions(List<LectureSessionJSON> lectureSessions) {
		this.lectureSessions = lectureSessions;
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
