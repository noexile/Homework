package Court;

import java.util.Random;

public abstract class Case {
	
	private Judge caseJudge;
	JudicialAssessor[] judicialAssessors;
	private int freePlacesForJudicialAssessors;
	Defendant defendant;
	private int freePlacesForWitneses;
	Witnes[] witneses;
	
	// constructor
	protected Case(LegalEntity caseJudge, int judicialAssessors, Defendant defendant, int witnesses) {
		setCaseJudge(caseJudge);
		this.judicialAssessors = new JudicialAssessor[judicialAssessors];
		setFreePlacesForJudicialAssessors(judicialAssessors);
		setDefendant(defendant);
		this.witneses = new Witnes[witnesses];
		setFreePlacesForWitneses(witnesses);
	}
	
	// methods
	public void conductCase() {
		this.caseJudge.setNumberOfCasesWorked(this.caseJudge.getNumberOfCasesWorked() + 1);
		
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
		
	}
	
	public void addJudicialAssessors(LegalEntity judicialAssessors) {
		if (getFreePlacesForJudicialAssessors() == 0) {
			System.out.println("The limit for Judicial Assessors is reached: " + this.judicialAssessors.length);
			return;
		}
		
		for (int i = 0; i < this.judicialAssessors.length; i++) {
			if (this.judicialAssessors[i] != null) {
				continue;
			}
			
			this.judicialAssessors[i] = (JudicialAssessor) judicialAssessors;
			setFreePlacesForJudicialAssessors(getFreePlacesForJudicialAssessors() - 1);
			return;
		}
	}
	
	public void addWitnes(Citizen witnes) {
		if (getFreePlacesForWitneses() == 0) {
			System.out.println("Maximum limit for witneses is reached: " + this.witneses.length);
			return;
		}
		
		for (int i = 0; i < this.witneses.length; i++) {
			if (this.witneses[i] != null) {
				continue;
			}
			
			this.witneses[i] = (Witnes) witnes;
			setFreePlacesForWitneses(getFreePlacesForWitneses() - 1);
			return;
		}
	}
	
	protected void printCaseAttendants() {
		System.out.println("Case Judge: " + getCaseJudge().getName());
		
		System.out.println("Judicial Assessors:");
		for (int i = 0; i < this.judicialAssessors.length; i++) {
			if (this.judicialAssessors[i] == null) {
				continue;
			}
			
			System.out.println("- " + this.judicialAssessors[i].getName());
		}
		
		System.out.println("Defendant: " + getDefendant().getFirstName() + " " + getDefendant().getMiddleName() + " " + getDefendant().getLastName());
	}
	
	protected void isGuilty() {
		Random rand = new Random();
		
		int counter = 0;
		int totalPeopleForVoting = 0;
		int temp = rand.nextInt(40 - 3) + 3;
		
		for (int i = 0; i < judicialAssessors.length; i++) {
			if (judicialAssessors[i] == null) {
				continue;
			}
			
			totalPeopleForVoting++;
			if (rand.nextBoolean()) {
				counter++;
			}
		}
		
		System.out.println();
		if (counter * 2 <= totalPeopleForVoting) {			
			System.out.println("The defendant is not Guilty!");
		} else {
			System.out.println("The defendant is Guilty!");
			System.out.println("He has to serve " + temp + " years in prison.");
		}
		System.out.println();
		
	}
	
	
	// getters and setters
	private Judge getCaseJudge() {
		return caseJudge;
	}
	
	private void setCaseJudge(LegalEntity caseJudge) {
		this.caseJudge = (Judge) caseJudge;
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

	private int getFreePlacesForWitneses() {
		return freePlacesForWitneses;
	}

	private void setFreePlacesForWitneses(int freePlacesForWitneses) {
		this.freePlacesForWitneses = freePlacesForWitneses;
	}
	
	private int getFreePlacesForJudicialAssessors() {
		return freePlacesForJudicialAssessors;
	}

	private void setFreePlacesForJudicialAssessors(int freePlacesForJudicialAssessors) {
		this.freePlacesForJudicialAssessors = freePlacesForJudicialAssessors;
	}
}
