package coding.mentor.be5;

import java.util.Scanner;

public class Main {
	
	static final int LOG_IN = 1;
	static final int REGISTER_USER = 2;
	static final int QUIT = 3;
	static final int SHOW_YOUR_COURSES = 0;
	static final int LOG_OUT = 1;
	static final int REGISTER_COURSE = 1;
	static final int VIEW_MENTORS = 3;
	
	// TODO: Missing try catch
	
	public static void main(String[] args) {
		Database.initDB();
		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		
		Integer selectedCommand;
		Integer selectedCourseNumber;
		int loginFailCount = 0;
		User currentUser = null; 
		Course selectedCourse;
		boolean quitProgram = false;

		Scanner input = new Scanner(System.in);
		
		do {
			while (currentUser == null && !quitProgram && loginFailCount < 4) {
				showLoginMenu();
				
				do {
					selectedCommand = selectCommand(input);
				} while (selectedCommand == null);
				
				switch (selectedCommand) {
				case REGISTER_USER: {
					registerUser(input);
					break;
				}
				case LOG_IN: {
					currentUser = loginUser(input);
					if (currentUser == null) {
						loginFailCount += 1;
					}
					break;
				}
				case QUIT: {
					quitProgram = true;
					break;
				}
				}
				
			};
			
			if (loginFailCount >= 4) {
				System.out.println("Your account is locked");
				break;
			}
			
		    if (quitProgram) {
		        break;
		    }
		    
		    courseService.showCourseList();
			do {
				selectedCourseNumber = selectCourse(input);
			} while (selectedCourseNumber == null);
			
			switch (selectedCourseNumber) {
			case SHOW_YOUR_COURSES: {
				userService.showYourCourses(currentUser);
				break;
			}
			case LOG_OUT: {
				currentUser = null;
				break;
			}
			default: 
				selectedCourse = courseService.findCourse(selectedCourseNumber);
				courseService.showCourseDetails(selectedCourse);
				
				do {
					selectedCommand = selectCommand(input);
				} while (selectedCommand == null);
				
				switch (selectedCommand) {
				case REGISTER_COURSE: {
					courseService.registerCourse(selectedCourse, currentUser);
					break;
				}
				case VIEW_MENTORS: {
					courseService.showMentorDetails(selectedCourse);
					break;
				}
				}
			}
		} while (!quitProgram);
		
		input.close();
	}
	
	public static void showLoginMenu() {
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		System.out.println("-------------------------------------");
	}
	
	public static void registerUser(Scanner input) {
		String ID;
		String password;
		String name;
		UserService userService = new UserService();
		
		System.out.println("-------------------------------------");
		System.out.println("Please enter new ID");
		ID = input.nextLine();
		System.out.println("Please enter new password");
		password = input.nextLine();
		System.out.println("Please enter your name");
		name = input.nextLine();
		userService.registerNewUser(ID, password, name);
	}
	
	public static User loginUser(Scanner input) {
		String ID;
		String password;
		User currentUser;
		UserService userService = new UserService();
		
		System.out.println("-------------------------------------");
		System.out.println("Please enter ID");
		ID = input.nextLine();
		System.out.println("Please enter password");
		password = input.nextLine();
		currentUser = userService.loginUser(ID, password);
		return currentUser;
	}
	
	public static Integer selectCommand(Scanner input) {
		Integer selectedCommand;
		try {
			System.out.println("Please select a command");
			selectedCommand = input.nextInt();
			input.nextLine();
		} catch (Exception e) {
			System.out.println("Please input a number");
			return null;
		}
		return selectedCommand;
	}
	
	public static Integer selectCourse(Scanner input) {
		Integer selectedCourseNumber;
		try {
			System.out.println("Please select a course");
			selectedCourseNumber = input.nextInt();
			input.nextLine();
		} catch (Exception e) {
			System.out.println("Please input a number");
			return null;
		}

		return selectedCourseNumber;
	}
}
