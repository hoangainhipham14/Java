package coding.mentor.be5;

import java.util.ArrayList;

public class UserService {
	ArrayList<User> users = new ArrayList<User>();
	
	public void register(String ID, String name, String password) {
		User user = new User(ID, name, password);
		this.users.add(user);
	}
	
	public User login(String ID, String password, int loginAttemptCount) {
		
		for (int index = 0; index < this.users.size(); index++) {
			if (this.users.get(index).getID().equals(ID) && this.users.get(index).getPassword().equals(password)) {
				return this.users.get(index);
			}
		}
		
		if (loginAttemptCount > 3) {
			System.out.println("Your account is locked");
		}
		
		return null;
	}
}
