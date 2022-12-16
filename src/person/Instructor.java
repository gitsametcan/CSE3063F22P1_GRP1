package person;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import Enums.InstructorType;
import IDs.InstructorID;
import lecture.LectureSession;
import lecture.Schedule;

//Kaan Camci 150119063
public class Instructor extends Person {

	protected InstructorID id;
	private Schedule schedule;
	protected Calendar dateOfEntry;
	protected InstructorType instructorType;
	private Scanner scanner;

	public String getID() {

		return id.getID();
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}

	public InstructorType getInstructorType() {
		return instructorType;
	}

	public void showLectures() {
		Schedule schedule = this.getSchedule();
		List<LectureSession> listOfLectureSessions = schedule.getListOfLectureSessions();

		for (LectureSession lectureSession : listOfLectureSessions) {
			System.out.println(lectureSession.getLecture().getName() + "." + lectureSession.getSessionID());
			System.out.println("------------");
			System.out.println("Quota: " + lectureSession.getLecture().getQuota());
			System.out.println("Number Of Students: " + lectureSession.getListOfStudents().size());
		}

		schedule.showSchedule();
	}

	public void showStudents() {
		int count = 0;
		for (LectureSession lectureSession : this.getSchedule().getListOfLectureSessions()) {
			count++;
			System.out.println(
					count + ". " + lectureSession.getLecture().getName() + "." + lectureSession.getSessionID());
		}
		System.out.print("Choose A Session: ");
		int sessionChoice = scanner.nextInt();
		LectureSession lectureSession = this.getSchedule().getListOfLectureSessions().get(sessionChoice - 1);
		for (Student student : lectureSession.getListOfStudents()) {
			System.out.println("ID: " + student.getID() + "Name: " + student.getFullName());
		}
	}

	public Instructor(String firstName, String lastName, InstructorID id, Calendar dateOfEntry,
			InstructorType InstructorType, Schedule schedule) {
		super(firstName, lastName);
		scanner = new Scanner(System.in);
		this.id = id;
		this.setSchedule(schedule);
		this.dateOfEntry = dateOfEntry;
		this.instructorType = InstructorType;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}
