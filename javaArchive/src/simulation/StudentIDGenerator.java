package simulation;

import person.Student;

public class StudentIDGenerator {
	
	private int departmentCode;
	private int yearCode;
	private int orderOfPlacement;
	
	public StudentIDGenerator(Student currentStudent, Student lastStudent) {
		if(currentStudent==null) {
			this.departmentCode = 150;
			this.yearCode = 118;
			this.orderOfPlacement = 1;
		}
		else if(!lastStudent.getID().substring(6).equalsIgnoreCase("100")){
			try{
	            int studentID = Integer.parseInt(lastStudent.getID());
	             this.departmentCode = studentID / 1000000;
	             this.yearCode = (studentID % 1000000 ) / 1000;
	             this.orderOfPlacement = ( studentID % 1000) +1 ;
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
		}
		else {
			if(!lastStudent.getID().substring(3,6).equalsIgnoreCase("121")) {
				try{
		            int studentID = Integer.parseInt(lastStudent.getID());
		             this.departmentCode = studentID / 1000000;
		             this.yearCode = ((studentID % 1000000 ) / 1000 ) + 1;
		             this.orderOfPlacement = 1 ;
		        }
		        catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
			}
			else {
				this.departmentCode = 0 ;
				this.yearCode = 0 ;
				this.orderOfPlacement = 0 ;
			}
		}
		currentStudent.setID(departmentCode,yearCode,orderOfPlacement);
	}

}
