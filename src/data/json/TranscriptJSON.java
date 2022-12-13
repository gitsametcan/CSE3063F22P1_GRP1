package data.json;

import java.util.List;

public class TranscriptJSON {

	private String studentID;
	private List<SemesterJSON> listOfSemesters;

	public TranscriptJSON(String studentID) {
		super();
		this.studentID = studentID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public List<SemesterJSON> getListOfSemesters() {
		return listOfSemesters;
	}

	public void setListOfSemesters(List<SemesterJSON> listOfSemesters) {
		this.listOfSemesters = listOfSemesters;
	}
}
