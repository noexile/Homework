package Court;

public class PublicProsecutor extends LegalEntity {

	private PublicProsecutor(String name, int yearsOfService, int numberOfCasesWorked) {
		super(name, yearsOfService, numberOfCasesWorked, "Public Prosecutor");
	}

	public static PublicProsecutor createPublicProsecutor(String name, int yearsOfService, int numberOfCasesWorked) {
		if (yearsOfService < 10) {
			System.out.println("Public Prosecutors must have at least 10 years of work experiance!");
			return null;
		}
		
		return new PublicProsecutor(name, yearsOfService, numberOfCasesWorked);
	}

}
