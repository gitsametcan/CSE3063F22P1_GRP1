//Kadir Berk Yağar 150120016

package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	private List<Advisor> advisorObjectList;
	
	private ObjectGenerator objectGenerator;
	private JsonGenerator jsonGenerator;
	private MetaData metaData;
	private NamePool namePool;
	
	public JsonOperator() {
		lectureList = new ArrayList<LectureJSON>();
		studentList = new ArrayList<StudentJSON>();
		transcriptList = new ArrayList<TranscriptJSON>();
		advisorList = new ArrayList<AdvisorJSON>();
		
		JsonReader json = new JsonReader("JSON Files/MetaData.JSON");
		MetaData metaData = json.readJsonFile(MetaData.class);
		this.metaData = metaData;

		jsonGenerator = new JsonGenerator(this);

	}
	
	public void readNamePool() {
		JsonReader json = new JsonReader(metaData.getNamePoolPath());
		NamePool namePool = json.readJsonFile(NamePool.class);
		this.namePool = namePool;
	}
	
	public void readMetaData() {
		JsonReader json = new JsonReader("JSON Files/MetaData.JSON");
		MetaData metaData = json.readJsonFile(MetaData.class);
		this.metaData = metaData;
	}

	public void readLectureJSON(String path){
		JsonReader json = new JsonReader(metaData.getLecturesPath() + path);
		LectureJSON tempLecture = json.readJsonFile(LectureJSON.class);
		lectureList.add(tempLecture);
	}
	
	public void readStudentJSON(String path) {
		JsonReader json = new JsonReader(metaData.getStudentsPath() + path);
		StudentJSON tempStudent = json.readJsonFile(StudentJSON.class);
		studentList.add(tempStudent);
	}
	
	public void readTranscriptJSON(String path) {
		JsonReader json = new JsonReader(metaData.getTranscriptsPath() + path);
		TranscriptJSON tempStudent = json.readJsonFile(TranscriptJSON.class);
		transcriptList.add(tempStudent);
	}
	
	public void readAdvisorJSON(String path) {
		JsonReader json = new JsonReader(metaData.getAdvisorsPath() + path);
		AdvisorJSON tempStudent = json.readJsonFile(AdvisorJSON.class);
		advisorList.add(tempStudent);
	}
	
	public MetaData getMetaData() {
		return metaData;
	}
	
	public Optional<NamePool> getNamePool() {
		return Optional.ofNullable(namePool);
	}
	
	public JsonGenerator getJsonGenerator() {
		return this.jsonGenerator;
	}

	public List<Lecture> getReadLectures() {
		return lectureObjectList;
	}
	
	public List<Student> getReadStudents() {
		return studentObjectList;
	}

	public List<Advisor> getReadAdvisors() {
		return advisorObjectList;
	}


	public void generateObjects() {
		 objectGenerator = new ObjectGenerator(lectureList, studentList, transcriptList, advisorList);
		 objectGenerator.generateObjects();
		 objectGenerator.pairObjects();
		 
		 this.lectureObjectList = objectGenerator.getLectureObjects();
		 this.studentObjectList = objectGenerator.getStudentObjects();
		 this.advisorObjectList = objectGenerator.getAdvisorObjects();
	
	}

	
	
}
