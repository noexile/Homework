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
	private String getFirstName() {
		return firstName;
	}
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	private String getMiddleName() {
		return middleName;
	}
	
	private void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	private String getLastName() {
		return lastName;
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	private String getAddress() {
		return address;
	}
	
	private void setAddress(String address) {
		this.address = address;
	}
	
	private int getAge() {
		return age;
	}
	
	private void setAge(int age) {
		this.age = age;
	}
	
}
