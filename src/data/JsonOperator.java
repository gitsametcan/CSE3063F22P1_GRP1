//Kadir Berk Yağar 150120016

package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.json.AdvisorJSON;
import data.json.LectureJSON;
import data.json.StudentJSON;
import data.json.TranscriptJSON;

public class JsonOperator {
	
	private List<LectureJSON> lectureList;
	private List<StudentJSON> studentList;
	private List<TranscriptJSON> transcriptList;
	private List<AdvisorJSON> advisorList;
	
	public JsonOperator() {
		lectureList = new ArrayList<LectureJSON>();
		studentList = new ArrayList<StudentJSON>();
		transcriptList = new ArrayList<TranscriptJSON>();
		advisorList = new ArrayList<AdvisorJSON>();
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
	
	
}
