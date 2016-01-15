package Court;

public class Lawyer extends LegalEntity {

	private Lawyer(String name, int yearsOfService, int numberOfCasesWorked) {
		super(name, yearsOfService, numberOfCasesWorked, "Lawyer");
	}

	public static Lawyer createPublicProsecutor(String name, int yearsOfService, int numberOfCasesWorked) {
		if (numberOfCasesWorked < 10) {
			System.out.println("Lawyers must have at least 10 cases!");
			return null;
		}
		
		return new Lawyer(name, yearsOfService, numberOfCasesWorked);
	}

}
