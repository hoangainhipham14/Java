package coding.mentor.be5;

import java.util.ArrayList;

public class User {
	private String ID;
	private String password;
	private String name;
	private ArrayList<Course> registeredCourses;
	
	public User(String ID, String password, String name) {
		this.ID = ID;
		this.password = password;
		this.name = name;
		this.registeredCourses = new ArrayList<Course>();
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		this.ID = iD;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ArrayList<Course> getRegisteredCourses() {
		return registeredCourses;
	}

	public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
