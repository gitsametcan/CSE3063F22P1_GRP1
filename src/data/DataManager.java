// Kadir Berk Yagar 150120016

package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DataManager {
	
	private static DataManager singleInstance = null;
	private List<Lecture> listOfLectures; 
	private List<Person> listOfPeople;
	private List<Person> cacheList;
	
	private DataManager() {
		listOfLectures = new ArrayList<Lecture>();
		listOfPeople = new ArrayList<Person>();
		cacheList = new LinkedList<Person>();
		
	}
	
	public DataManager getInstance() {
		if (singleInstance == null) {
			singleInstance = new DataManager();
		}
		return singleInstance;
	}
	
	public List<Lecture> findLecture(FilterType filterType, String searchKey) {
		List<Lecture> returnList = new ArrayList<Lecture>();
		
		for (Lecture lecture: listOfLectures) {
			if (filterType == FilterType.ID && lecture.getID().contains(searchKey) ||
					filterType == FilterType.Name && lecture.getName().contains(searchKey)) {
				returnList.add(lecture);
			}
		}
		
		return returnList;
	}
	
	private <T> List<T> searchInCache(FilterType filterType, String searchKey, Class<T> type) {
		List<T> returnList = new ArrayList<T>();
		for (Person person : cacheList) {
			if (person instanceof T) {
				if (filterType == FilterType.ID && person.getID().contains(searchKey) ||
						filterType == FilterType.Name && person.getName().contains(searchKey)) {
					returnList.add(person);
					cacheList.offerFirst(person);
					cacheList.removeLastOccurence(person);
				}
			}
		}
		return returnList;
	}
	
	private <T> void searchInPerson(List<T> returnList, FilterType filterType, String searchKey, Class<T> type) {
		for (Person person: listOfPeople) {
			if (returnList.contains(person)) {
				continue;
			}
			if (person instanceof T) {
				if (filterType == FilterType.ID && person.getID().contains(searchKey) ||
						filterType == FilterType.Name && person.getName().contains(searchKey)) {
					
					returnList.offer(person);
					cacheList.offerFirst(person);
					if (cacheList.size() > 50) {
						cacheList.removeLast();
					}
				}
			}
		}
		
	}
	
	public List<Person> findPerson(FilterType filterType, String searchKey) {
		List<Person> returnList = searchInCache(filterType, searchKey, Person.class);
		
		searchInPerson(filterType, searchKey, Person.class);
		
		return returnList;
	}
	
	public List<Student> findStudent(FilterType filterType, String searchKey) {
		List<Student> returnList = searchInCache(filterType, searchKey, Student.class);
		
		searchInPerson(filterType, searchKey, Student.class);
		
		return returnList;
	}
	
	public List<Instructor> findInstructor(FilterType filterType, String searchKey) {
		List<Instructor> returnList = searchInCache(filterType, searchKey, Instructor.class);
		
		searchInPerson(filterType, searchKey, Instructor.class);
		
		return returnList;
	}
	
	public List<Advisor> findAdvisor(FilterType filterType, String searchKey) {
		List<Advisor> returnList = searchInCache(filterType, searchKey, Advisor.class);
		
		searchInPerson(filterType, searchKey, Advisor.class);
		
		return returnList;
	}
	
}
