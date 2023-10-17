package coding.mentor.be5;

public class UserService {
	
	public void registerNewUser(String ID, String name, String password) {
		if (isValidUser(ID)) {
			User user = new User(ID, name, password);
			Database.USERS_DB.add(user);
			System.out.println("Registered a new user successfully");
		} else {
			System.out.println("Failed to register a new user");
		}
	}
	
	public boolean isValidUser(String ID) {
		for (User user: Database.USERS_DB) {
			if (user.getID().equals(ID)) {
				return false;
			}
		}
		return true;
	}
	
	public User loginUser(String ID, String password) {
		
		for (int index = 0; index < Database.USERS_DB.size(); index++) {
			if (Database.USERS_DB.get(index).getID().equals(ID) && Database.USERS_DB.get(index).getPassword().equals(password)) {
				return Database.USERS_DB.get(index);
			}
		}
		
		System.out.println("Fail to login. Please enter correct name or password");
		return null;
	}
	
	public void showYourCourses(User user) {
		System.out.println("-------------------------------------");
		for (int index = 0; index < user.getRegisteredCourses().size(); index++) {
			System.out.println(index + ". " + user.getRegisteredCourses().get(index).getName());
			String mentors = "Mentors: " + user.getRegisteredCourses().get(index).getMentors().get(0).getName();
			for (int j = 1; j < user.getRegisteredCourses().get(index).getMentors().size(); j++) {
				mentors += " - " + user.getRegisteredCourses().get(index).getMentors().get(j).getName();
			}
			System.out.println(mentors);
		}
		
		if (user.getRegisteredCourses().size() == 0) {
			System.out.println("No registered course");
		}
	}
}
