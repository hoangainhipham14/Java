package coding.mentor.be5;

import java.util.ArrayList;

public class CourseService {
	ArrayList<Course> courses = new ArrayList<Course>();
	
	public CourseService() {}
	
	public void initCourseList() {
	    Mentor Dung = new Mentor("Dung", "dung@example.com", "BE5");
	    Mentor Hai = new Mentor("Hai", "hai@example.com", "Data 7");

	    Mentor[] mentors1 = new Mentor[1];
	    mentors1[0] = Dung;
	    Course course1 = new Course("BE5", "10/10/2023", "10/10/2024", mentors1, false, 3000);
	    this.courses.add(course1);

	    Mentor[] mentors2 = new Mentor[2];
	    mentors2[0] = Dung;
	    mentors2[1] = Hai;
	    Course course2 = new Course("Data 7", "10/10/2023", "10/10/2024", mentors2, false, 3000);
	    this.courses.add(course2);
	}
	
	public void showCourseList() {
		System.out.println("-------------------------------------");
		System.out.println("0. Your course");
		System.out.println("1. Logout");
		for (int index = 2; index <= this.courses.size() + 1; index++) {
			System.out.println(index + ". " + this.courses.get(index - 2).name);
			String mentors = "Mentors: " + this.courses.get(index - 2).mentors[0].name;
			for (int j = 1; j < this.courses.get(index - 2).mentors.length; j++) {
				mentors += " - " + this.courses.get(index - 2).mentors[j].name;
			}
			System.out.println(mentors);
		}
		
	}
	
	public void showYourCourses(User currentUser) {
		int registeredCourseNo = 0;
		System.out.println("-------------------------------------");
		for (int index = 0; index < this.courses.size(); index++) {
			for (int i = 0; i < this.courses.get(index).students.size(); i++) {
				if (this.courses.get(index).students.get(i).getID().equals(currentUser.getID()) && this.courses.get(index).students.get(i).getPassword().equals(currentUser.getPassword())) {
					System.out.println(index + ". " + this.courses.get(index).name);
					String mentors = "Mentors: " + this.courses.get(index).mentors[0].name;
					for (int j = 1; j < this.courses.get(index).mentors.length; j++) {
						mentors += " - " + this.courses.get(index).mentors[j].name;
					}
					System.out.println(mentors);
					registeredCourseNo += 1;
				}
			}
		}
		
		if (registeredCourseNo == 0) {
			System.out.println("No registered course");
		}
	}
	
	public Course findCourse(int selectedCourseNumber) {
		return this.courses.get(selectedCourseNumber - 2);
	}
}
