package hospital;

import java.util.ArrayList;
import java.util.Map;

public class Nurse extends Person implements Runnable {

	private int yearsOfService;
	private String department;
	private Hospital hospital;
	
	// constructors
	public Nurse(String firstName, String lastName, String telephone, int yearsOfService, String department, Hospital hospital) {
		super(firstName, lastName, telephone);
		this.yearsOfService = yearsOfService;
		this.department = department;
		this.hospital = hospital;
	}
	
	// methods
	
	@Override
	public synchronized void run() {
		giveMedicine();
	}
	
	synchronized private void giveMedicine() {
		for (Map.Entry<String, ArrayList<Carton>> entryMap : this.hospital.getHospitalCartons().entrySet()) {
			if (entryMap.getKey().equalsIgnoreCase(department)) {
				ArrayList<Carton> cartonList = entryMap.getValue();
				for (int i = 0; i < cartonList.size(); i++) {
					if (cartonList.get(i).getPatient().isChecked() == true) {
						continue;
					}
//					System.out.println("lekarstva size: " + cartonList.get(i).getPatient().getTreatmentPlan().getLekarstva().size());
					String printPatient = "Sestra " + getFirstName() + " " + getLastName() + " gave patient " + 
							cartonList.get(i).getPatient().getFirstName() + " " + cartonList.get(i).getPatient().getLastName() + " in room " + 
							cartonList.get(i).getPatient().getPatientRoom().getNumber() + " from department " + 
							entryMap.getKey() + " gave the following medicine: ";
					System.out.print(printPatient);
					for (int j = 0; j < cartonList.get(i).getPatient().getTreatmentPlan().getLekarstva().size(); j++) {
						System.out.print(cartonList.get(i).getPatient().getTreatmentPlan().getLekarstva().get(j));
						if ((j + 1) < cartonList.get(i).getPatient().getTreatmentPlan().getLekarstva().size()) {
							 System.out.print(", ");
						}
					}
					
					System.out.println();
					cartonList.get(i).getPatient().setChecked(true);
				}
			}
		}
	}
	
	// getters and setters
	int getYearsOfService() {
		return yearsOfService;
	}

	String getDepartment() {
		return department;
	}
	
}
