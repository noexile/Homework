package hospital;

public class Patient extends Person {

	private int age;
	private boolean isMale;
	Doctor doctor;
	Room patientRoom;
	TreatmentPlan treatmentPlan;
	private Carton carton;
	private boolean checked;
	
	
	// constructors
	public Patient(String firstName, String lastName, String telephone , int age, boolean isMale) {
		super(firstName, lastName, telephone);
		this.age = age;
		this.isMale = isMale;
		this.checked = false;
	}
	
	
	// getters and setters
	Doctor getDoctor() {
		return doctor;
	}

	void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	int getAge() {
		return age;
	}

	boolean isMale() {
		return isMale;
	}

	Room getPatientRoom() {
		return patientRoom;
	}

	void setPatientRoom(Room patientRoom) {
		this.patientRoom = patientRoom;
	}

	TreatmentPlan getTreatmentPlan() {
		return treatmentPlan;
	}
	
	void setTreatmentPlan(TreatmentPlan treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}

	Carton getCarton() {
		return carton;
	}

	void setCarton(Carton carton) {
		this.carton = carton;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
