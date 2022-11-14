// Kadir Berk Yagar 150120016

package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Enums.FilterType;
import lecture.Lecture;
import person.Advisor;
import person.Instructor;
import person.Person;
import person.Student;

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
			if (filterType == FilterType.ID && lecture.getId().getID().contains(searchKey) ||
					filterType == FilterType.Name && lecture.getName().contains(searchKey)) {
				return lecture;
			}
		}
		return null;
	}

	private <T> T searchInCache(FilterType filterType, String searchKey, Class<T> type) {
		for (Person person : cacheList) {
			if (person instanceof T) {
				if (filterType == FilterType.ID && person.getId().contains(searchKey) ||
						filterType == FilterType.Name && person.getFullName().contains(searchKey)) {
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
				if (filterType == FilterType.ID && person.getId().contains(searchKey) ||
						filterType == FilterType.Name && person.getFullName().contains(searchKey)) {
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
	
	private void loadLectures() throws FileNotFoundException {
		File[] files = listOfFilesInDirectory("/Lectures/");
		
		for (File file : files) {
			Lecture lecture = JsonOperator.getInstance().readJsonFile(file, Lecture.class);
			listOfLectures.add(lecture);
		}
	}
	
	private void loadAdvisors() throws FileNotFoundException {
		File[] files = listOfFilesInDirectory("/Advisors/");
		
		for (File file : files) {
			Advisor advisor = JsonOperator.getInstance().readJsonFile(file, Advisor.class);
			listOfPeople.add(advisor);
		}
	}
	
	private void loadInstructors() throws FileNotFoundException {
		File[] files = listOfFilesInDirectory("/Instructors/");
		
		for (File file : files) {
			Instructor instructor = JsonOperator.getInstance().readJsonFile(file, Instructor.class);
			listOfPeople.add(instructor);
		}
	}
	
	private void loadStudents() throws FileNotFoundException {
		File[] files = listOfFilesInDirectory("/Students/");
		
		for (File file : files) {
			Student student = JsonOperator.getInstance().readJsonFile(file, Student.class);
			listOfPeople.add(student);
		}
	}
	
}
