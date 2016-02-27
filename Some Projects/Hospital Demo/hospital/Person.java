package hospital;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	private String telephone;
	

	public Person(String firstName, String lastName, String telephone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
	}
	
	
	String getFirstName() {
		return firstName;
	}
	
	String getLastName() {
		return lastName;
	}
	
	String getTelephone() {
		return telephone;
	}
}
