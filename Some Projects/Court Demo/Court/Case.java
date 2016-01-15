package Court;

public abstract class Case {
	
	private Judge caseJudge;
	JudicialAssessor[] judicialAssessors;
	Defendant defendant;
	Witnes[] witneses;
	
	// constructor
	Case(Judge caseJudge, int judicialAssessors, Defendant defendant, int witnesses) {
		setCaseJudge(caseJudge);
		this.judicialAssessors = new JudicialAssessor[judicialAssessors];
		setDefendant(defendant);
		this.witneses = new Witnes[witnesses];
	}
	
	// methods
	void conductCase() {
		for (int i = 0; i < judicialAssessors.length; i++) {
			if (judicialAssessors[i] != null) {
				judicialAssessors[i].setNumberOfCasesWorked(judicialAssessors[i].getNumberOfCasesWorked() + 1);
			}
		}
		
		for (int i = 0; i < defendant.lawyerList.length; i++) {
			if (defendant.lawyerList[i] != null) {
				defendant.lawyerList[i].setNumberOfCasesWorked(defendant.lawyerList[i].getNumberOfCasesWorked() + 1);
			}
		}
		
		caseJudge.setNumberOfCasesWorked(caseJudge.getNumberOfCasesWorked() + 1);
	}
	
	
	// getters and setters
	private Judge getCaseJudge() {
		return caseJudge;
	}
	
	private void setCaseJudge(Judge caseJudge) {
		this.caseJudge = caseJudge;
	}
	
	private JudicialAssessor[] getJudicialAssessors() {
		return judicialAssessors;
	}
	
	private void setJudicialAssessors(JudicialAssessor[] judicialAssessors) {
		this.judicialAssessors = judicialAssessors;
	}
	
	private Defendant getDefendant() {
		return defendant;
	}
	
	private void setDefendant(Defendant defendant) {
		this.defendant = defendant;
	}
	
	private Witnes[] getWitneses() {
		return witneses;
	}
	
	private void setWitneses(Witnes[] witneses) {
		this.witneses = witneses;
	}

}
