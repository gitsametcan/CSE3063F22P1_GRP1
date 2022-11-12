// Kadir Berk Yagar 150120016

package data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.google.gson.Gson;

public class DataManager {
	
	private static DataManager singleInstance = null;
	private List<Lecture> listOfLectures; 
	private List<Person> listOfPeople;
	private List<Person> cacheList;
	
	private DataManager() {
		listOfLectures = new ArrayList<Lecture>();
		listOfPeople = new ArrayList<Person>();
		cacheList = new LinkedList<Person>();
		
		loadLectures();
		loadAdvisors();
		loadInstructors();
		loadStudents();
		
	}
	
	public DataManager getInstance() {
		if (singleInstance == null) {
			singleInstance = new DataManager();
		}
		return singleInstance;
	}
	
	public Lecture findLecture(FilterType filterType, String searchKey) {
		for (Lecture lecture: listOfLectures) {
			if (filterType == FilterType.ID && lecture.getID().contains(searchKey) ||
					filterType == FilterType.Name && lecture.getName().contains(searchKey)) {
				return lecture;
			}
		}
		return null;
	}

	private <T> T searchInCache(FilterType filterType, String searchKey, Class<T> type) {
		for (Person person : cacheList) {
			if (person instanceof T) {
				if (filterType == FilterType.ID && person.getID().contains(searchKey) ||
						filterType == FilterType.Name && person.getName().contains(searchKey)) {
					cacheList.offerFirst(person);
					cacheList.removeLastOccurence(person);
					return person;
				}
			}
		}
		return null;
	}
	
	private <T> T searchInPerson(FilterType filterType, String searchKey, Class<T> type) {
		for (Person person: listOfPeople) {
			if (person instanceof T) {
				if (filterType == FilterType.ID && person.getID().contains(searchKey) ||
						filterType == FilterType.Name && person.getName().contains(searchKey)) {
					cacheList.offerFirst(person);
					if (cacheList.size() > 50) {
						cacheList.removeLast();
					}
					return person;
				}
			}
		}
		return null;
	}
	
	public Person findPerson(FilterType filterType, String searchKey) {
		Person value = searchInCache(filterType, searchKey, Person.class);
		if (value != null) {
			return value;
		}
		
		return searchInPerson(filterType, searchKey, Person.class);
	}
	
	public Student findStudent(FilterType filterType, String searchKey) {
		Student value = searchInCache(filterType, searchKey, Student.class);
		if (value != null) {
			return value;
		}
		
		return searchInPerson(filterType, searchKey, Student.class);
	}
	
	public Instructor findInstructor(FilterType filterType, String searchKey) {
		Instructor value = searchInCache(filterType, searchKey, Instructor.class);
		if (value != null) {
			return value;
		}
		
		return searchInPerson(filterType, searchKey, Instructor.class);
	}
	
	public Advisor findAdvisor(FilterType filterType, String searchKey) {
		Advisor value = searchInCache(filterType, searchKey, Advisor.class);
		if (value != null) {
			return value;
		}
		
		return searchInPerson(filterType, searchKey, Advisor.class);
	}
	
	private File[] listOfFilesInDirectory(String directory) {
		File dir = new File(directory);

		File[] matches = dir.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".json");
				}
			}
		);
		return matches;
	}
	
	private List<String> contentsOfFiles(File[] fileList) {
		List<String> contentList = new ArrayList<String>();
		for (File file : fileList) {
			Scanner scanner = new Scanner(file);
			if (scanner.hasNextLine()) {
				contentList.add(scanner.nextLine());
			}
		}
		return contentList;
	}
	
	private void loadLectures() {
		File[] files = listOfFilesInDirectory("/Lectures/");
		List<String> contents = contentsOfFiles(files);
		
		Gson jsonReader = new Gson();
		for (String s : contents) {
			Lecture lecture = jsonReader.fromJson(s, Lecture.class);
			listOfLectures.add(lecture);
		}
	}
	
	private void loadAdvisors() {
		File[] files = listOfFilesInDirectory("/Advisors/");
		List<String> contents = contentsOfFiles(files);
		
		Gson jsonReader = new Gson();
		for (String s : contents) {
			Advisor lecture = jsonReader.fromJson(s, Advisor.class);
			listOfPeople.add(lecture);
		}
	}
	
	private void loadInstructors() {
		File[] files = listOfFilesInDirectory("/Instructors/");
		List<String> contents = contentsOfFiles(files);
		
		Gson jsonReader = new Gson();
		for (String s : contents) {
			Instructor lecture = jsonReader.fromJson(s, Instructor.class);
			listOfPeople.add(lecture);
		}
	}
	
	private void loadStudents() {
		File[] files = listOfFilesInDirectory("/Students/");
		List<String> contents = contentsOfFiles(files);
		
		Gson jsonReader = new Gson();
		for (String s : contents) {
			Student lecture = jsonReader.fromJson(s, Student.class);
			listOfPeople.add(lecture);
		}
	}
	
}
