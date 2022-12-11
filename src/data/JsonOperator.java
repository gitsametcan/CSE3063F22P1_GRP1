//Kadir Berk Yağar 150120016

package data;

import java.util.ArrayList;
import java.util.List;

import Debt_LRA_Transcript.Transcript;
import data.json.AdvisorJSON;
import data.json.LectureJSON;
import data.json.MetaData;
import data.json.NamePool;
import data.json.StudentJSON;
import data.json.TranscriptJSON;
import lecture.Lecture;
import person.Advisor;
import person.Student;

public class JsonOperator {
	
	private List<LectureJSON> lectureList;
	private List<StudentJSON> studentList;
	private List<TranscriptJSON> transcriptList;
	private List<AdvisorJSON> advisorList;
	
	private List<Lecture> lectureObjectList;
	private List<Student> studentObjectList;
	private List<Transcript> transcriptObjectList;
	private List<Advisor> advisorObjectList;
	
	private ObjectGenerator objectGenerator;
	private MetaData metaData;
	private NamePool namePool;
	
	public JsonOperator() {
		lectureList = new ArrayList<LectureJSON>();
		studentList = new ArrayList<StudentJSON>();
		transcriptList = new ArrayList<TranscriptJSON>();
		advisorList = new ArrayList<AdvisorJSON>();
		
		JsonReader json = new JsonReader("metadata.json");
		MetaData metaData = json.readJsonFile(MetaData.class);
		this.metaData = metaData;
	}
	
	public void readNamePool() {
		JsonReader json = new JsonReader(metaData.getNamePoolPath());
		NamePool namePool = json.readJsonFile(NamePool.class);
		this.namePool = namePool;
	}

	public void readLectureJSON(String path){
		JsonReader json = new JsonReader(path);
		LectureJSON tempLecture = json.readJsonFile(LectureJSON.class);
		lectureList.add(tempLecture);
	}
	
	public void readStudentJSON(String path) {
		JsonReader json = new JsonReader(path);
		StudentJSON tempStudent = json.readJsonFile(StudentJSON.class);
		studentList.add(tempStudent);
	}
	
	public void readTranscriptJSON(String path) {
		JsonReader json = new JsonReader(path);
		TranscriptJSON tempStudent = json.readJsonFile(TranscriptJSON.class);
		transcriptList.add(tempStudent);
	}
	
	public void readAdvisorJSON(String path) {
		JsonReader json = new JsonReader(path);
		AdvisorJSON tempStudent = json.readJsonFile(AdvisorJSON.class);
		advisorList.add(tempStudent);
	}
	
	public MetaData getMetaData() {
		return metaData;
	}
	
	public NamePool getNamePool() {
		return namePool;
	}
	
	public void generateObjects() {
		 objectGenerator = new ObjectGenerator(lectureList, studentList, transcriptList, advisorList);
		 objectGenerator.generateObjects();
		 objectGenerator.pairObjects();
		 
		 this.lectureObjectList = objectGenerator.getLectureObjects();
		 this.studentObjectList = objectGenerator.getStudentObjects();
		 this.transcriptObjectList = objectGenerator.getTranscriptObjects();
		 this.advisorObjectList = objectGenerator.getAdvisorObjects();
	
	}

	
	
}
