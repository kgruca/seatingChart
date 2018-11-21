package seatingChart;
import java.util.Scanner;

public class Foothill {
	public static void main(String[] args) {
		
		String studentFirst, studentLast, studentSeat, answer, seatAns;
		int seatNum;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello! I will help you create a seating chart for your classroom!");
		System.out.println("Please note that seat 0 represents the seat closest to the teacher's desk!\n");
		
		for(int i = 0; i < 20; i++) {
			System.out.print("Student first name: ");
			studentFirst = input.nextLine();
			System.out.print("Student last name: ");
			studentLast = input.nextLine();
			System.out.print("Student seat number: ");
			studentSeat = input.nextLine();
			seatNum = Integer.parseInt(studentSeat);
			
			SeatingChart.addStudent(studentFirst, studentLast, seatNum);
			System.out.print("\n");
		}
		
		System.out.println("Would you like to swap the seats of any of the students? Type \'y\' or \'Y\'");
		System.out.println("if yes; alternatively type \'n\' or \'N\' if not.");
		answer = input.nextLine();
		
		do {
			System.out.println("Sure! Please enter below the student's first name and the seat number that");
			System.out.println("you'd like to move them to.");
			
			System.out.print("Student first name: ");
			studentFirst = input.nextLine();
			System.out.print("New student seat number: ");
			studentSeat = input.nextLine();
			seatNum = Integer.parseInt(studentSeat);
			
			SeatingChart.swapStudent(studentFirst, seatNum);
			
			System.out.print("\n");
			
			System.out.println("Would you like to swap the seats of any of the students? Type \'y\' or \'Y\'");
			System.out.println("if yes; alternatively type \'n\' or \'N\' if not.");
			answer = input.nextLine();
			
			System.out.print("\n");
		} while(answer == "y" || answer == "Y");
		
		SeatingChart.arrString();
		
		input.close();
	}

}

class Student
{
	// private data
	private String first;
	private String last;
	private int studentID;
	
	public Student(String first, String last, int id) {
		this.first = first;
		this.last = last;
		this.studentID = id;
	}
	
	public String toString(){
		return "Hello! Below are the student details.\n" + 
		"First name: " + first + "\n" + 
		"Last name: " + last + "\n" + 
		"Student ID: " + studentID;
	}
	
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	public int getStuID() {
		return this.studentID;
	}
	
	public void setStuID(int newVal) {
		this.studentID = newVal;
	}
}

class SeatingChart
{
	private static Student[] stuArr = new Student[20];
	
	public static void addStudent(String first, String last, int seatnum) {
			stuArr[seatnum] = new Student(first, last, seatnum);
	}
	
	public static int findStudent(String first) {
		for (int j = 0; j < stuArr.length; j++) {
			if (stuArr[j].getFirst().equals(first)) {
				return j;
			}
		}
		return -1;
	}
	
	public static void swapStudent(String first, int targetSeat) {
		int initSeat = findStudent(first);
		stuArr[initSeat].setStuID(targetSeat);
		stuArr[targetSeat].setStuID(initSeat);
		Student temp = stuArr[initSeat];
		
		stuArr[initSeat] = stuArr[targetSeat];
		stuArr[targetSeat] = temp;
	}
	
	public static void arrString() {
		for (int k = 0; k < stuArr.length; k++) {
			System.out.println(stuArr[k].getFirst() + " sits in seat " + stuArr[k].getStuID());
		}
	}
}
