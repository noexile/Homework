package hospital;

import java.util.Random;

public class TreatmentPlan {

	static final String[] vazmozhniDiagnozi = { "Navehvane", "Rak", "Epilepsia", "Nastinka", "Sopoli", "Zabobol", "Rekursia" };
	private final String[] listSLekarstva = { "Aspirin", "Vultaren Forte", "Tailol Hot", "Fervex", "Imodium" };
	private Carton patientCarton;
	
	private Random rand = new Random();
	
	private String diagnosis;
	private String[] lekarstva;
	private int daysForTreatment;
	

	// constructors
	public TreatmentPlan() {
		this.daysForTreatment = rand.nextInt(6 - 3) + 3;
		this.diagnosis = vazmozhniDiagnozi[rand.nextInt(3)];
		this.lekarstva = new String[rand.nextInt(3)];
		for (int i = 0; i < this.lekarstva.length; i++) {
			this.lekarstva[i] = this.listSLekarstva[rand.nextInt(this.listSLekarstva.length)];
		}
	}
	
	
	// getters and setters
	String getDiagnosis() {
		return diagnosis;
	}
	
	String[] getLekarstva() {
		return lekarstva;
	}
	
	void setDaysForTreatment(int daysForTreatment) {
		this.daysForTreatment = daysForTreatment;
	}
	
	int getDaysForTreatment() {
		return daysForTreatment;
	}

	Carton getPatientCarton() {
		return patientCarton;
	}

	void setPatientCarton(Carton patientCarton) {
		this.patientCarton = patientCarton;
	}
	
}
