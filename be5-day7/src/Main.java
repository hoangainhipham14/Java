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
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CourseService courseService = new CourseService();
		courseService.initCourseList();
		UserService userService = new UserService();
		
		String ID;
		String password;
		String name;
		User currentUser = null; 
		int selectedCommand;
		int loginFailCount = 0;
		int selectedCourseNumber;
		Course selectedCourse;
		boolean quitProgram = false;

		do {
			while (currentUser == null && !quitProgram) {
				showLoginMenu();
				System.out.println("Please select a command");
				selectedCommand = input.nextInt();
				input.nextLine();
				switch (selectedCommand) {
				case REGISTER_USER: {
					System.out.println("-------------------------------------");
					System.out.println("Please enter new ID");
					ID = input.nextLine();
					System.out.println("Please enter new password");
					password = input.nextLine();
					System.out.println("Please enter your name");
					name = input.nextLine();
					userService.register(ID, password, name);
					break;
				}
				case LOG_IN: {
					System.out.println("-------------------------------------");
					System.out.println("Please enter ID");
					ID = input.nextLine();
					System.out.println("Please enter password");
					password = input.nextLine();
					currentUser = userService.login(ID, password, loginFailCount);
					loginFailCount += 1;
					break;
				}
				case QUIT: {
					quitProgram = true;
					break;
				}
				}
				
				if (loginFailCount > 4) {
					break;
				}
				
			};
			
		    if (quitProgram || loginFailCount > 4) {
		        break;
		    }
		    
		    courseService.showCourseList();
			System.out.println("Please select a course");
			selectedCourseNumber = input.nextInt();
			input.nextLine();
			switch (selectedCourseNumber) {
			case SHOW_YOUR_COURSES: {
				courseService.showYourCourses(currentUser);
				break;
			}
			case LOG_OUT: {
				currentUser = null;
				break;
			}
			default: 
				selectedCourse = courseService.findCourse(selectedCourseNumber);
				selectedCourse.showCourse();
				System.out.println("Please select a command");
				selectedCommand = input.nextInt();
				input.nextLine();
				switch (selectedCommand) {
				case REGISTER_COURSE: {
					selectedCourse.registerCourse(currentUser);
					break;
				}
				case VIEW_MENTORS: {
					Mentor[] mentors = selectedCourse.findCourseMentors();
					for (int index = 0; index < mentors.length; index++) {
						mentors[index].showMentor();
					}
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
	
}
