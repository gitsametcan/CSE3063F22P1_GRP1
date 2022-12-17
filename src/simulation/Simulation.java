package simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.DataManager;
import logger.Logger;
import person.Student;

public class Simulation {

	private List<Student> listOfStudents;
	private StudentGenerator studentGenerator;
	
	public Simulation() {
		studentGenerator = new StudentGenerator();
		listOfStudents = new ArrayList<Student>();
	}

	private void newSemester(int semesterCount) {
		for (int studentCount = 0; studentCount < 50; studentCount++) {
			
			Student student;
			try {
				student = studentGenerator.generate((studentCount+1), semesterCount);
				listOfStudents.add(student);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void run() {
		for (int i = 0; i<8; i++) {
			newSemester(i);
		}
		Logger log = Logger.getLogger("logs");

		log.info("Do you want to save generated Students? Y/N : ");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next();
		scanner.close();
		if (answer.equalsIgnoreCase("Y")) {
			DataManager.getInstance().addStudents(listOfStudents);
			DataManager.getInstance().saveObjectAsJson();
		}
	}

	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}

}
