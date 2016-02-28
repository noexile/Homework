package hospital;

import java.util.ArrayList;

public class Doctor extends Person implements Runnable {	
	
	final static int MAX_PATIENTS_PER_DOCTOR = 5;
	private final int TIME_FOR_VISITING_PATIENT = 1000;
	private String specialization;
	ArrayList<Patient> patients;
	private boolean isFree;
	Hospital hospital;
	
	
	// constructors
	public Doctor(String firstName, String lastName, String telephone, String specialization, Hospital hospital) {
		super(firstName, lastName, telephone);
		this.specialization = specialization;
		this.patients = new ArrayList<>();
		this.isFree = true;
		this.hospital = hospital;
	}
	
	
	// methods
	@Override
	public void run() {
		System.out.println("doctor " + Thread.currentThread().getName());
		makeVisitation();
	}
	
	TreatmentPlan createTreatmentPlan() {
		return new TreatmentPlan();
	}
	
	private void makeVisitation() {		
		for (int i = 0; i < this.patients.size(); i++) {
			if (this.patients.get(i).getTreatmentPlan().getDaysForTreatment() == 0) {
				dischargePatient(this.patients.get(i));
				
			}
			
			String printPatient = "Doctor " + getFirstName() + " " + getLastName() + " visited patient " + this.patients.get(i).getFirstName() + 
					this.patients.get(i).getLastName() + " in room " + this.patients.get(i).getCarton().getRoom().getNumber() + " from department " + 
					this.specialization;					
			System.out.println(printPatient);
			
			this.patients.get(i).getTreatmentPlan().setDaysForTreatment(this.patients.get(i).getTreatmentPlan().getDaysForTreatment() - 1); // visits the patient and removes 1 day for stay		
			
			try {
				this.isFree = false;
				Thread.currentThread().sleep(TIME_FOR_VISITING_PATIENT); // doctor visits patient for 1 hour
				this.isFree = true;
			} catch (InterruptedException e) {
				this.isFree = true;
			}
		}
	}
	
	private void dischargePatient(Patient patient) {
			System.out.println("Patient" + patient.getFirstName() + " " + patient.getLastName() + " sex: " + (patient.isMale()? "male" : "female") + " with diagnosis " + patient.getTreatmentPlan().getDiagnosis() + " was discharged by dr. " + this.getFirstName() + " " + this.getLastName());
			patient.getPatientRoom().setFreePlaces(patient.getPatientRoom().getFreePlaces() + 1); // set the room's free places + 1
			patient.getPatientRoom().patients.remove(patient); // remove the patient from the room
			this.patients.remove(patient); // removes patient from the doctor's list
			this.hospital.setHospitalFreePlaces(this.hospital.getHospitalFreePlaces() + 1); // adds 1 free place from the hospital
			String department = hospital.getDepartment(patient.getTreatmentPlan());
			Carton patientCarton = patient.getCarton();
			this.hospital.getHospitalCartons().get(department).remove(patientCarton); // removes patient carton
	}
	
	//getters and setters
	String getSpecialization() {
		return specialization;
	}

	ArrayList<Patient> getPatients() {
		return patients;
	}

	boolean isFree() {
		return isFree;
	}

	void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
}
