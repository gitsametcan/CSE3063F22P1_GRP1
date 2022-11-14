package lecture;
import java.util.List;

import IDs.LectureID;

//Serdar Alsan	150120034 
public class Lecture {

	private LectureID id;
	private String name;
	private LectureType lectureType;
	private int credit;
	private List<LectureSession> sessions;
	private List<Lecture> prerequisities;
	private int quota;

	public LectureID getId() {
		return id;
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
	public List<Lecture> getPrerequisities() {
		return prerequisities;
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
	public void addLectureSession(LectureSession lectureSession) {
		this.sessions.add(lectureSession);
	}
	public void removeLectureSession(LectureSession lectureSession) {
		this.sessions.remove(lectureSession);
	}
	public void addPrerequisitielLecture(Lecture lecture) {
		this.prerequisities.add(lecture);
	}
	public void removePrerequisitielLecture(Lecture lecture) {
		this.prerequisities.remove(lecture);
	}
	
}