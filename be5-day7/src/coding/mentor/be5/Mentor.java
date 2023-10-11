package coding.mentor.be5;

public class Mentor {
	String name;
    String email;
    String className;
    
	public Mentor(String name, String email, String className) {
		super();
		this.name = name;
		this.email = email;
		this.className = className;
	}
	
	public void showMentor() {
		System.out.println("Name: " + this.name);
		System.out.println("Email: " + this.email);
		System.out.println("Class name: " + this.className);
	}
}
