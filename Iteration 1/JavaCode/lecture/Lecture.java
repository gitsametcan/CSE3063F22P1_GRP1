package lecture;

import java.util.ArrayList;
import java.util.List;

import Enums.LectureType;
import IDs.LectureID;

//Serdar Alsan	150120034 
public class Lecture {

	private LectureID id;
	private String name;
	private LectureType lectureType;
	private int credit;
	private List<LectureSession> sessions;
	private Lecture prerequisite;
	private int quota;
	
	public Lecture(LectureID id, String name, LectureType lectureType, int credit, List<LectureSession> sessions,
			Lecture prerequisite, int quota) {
		super();
		
		this.id = id;
		this.name = name;
		this.lectureType = lectureType;
		this.credit = credit;
		this.sessions = sessions;
		this.prerequisite = prerequisite;
		this.quota = quota;
		
		if (sessions == null) {
			this.sessions = new ArrayList<LectureSession>();
		}
	}
	//Creating get and set methods for variables
	public String getID() {
		return id.getID();
	}

	public String getName() {
		return name;
	}

	public LectureType getLectureType() {
		return lectureType;
	}

	public int getCredit() {
		return credit;
	}

	public List<LectureSession> getSessions() {
		return sessions;
	}

	public Lecture getPrerequisite() {
		return prerequisite;
	}

	public int getQuota() {
		return quota;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLectureType(LectureType lectureType) {
		this.lectureType = lectureType;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}
	//Creating add and remove methods for array variables
	public void addLectureSession(LectureSession lectureSession) {
		this.sessions.add(lectureSession);
	}

	public void removeLectureSession(LectureSession lectureSession) {
		this.sessions.remove(lectureSession);
	}

	public void addPrerequisiteLecture(Lecture lecture) {
		prerequisite = lecture;
	}

	public void removePrerequisitielLecture() {
		this.prerequisite = null;
	}

}