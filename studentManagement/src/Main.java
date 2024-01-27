import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;																																																																																																																																																																																																																																				
import com.student.management.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		System.out.println("welcome to my application");		
		
		
		while(true) {
			System.out.println("press 1 to add student");
			System.out.println("press 2 to delete student");
			System.out.println("press 3 to display student");
			System.out.println("press 4 to update student phone no.");
			System.out.println("press 5 to Add multiple students with batch processing");
			System.out.println("press 6 to exit");
			
//			branner sc = new branner(System.in);
//			int num = sc.nextInt();
			
//			String s = sc.nextLine();
//			System.out.println(s);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine());
			int rollNo;
			boolean ans;
			Student st;
			
			
			switch(num) {
			case 1: 
//				Add student********************************************************************
				System.out.println("Enter details of the student:- ");
				System.out.println("Enter roll no -> ");
				rollNo = Integer.parseInt(br.readLine());
				
				System.out.println("Enter name -> ");
				String name = br.readLine();
				
				System.out.println("Enter phone -> ");
				long phone = Long.parseLong(br.readLine());
				
				System.out.println("Enter city -> ");
				String city = br.readLine();
				
				st = new Student(rollNo, name, city, phone);
				System.out.println(st);
				
				ans = StudentDao.insertStudentInDB(st);
				if(ans) System.out.println("Student is added");
				else System.out.println("Something went wrong");
				
				break;
				
			case 2: 
//				Delete student********************************************************************
				System.out.println("Enter student's roll no to delete:- ");
				rollNo = Integer.parseInt(br.readLine());
				ans = StudentDao.deleteStudentFromDB(rollNo);
				if(ans) System.out.println("Student is deleted");
				else System.out.println("Something went wrong");
				
				break;
				
			case 3: 
//				Display students********************************************************************
				System.out.println("displaying students:-");
				StudentDao.showAllStudents();
				break;
				
			case 4:
//				Update student********************************************************************
				System.out.println("update student");
				System.out.println("Enter student's roll no to update:- ");
				rollNo = Integer.parseInt(br.readLine());
				
				System.out.println("Enter student's new phone no:- ");
				long newPhone = Long.parseLong(br.readLine());
				ans = StudentDao.updateStudent(rollNo, newPhone);
				if(ans) System.out.println("Phone number updated");
				else System.out.println("Something went wrong");
				
				break;
				
			case 5:
//				Add multiple student********************************************************************
				System.out.println("Add multiple students");
				Student students[] = new Student[10];
				int i = 0;
				
				while(true){
					System.out.print("Enter roll no -> ");
					int roll = Integer.parseInt(br.readLine());
					
					System.out.print("Enter name -> ");
					String n = br.readLine();
					
					System.out.print("Enter phone -> ");
					long ph = Long.parseLong(br.readLine());
					
					System.out.print("Enter city -> ");
					String ct = br.readLine();
					
					
					System.out.print("Add more students(Y/N): ");
					String s = br.readLine();
					st = new Student(roll, n, ct, ph);
//					System.out.println(st);
					students[i++] = st;
					
					if(s.toUpperCase().equals("N")) break;
				}
				
				ans = StudentDao.addMultipleStudentsWithBatchProcessing(students);
				if(ans) System.out.println("All students added successfully");
				else System.out.println("Not all students added yet");
				break;
				
			}
			if(num == 6) break;
		}
		System.out.println("Thanks for using my application");
		
	}

}

