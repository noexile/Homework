package Court;

public class CivilCase extends Case {
	
	private Accuser accuser;
	
	// constructor
	protected CivilCase(Judge caseJudge, Defendant defendant, int witnesses, Citizen accuser) {
		super(caseJudge, 3, defendant, witnesses);
		setAccuser(accuser);
	}
	
	// methods
	public static CivilCase createCivilCase(LegalEntity caseJudge, Citizen defendant, int witnesses, Citizen accuser) {
		boolean checker = true;
		
		if (caseJudge instanceof Judge && defendant instanceof Defendant && accuser instanceof Citizen) {
			checker = false;
		}
		
		if (checker) {
			System.out.println("Invalid entry for Civil Case");
			return null;
		}
		
		Judge tempJudge = (Judge) caseJudge;
		Defendant tempDfendant = (Defendant) defendant;
		Accuser tempAccuser = (Accuser) accuser;
		
		return new CivilCase(tempJudge, tempDfendant, witnesses, tempAccuser);
	}
	
	public void conductCase() {
		super.conductCase();
		
		printCaseAttendants();
		
		for (int i = 0; i < this.accuser.lawyerList.length; i++) {
			if (this.accuser.lawyerList == null) {
				continue;
			}
			
			// asks 3 questions to the defendant
			for (int j = 0; j < 3; j++) {
				System.out.println(this.accuser.lawyerList[i].getName() + " asks question to " + this.defendant.getFirstName() + " " + this.defendant.getMiddleName() + " " + this.defendant.getLastName());
				System.out.print("- " + this.accuser.lawyerList[i].getName() + " is ");
				this.accuser.lawyerList[i].askQuestionToDefendant(this.defendant);
			}
			
			// asks 2 questions to each witness
			for (int k = 0; k < this.witneses.length; k++) {
				for (int m = 0; m < 2; m++) {
					System.out.println(this.accuser.lawyerList[i].getName() + " asks question to " + this.witneses[k].getFirstName() + " " + this.witneses[k].getMiddleName() + " "  + this.witneses[k].getLastName());
					System.out.print("- " + this.accuser.lawyerList[i].getName() + " is ");
					this.accuser.lawyerList[i].askQuestionToACitizen(this.witneses);
				}
			}
		}
		
		isGuilty();
		
	}
	
	protected void printCaseAttendants() {
		super.printCaseAttendants();
		
		System.out.println("Accuser: " + getAccuser().getFirstName() + " " + getAccuser().getMiddleName() + " " + getAccuser().getLastName());
		
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
	private Citizen getAccuser() {
		return accuser;
	}

	private void setAccuser(Citizen accuser) {
		this.accuser = (Accuser) accuser;
	}	
	
}