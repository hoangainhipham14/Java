package coding.mentor.be5;

import java.util.ArrayList;
import java.util.Date;

public class Database {
	public static ArrayList<Course> COURSES_DB = new ArrayList<Course>();
	public static ArrayList<Mentor> MENTORS_DB = new ArrayList<Mentor>();
	public static ArrayList<User> USERS_DB = new ArrayList<User>();
	
	
	public static void initDB() {
		MENTORS_DB.add(new Mentor(1, "Dung", "dung@email.com", "0909"));
		MENTORS_DB.add(new Mentor(2, "Jayden", "jayden@email.com", "0808"));
		MENTORS_DB.add(new Mentor(3, "Toni", "toni@email.com", "0707"));
		
		ArrayList<Mentor> teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		COURSES_DB.add(new Course("BE5", new Date(), new Date(), teachingMentors, false, 3000));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		teachingMentors.add(MENTORS_DB.get(1));
		COURSES_DB.add(new Course("BE7", new Date(), new Date(), teachingMentors, false, 3000));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(2));
		COURSES_DB.add(new Course("Data1", new Date(), new Date(), teachingMentors, false, 3000));
	}
}
