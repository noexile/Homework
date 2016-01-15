package Court;

public class Defendant extends Citizen {

	Lawyer[] lawyerList;
	
	public Defendant(String firstName, String middleName, String lastName, String address, int age) {
		super(firstName, middleName, lastName, address, age);
	}
	
}
