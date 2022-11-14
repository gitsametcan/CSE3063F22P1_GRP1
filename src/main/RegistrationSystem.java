package main;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import Enums.FilterType;
import Enums.LetterGrade;
import data.DataManager;
import lecture.Lecture;
import person.Student;

public class RegistrationSystem {
	
	
	
	private Scanner scanner;
	
	public RegistrationSystem() {
		scanner = new Scanner(System.in);
	}
	
	public void menu() throws FileNotFoundException {
		System.out.println("Log in as...");
		System.out.println("1-Student");
		System.out.println("2-Instructor");
		System.out.println("3-Advisor");
		
		boolean validInput = false;
		
		while (!validInput) {
			int loginType = scanner.nextInt();
			switch(loginType) {
				case 1:
					validInput = true;
					studentMenu();
					break;
				case 2:
					validInput = true;
					instructorMenu();
					break;
				case 3:
					validInput = true;
					advisorMenu();
					break;
				default:
					System.out.print("The input is not valid, please provide a valid input.");	
			}
		}
		
		
	}

	private void studentMenu() throws FileNotFoundException {
		Student currentUser;
		while (true) {
			System.out.println("Please provide your ID:");
			String providedID = scanner.nextLine();
			currentUser = DataManager.getInstance().findStudent(FilterType.ID, providedID);
			if (currentUser == null) {
				System.out.println("The user not found.");
				continue;
			}
			break;
		}
		
		boolean validInput = false;
		
		System.out.println("Please choose a menu: ");
		System.out.println("1-Transcript");
		System.out.println("2-Make Lecture Registration");
		System.out.println("3-Schedule");
		System.out.println("4-Registration Status");
		System.out.println("5-Debt");
		System.out.println("6-Sign Out");
		
		while (!validInput) {
			
			int menuChoice = scanner.nextInt();
			
			switch(menuChoice) {
			case 1:
				validInput = true;
				transcriptMenu(currentUser);
				break;
//			case 2:
//				validInput = true;
//				makeRegistrationMenu(currentUser);
//				break;
//			case 3:
//				validInput = true;
//				scheduleMenu(currentUser);
//				break;
//			case 4:
//				validInput = true;
//				registrationStatusMenu(currentUser);
//				break;
//			case 5:
//				validInput = true;
//				debtMenu(currentUser);
//				break;
//			case 6:
//				validInput = true;
//				signOut(currentUser);
//				break;
			default:
				System.out.print("The input is not valid, please provide a valid input.");	
		}
		}
		
	}
	
	private void transcriptMenu(Student currentUser) {
		for(int i=0; i<currentUser.getTranscript().getListOfSemester().size();i++) {
			if(i==0) {
				System.out.println("1st Semester");
			}
			else if(i==1) {
				System.out.println("2nd Semester");
			}
			else{
				System.out.println((i+1)+ "th Semester");
			}
			
			System.out.printf("%-12s","Lecture Code");
			System.out.printf("%-40s","Lecture Name");
			System.out.printf("%-10s","Credit");
			System.out.printf("%-15s%n","Letter Grade");
			
			HashMap<Lecture, LetterGrade> tempTakenLectures = currentUser.getTranscript().getListOfSemester().get(i).getListOfLecturesTaken();
			
			for(Lecture l : tempTakenLectures.keySet()) {
				
				System.out.printf("%-12s",l.getId());
				System.out.printf("%-40s",l.getName());
				System.out.printf("%-10s",l.getCredit());
				System.out.printf("%-15s%n",tempTakenLectures.get(l).toString());
			}
			
			System.out.printf("%-31s","Credits taken in Semester:");
			System.out.println(currentUser.getTranscript().getListOfSemester().get(i).getCreditsTaken());
			System.out.printf("%-31s","Credits completed in Semester:");
			System.out.println(currentUser.getTranscript().getListOfSemester().get(i).getCreditsCompleted());
		}
		
	}
	
	private void instructorMenu() {
		
	}
	
	private void advisorMenu() {
		
	}
}
