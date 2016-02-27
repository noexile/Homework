package hospital;

public class Carton {
	
	private Patient patient;
	private Doctor doctor;
	private TreatmentPlan treatmentPlan;
	private Room room;
	
	// constructors
	Carton(Patient patient, Doctor doctor, TreatmentPlan treatmentPlan, Room room) {
		this.patient = patient;
		this.doctor = doctor;
		this.treatmentPlan = treatmentPlan;
		this.room = room;
	}
	
	
	// getters and setters
	Patient getPatient() {
		return patient;
	}
	
	Doctor getDoctor() {
		return doctor;
	}
	
	TreatmentPlan getTreatmentPlan() {
		return treatmentPlan;
	}

	Room getRoom() {
		return room;
	}
	
}
