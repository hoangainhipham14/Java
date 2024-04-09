package coding.mentor.be5;

public class CourseService {
	
	public void showCourseList() {
		System.out.println("-------------------------------------");
		System.out.println("0. Your course");
		System.out.println("1. Logout");
		for (int index = 2; index <= Database.COURSES_DB.size() + 1; index++) {
			System.out.println(index + ". " + Database.COURSES_DB.get(index - 2).getName());
			for (Mentor mentor: Database.COURSES_DB.get(index - 2).getMentors()) {
				System.out.println("mentor: " + mentor.getName() + " ");
			}
		}
	}
	
	public Course findCourse(int selectedCourseNumber) {
		return Database.COURSES_DB.get(selectedCourseNumber - 2);
	}
	
	public void showMentorDetails(Course course) {
		for (Mentor mentor: course.getMentors()) {
			System.out.println("Name: " + mentor.getName());
			System.out.println("Email: " + mentor.getEmail());
		}
	}
	
	public void showCourseDetails(Course course) {
		System.out.println("-------------------------------------");
		System.out.println(course.getName());
		String mentors = "Mentors: " + course.getMentors().get(0).getName();
		for (int index = 1; index < course.getMentors().size(); index++) {
			mentors += " - " + course.getMentors().get(index).getName();
		}
		System.out.println(mentors);
		System.out.println("Begin date: " + course.getBegin());
		System.out.println("End date: " + course.getEnd());
		System.out.println("Fee: " + course.getFee());
		System.out.println("1. Register");
		System.out.println("2. No");
		System.out.println("3. View mentors");
	}
	
	public void registerCourse(Course course, User student) {
		if (student.getRegisteredCourses().contains(course)) {
			System.out.println("-------------------------------------");
			System.out.println("You have registered for course: " + course.getName() + " before");
			return;
		}
		student.getRegisteredCourses().add(course);
		System.out.println("-------------------------------------");
		System.out.println("You successfully registered for course: " + course.getName());
		String mentors = "Mentors: " + course.getMentors().get(0).getName();
		for (int index = 1; index < course.getMentors().size(); index++) {
			mentors += " - " + course.getMentors().get(index).getName();
		}
		System.out.println(mentors);
		System.out.println("Begin date: " + course.getBegin());
		System.out.println("End date: " + course.getEnd());
		System.out.println("Fee: " + course.getFee());
	}
}
