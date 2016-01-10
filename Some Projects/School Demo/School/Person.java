package School;

public class Person {
	
	private String firstName;
	private String lastName;
	
	// Constructor
	public Person(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	
	// getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
