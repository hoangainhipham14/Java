package coding.mentor.be5;

public class Mentor {
	private int ID;
	private String name;
    private String email;
    
	public Mentor(int ID, String name, String email, String className) {
		super();
		this.ID = ID;
		this.name = name;
		this.email = email;
	}
    
	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
