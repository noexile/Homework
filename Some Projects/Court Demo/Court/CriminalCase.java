package Court;

public class CriminalCase extends Case {
	
	private PublicProsecutor accuser;
	
	// constructors
	private CriminalCase(Judge caseJudge, Defendant defendant, int witnesses, LegalEntity accuser) {
		super(caseJudge, 13, defendant, witnesses);
		setAccuser(accuser);
	}
	
	
	// methods
	public static CriminalCase createCriminalCase(LegalEntity caseJudge, Citizen defendant, int witnesses, LegalEntity accuser) {
		boolean checker = true;
		
		if (caseJudge instanceof Judge && defendant instanceof Defendant && accuser instanceof PublicProsecutor) {
			checker = false;
		}
		
		if (checker) {
			System.out.println("Invalid entry for Criminal Case");
			return null;
		}
		
		Judge tempJudge = (Judge) caseJudge;
		Defendant tempDfendant = (Defendant) defendant;
		PublicProsecutor tempAccuser = (PublicProsecutor) accuser;
		
		return new CriminalCase(tempJudge, tempDfendant, witnesses, tempAccuser);
	}
	
	public void conductCase() {
		super.conductCase();
		
		printCaseAttendants();
		
		this.accuser.setNumberOfCasesWorked(this.accuser.getNumberOfCasesWorked() + 1);
		
		// asks 5 questions to the defendant
		for (int i = 0; i < 5; i++) {
			System.out.println(this.accuser.getName() + " asks question to " + this.defendant.getFirstName() + " " + this.defendant.getMiddleName() + " " + this.defendant.getLastName());
			System.out.print("- " + this.accuser.getName() + " is ");
			this.accuser.askQuestionToDefendant(this.defendant);
		
		}
		
		// asks 5 questions to each witness
		
		for (int k = 0; k < this.witneses.length; k++) {
			for (int m = 0; m < 2; m++) {
				System.out.println(this.accuser.getName() + " asks question to " + this.witneses[k].getFirstName() + " " + this.witneses[k].getMiddleName() + " "  + this.witneses[k].getLastName());
				System.out.print("- " + this.accuser.getName() + " is ");
				this.accuser.askQuestionToACitizen(this.witneses);
			}
		}
		
		isGuilty();
		
	}
	
	protected void printCaseAttendants() {
		super.printCaseAttendants();
		
		System.out.println("Accuser: " + getAccuser().getName());
		
		System.out.println("Witnesses: ");
		for (int i = 0; i < this.witneses.length; i++) {
			if (this.witneses[i] == null) {
				continue;
			}
			
			System.out.println("- " + this.witneses[i].getFirstName() + " " + this.witneses[i].getMiddleName() + " " + this.witneses[i].getLastName());
		}
		System.out.println();
	}
	
	// getters and setters
	private PublicProsecutor getAccuser() {
		return accuser;
	}

	private void setAccuser(LegalEntity accuser) {
		this.accuser = (PublicProsecutor) accuser;
	}	
	
}
