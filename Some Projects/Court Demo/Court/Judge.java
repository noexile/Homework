package Court;

public class Judge extends LegalEntity {
	
	private Judge(String name, int yearsOfService, int numberOfCasesWorked) {
		super(name, numberOfCasesWorked, numberOfCasesWorked, "Judge");
	}
	
	public static Judge createJudge(String name, int yearsOfService, int numberOfCasesWorked) {
		if (yearsOfService < 5) {
			System.out.println("Judges must have at least 5 years of work experiance!");
			return null;
		}
		
		return new Judge(name, yearsOfService, numberOfCasesWorked);
	}
	
}
