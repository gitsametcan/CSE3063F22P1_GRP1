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

	private DataManager() throws FileNotFoundException {
		listOfLectures = new ArrayList<Lecture>();
		listOfPeople = new ArrayList<Person>();
		cacheList = new LinkedList<Person>();

		loadLectures();
		loadAdvisors();
		loadInstructors();
		loadStudents();

	}

	public static DataManager getInstance() throws FileNotFoundException {
		if (singleInstance == null) {
			singleInstance = new DataManager();
		}
		return singleInstance;
	}
	//A method for finding datas from Lecture Class
	public Lecture findLecture(FilterType filterType, String searchKey) {
		for (Lecture lecture : listOfLectures) {
			if (filterType == FilterType.ID && lecture.getId().getID().contains(searchKey)
					|| filterType == FilterType.Name && lecture.getName().contains(searchKey)) {
				return lecture;
			}
		}
		return null;
	}
/*
	private Person searchInCache(FilterType filterType, String searchKey) {
		for (Person person : cacheList) {
			if (filterType == FilterType.ID && person.getId().toLowerCase().equals(searchKey)
					|| filterType == FilterType.Name && person.getFullName().toLowerCase().equals(searchKey)) {
				((LinkedList<Person>) cacheList).offerFirst(person);
				((Object) cacheList).removeLastOccurence(person);
				return person;
			}
		}
		return null;
	}
*/
	private Person searchInPerson(FilterType filterType, String searchKey) {
		for (Person person : listOfPeople) {
			if (filterType == FilterType.ID && person.getId().toLowerCase().equals(searchKey)
					|| filterType == FilterType.Name && person.getFullName().toLowerCase().equals(searchKey)) {
				((LinkedList<Person>) cacheList).offerFirst(person);
				if (cacheList.size() > 50) {
					((LinkedList<Person>) cacheList).removeLast();
				}
				return person;
			}
		}
		return null;
	}
	//A method for finding datas from Person Class
	public Person findPerson(FilterType filterType, String searchKey) {
		/*Person value = searchInCache(filterType, searchKey);
		if (value != null) {
			return value;
		}*/

		return searchInPerson(filterType, searchKey);
	}
	//A method for finding datas from Student Class
	public Student findStudent(FilterType filterType, String searchKey) {
		/*Student value = searchInCache(filterType, searchKey);
		if (value != null) {
			return value;
		}*/

		return (Student) searchInPerson(filterType, searchKey);
	}
	//A method for finding datas from Instructor Class
	public Instructor findInstructor(FilterType filterType, String searchKey) {
		/*Instructor value = searchInCache(filterType, searchKey, Instructor.class);
		if (value != null) {
			return value;
		}*/

		return (Instructor) searchInPerson(filterType, searchKey);
	}
	//A method for finding datas from Advisor Class
	public Advisor findAdvisor(FilterType filterType, String searchKey) {
		/*Advisor value = searchInCache(filterType, searchKey, Advisor.class);
		if (value != null) {
			return value;
		}*/

		return (Advisor) searchInPerson(filterType, searchKey);
	}

	private File[] listOfFilesInDirectory(String directory) {
		File dir = new File(directory);

		File[] matches = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".json");
			}
		});
		return matches;
	}
	//A method for loading datas from Lecture Class
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
