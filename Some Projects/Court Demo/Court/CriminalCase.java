package Court;

public class CriminalCase extends Case {
	
	PublicProsecutor accuser;
	
	CriminalCase(Judge caseJudge, Defendant defendant, int witnesses, PublicProsecutor accuser) {
		super(caseJudge, 13, defendant, witnesses);
		setAccuser(accuser);
	}
	
	
	// getters and setters
	private PublicProsecutor getAccuser() {
		return accuser;
	}

	private void setAccuser(PublicProsecutor accuser) {
		this.accuser = accuser;
	}	
	
}
