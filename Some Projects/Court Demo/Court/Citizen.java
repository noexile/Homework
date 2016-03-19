package Court;

public class Citizen {

	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private int age;
	
	// constructor
	public Citizen(String firstName, String middleName, String lastName, String address, int age) {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setAddress(address);
		setAge(age);
	}
	
	
	// getters and setters
	protected String getFirstName() {
		return firstName;
	}
	
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	protected String getMiddleName() {
		return middleName;
	}
	
	protected void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	protected String getLastName() {
		return lastName;
	}
	
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	protected String getAddress() {
		return address;
	}
	
	protected void setAddress(String address) {
		this.address = address;
	}
	
	protected int getAge() {
		return age;
	}
	
	protected void setAge(int age) {
		this.age = age;
	}
	
}
