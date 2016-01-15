package Court;

public class Accuser extends Citizen {
	
	Lawyer[] lawyerList;
	
	public Accuser(String firstName, String middleName, String lastName, String address, int age) {
		super(firstName, middleName, lastName, address, age);
	}

}
