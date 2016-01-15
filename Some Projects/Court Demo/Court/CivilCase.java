package Court;

public class CivilCase extends Case {
	
	Citizen accuser;
	
	// constructor
	CivilCase(Judge caseJudge, Defendant defendant, int witnesses, Citizen accuser) {
		super(caseJudge, 3, defendant, witnesses);
		setAccuser(accuser);
	}
	
	
	// getters and setters
	private Citizen getAccuser() {
		return accuser;
	}

	private void setAccuser(Citizen accuser) {
		this.accuser = accuser;
	}	
	
}