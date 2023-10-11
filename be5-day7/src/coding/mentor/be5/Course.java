package coding.mentor.be5;

import java.util.ArrayList;

public class Course {
	String name;
	String beginDate;
	String endDate;
	double fee;
	Mentor[] mentors;
	ArrayList<User> students;
	boolean isRegistered;
	
	public Course(String name, String beginDate, String endDate, Mentor[] mentors, boolean isRegistered, double fee) {
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.mentors = mentors;
		this.isRegistered = isRegistered;
		this.fee = fee;
		this.students = new ArrayList<User>();
	}

	public void showCourse() {
		System.out.println("-------------------------------------");
		System.out.println(this.name);
		String mentors = "Mentors: " + this.mentors[0].name;
		for (int index = 1; index < this.mentors.length; index++) {
			mentors += " - " + this.mentors[index].name;
		}
		System.out.println(mentors);
		System.out.println("Begin date: " + this.beginDate);
		System.out.println("End date: " + this.endDate);
		System.out.println("Fee: " + this.fee);
		System.out.println("1. Register");
		System.out.println("2. No");
	}
	
	public void registerCourse(User student) {
		if (this.isRegistered) {
			System.out.println("-------------------------------------");
			System.out.println("You have registered for course: " + this.name + " before");
			return;
		}
		this.students.add(student);
		System.out.println("-------------------------------------");
		System.out.println("You successfully registered for course: " + this.name);
		String mentors = "Mentors: " + this.mentors[0].name;
		for (int index = 1; index < this.mentors.length; index++) {
			mentors += " - " + this.mentors[index].name;
		}
		System.out.println(mentors);
		System.out.println("Begin date: " + this.beginDate);
		System.out.println("End date: " + this.endDate);
		System.out.println("Fee: " + this.fee);
	}
	
	public Mentor[] findCourseMentors() {
		return this.mentors;
	}
}
