package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Hospital implements Runnable {
	
	private static final int TIME_IN_ONE_DAY = 5000;
	private Random rand = new Random();
	
	private int dayNumber = 1;
	
	private final int DEPARTMENT_NUMBER = 3;
	private final int MAX_ROOMS_PER_DEPARTMENT = 10;
	private final int MAX_BEDS_PER_ROOM = Room.MAX_BEDS_PER_ROOM;
	private final int MAX_BEDS_IN_HOSPITAL = DEPARTMENT_NUMBER * MAX_ROOMS_PER_DEPARTMENT * MAX_BEDS_PER_ROOM; // 3 departments x 10 rooms x 3 beds in each room
	private final int INCOMMING_PATIENTS_PER_DAY = 5;
	
	enum DepartmentNames { ORTOPEDIA, KARDIOLOGIA, VIRUSOLOGIA }
	private final String[] womenFirstNames = { "Ivanka" , "Tatyana", "Mariya", "Preslava", "Gergana", "Simona", "Teodora", "Desislava", "Snezhana", "Minka", "Sheherezada", "Lilyana", "Kalinka", "Ayshe", "Doroteya" };
	private final String[] womenLastNames = { "Ivanova", "Ilieva", "Draganova", "Karaivanova", "Svilenova", "Todorova", "Manoleva", "Semerdzhieva", "Lipova", "Kaylukova", "Papazova", "Siktirdosova" };
	private final String[] menFirstNames = { "Zahari", "Mihail", "Iliyan", "Hristo", "Slavin", "Nikola", "Ivan", "Sasho", "Drago", "Todor", "Manol", "Kaliman", "Kaloyan", "Goleman" };
	private final String[] menLastNames = { "Ivanov", "Petrov", "Todorov", "Zlatanov", "Milev", "Parashkevov", "Iliev", "Georgiev", "Trendafilov", "Hristov", "Michev", "Kaktusov", "Trunchov", "Ovcharov", "Kovachev" };
	
	
	private final HashMap<String, ArrayList<String>> treatmentsForDepartments; // department - diagnose
	
	private int hospitalFreePlaces;
	
	private ConcurrentLinkedQueue<Patient> waitingPatients; // list of patients that are waiting to be 
	private HashMap<String, ArrayList<Carton>> hospitalCartons; // department name - list of hospital cartons
	private HashMap<String, ArrayList<Room>> hospitalRooms; // department name - list of rooms in the department
	private ArrayList<Doctor> doctorsInTheHospital;
	private ArrayList<Nurse> nursesInTheHospital;
	private ArrayList<Thread> hospitalPersonel;
	

	// constructors
	public Hospital() {
		this.treatmentsForDepartments = new HashMap<String, ArrayList<String>>();
		this.hospitalFreePlaces = MAX_BEDS_IN_HOSPITAL;
		this.waitingPatients = new ConcurrentLinkedQueue<>();
		this.hospitalCartons = new HashMap<>();
		this.hospitalRooms = new HashMap<>();
		this.doctorsInTheHospital = new ArrayList<>();
		this.nursesInTheHospital = new ArrayList<>();
		this.hospitalPersonel = new ArrayList<>();
		
		addRoomsToHospital();
		addCartonsListToDepartments();
		generateDiagnosisForDepartments();
		generateDoctorsForTheHospital();
		generateNursesForTheHospital();
	}
	

	// methods
	@Override
	public void run() {
		startDay();	
	}


	void endOfDay() {
		for (int i = 0; i < this.hospitalPersonel.size(); i++) {
			if (this.hospitalPersonel.get(i).isAlive()) {
				this.hospitalPersonel.get(i).interrupt();
			}
		}
		this.hospitalPersonel.clear();
		makeCartonsUnchecked();	
		startDay();
	}

	private void startDay() {
		GlobalTime time = new GlobalTime(this);
		time.start();
		
		System.out.println("--------------- DAY " + dayNumber++ + " STARTS ---------------");
		
		addNewPatients(); // adds new patients in the waiting list
		hospitalizePatients(this.waitingPatients);
		personalStartWork(); // all personal start work
	}

	private void makeCartonsUnchecked() {
		for(Map.Entry<String, ArrayList<Carton>> entry : this.hospitalCartons.entrySet()) {
			for (int i = 0; i < entry.getValue().size(); i++) {
				entry.getValue().get(i).getPatient().setChecked(false);
			}
		}
	}


	// all personal start working
	public void personalStartWork() {
		for (int i = 0; i < this.doctorsInTheHospital.size(); i++) {
			this.hospitalPersonel.add(new Thread(this.doctorsInTheHospital.get(i)));
		}
		
		for (int i = 0; i < this.nursesInTheHospital.size(); i++) {
			this.hospitalPersonel.add(new Thread(this.nursesInTheHospital.get(i)));
		}
		
		for (int i = 0; i < this.hospitalPersonel.size(); i++) {
			this.hospitalPersonel.get(i).start();
		}
	}

	private void generateNursesForTheHospital() {
		Nurse nurseOne = new Nurse(this.womenFirstNames[rand.nextInt(this.womenFirstNames.length)] , this.womenLastNames[rand.nextInt(this.womenLastNames.length)], generateTelephone(), rand.nextInt(31) + 10, DepartmentNames.KARDIOLOGIA.toString().toLowerCase(), this);
		Nurse nurseTwo = new Nurse(this.womenFirstNames[rand.nextInt(this.womenFirstNames.length)] , this.womenLastNames[rand.nextInt(this.womenLastNames.length)], generateTelephone(), rand.nextInt(31) + 10, DepartmentNames.KARDIOLOGIA.toString().toLowerCase(), this);
		Nurse nurseThree = new Nurse(this.womenFirstNames[rand.nextInt(this.womenFirstNames.length)] , this.womenLastNames[rand.nextInt(this.womenLastNames.length)], generateTelephone(), rand.nextInt(31) + 10, DepartmentNames.ORTOPEDIA.toString().toLowerCase(), this);
		Nurse nurseFour = new Nurse(this.womenFirstNames[rand.nextInt(this.womenFirstNames.length)] , this.womenLastNames[rand.nextInt(this.womenLastNames.length)], generateTelephone(), rand.nextInt(31) + 10, DepartmentNames.ORTOPEDIA.toString().toLowerCase(), this);
		Nurse nurseFive = new Nurse(this.womenFirstNames[rand.nextInt(this.womenFirstNames.length)] , this.womenLastNames[rand.nextInt(this.womenLastNames.length)], generateTelephone(), rand.nextInt(31) + 10, DepartmentNames.VIRUSOLOGIA.toString().toLowerCase(), this);
		Nurse nurseSix = new Nurse(this.womenFirstNames[rand.nextInt(this.womenFirstNames.length)] , this.womenLastNames[rand.nextInt(this.womenLastNames.length)], generateTelephone(), rand.nextInt(31) + 10, DepartmentNames.VIRUSOLOGIA.toString().toLowerCase(), this);
		
		this.nursesInTheHospital.add(nurseOne);
		this.nursesInTheHospital.add(nurseTwo);
		this.nursesInTheHospital.add(nurseThree);
		this.nursesInTheHospital.add(nurseFour);
		this.nursesInTheHospital.add(nurseFive);
		this.nursesInTheHospital.add(nurseSix);	
	}

	private void generateDoctorsForTheHospital() {
		Doctor queen = new Doctor("Queen", "Lechitelkata", generateTelephone(), DepartmentNames.KARDIOLOGIA.toString().toLowerCase(), this);
		Doctor ross = new Doctor("Doug", "Ross", generateTelephone(), DepartmentNames.ORTOPEDIA.toString().toLowerCase(), this);
		Doctor xavier = new Doctor("Charles", "Xavier", generateTelephone(), DepartmentNames.VIRUSOLOGIA.toString().toLowerCase(), this);
		
		this.doctorsInTheHospital.add(queen);
		this.doctorsInTheHospital.add(ross);
		this.doctorsInTheHospital.add(xavier);
	}

	synchronized public void hospitalizePatients(ConcurrentLinkedQueue<Patient> waitingPatients) {	
		for (int i = 0; i < waitingPatients.size(); i++) {
			if (this.hospitalFreePlaces == 0) { // checks if there are free places in the hospital at all
				try {
					throw new NoFreePlacesInTheHospitalException();
				} catch (NoFreePlacesInTheHospitalException e) {
					System.out.println("No free places in the hospital. Please go home!");
					this.waitingPatients.clear();
					return;
				} 
			} 
			
			Patient patient = waitingPatients.peek();
			
			if (patient == null) { // checks if there are any patients to enter the hospital
				try {
					throw new NoPatientsWaitingException();
				} catch (NoPatientsWaitingException e) {
					System.out.println("No more patients waiting to get in the hospital. Hooray !");
					this.waitingPatients.clear();
					return;
				} 
			}
			
//			System.out.println("tuk");
			Doctor freeDoctor = findFreeDoctor(); // checks and returns a free doctor 
			TreatmentPlan treatmentPlan = freeDoctor.createTreatmentPlan(); // doctor makes treatment plan
			String department = getDepartment(treatmentPlan); // gets the department for witch the patient will be placed depending on his treatment plan
			patient.setTreatmentPlan(treatmentPlan);
			
//			System.out.println("da be da");
			Room patientRoom = checkForAvailableRoomForPatient(patient, treatmentPlan, department);

			if (patientRoom == null) { // checks if there is a valid room for the patient
				try {
					throw new NoFreePlacesInTheHospitalException();
				} catch (NoFreePlacesInTheHospitalException e) {
					System.out.println("No free places in the hospital. Please go home!");
					this.waitingPatients.clear();
					return;
				}
			}
			
			Carton patientCarton = new Carton(patient, freeDoctor, treatmentPlan, patientRoom);
			this.hospitalCartons.get(department).add(patientCarton); // adds carton to the hospital
			patientRoom.setFreePlaces(patientRoom.getFreePlaces() - 1); // removes 1 free place from the room
			this.hospitalFreePlaces -= 1; // removes 1 free place from the hospital
			patient.setPatientRoom(patientRoom); // patient takes bed in the room	
			waitingPatients.poll(); // removes the patient from the wait list
			freeDoctor.getPatients().add(patient); // adds patient to doctor list
			patient.setCarton(patientCarton);
			
//			'Пациент <firstName> <lastName> от пол <gender> e приет с диагноза <diagnoseName>. Лекуващ лекар: д-р <firstName> <lastName>. '
			String patientInfo = "Patient " + patient.getFirstName() + " " + patient.getLastName() + " with gender: " + 
					(patient.isMale()? "male" : "female") + " was accepted in the hospital with diagnosis: " + treatmentPlan.getDiagnosis() + 
					". Assigned doctor: " + freeDoctor.getFirstName() + " " + freeDoctor.getLastName();
			System.out.println(patientInfo);
		}
	}
	
	private void generateDiagnosisForDepartments() {
		
//		{ "Navehvane", "Rak", "Epilepsia", "Nastinka", "Sopoli", "Zabobol", "Rekursia" };		
		this.treatmentsForDepartments.put(DepartmentNames.KARDIOLOGIA.toString().toLowerCase(), new ArrayList<>());
		this.treatmentsForDepartments.get(DepartmentNames.KARDIOLOGIA.toString().toLowerCase()).add(TreatmentPlan.vazmozhniDiagnozi[1]);  // 1 - Rak
		this.treatmentsForDepartments.get(DepartmentNames.KARDIOLOGIA.toString().toLowerCase()).add(TreatmentPlan.vazmozhniDiagnozi[2]);  // 2 - Epilepsia
		
		this.treatmentsForDepartments.put(DepartmentNames.ORTOPEDIA.toString().toLowerCase(), new ArrayList<>());
		this.treatmentsForDepartments.get(DepartmentNames.ORTOPEDIA.toString().toLowerCase()).add(TreatmentPlan.vazmozhniDiagnozi[0]); // 0 - Navehvane
		this.treatmentsForDepartments.get(DepartmentNames.ORTOPEDIA.toString().toLowerCase()).add(TreatmentPlan.vazmozhniDiagnozi[5]); // 5 - Zabobol
		this.treatmentsForDepartments.get(DepartmentNames.ORTOPEDIA.toString().toLowerCase()).add(TreatmentPlan.vazmozhniDiagnozi[6]); // 6 - Rekursia
		
		this.treatmentsForDepartments.put(DepartmentNames.VIRUSOLOGIA.toString().toLowerCase(), new ArrayList<>());
		this.treatmentsForDepartments.get(DepartmentNames.VIRUSOLOGIA.toString().toLowerCase()).add(TreatmentPlan.vazmozhniDiagnozi[3]); // 3 - Nastinka
		this.treatmentsForDepartments.get(DepartmentNames.VIRUSOLOGIA.toString().toLowerCase()).add(TreatmentPlan.vazmozhniDiagnozi[4]); // 4 - Sopoli
	}
	
	private void addCartonsListToDepartments() {
		this.hospitalCartons.put(DepartmentNames.KARDIOLOGIA.toString().toLowerCase(), new ArrayList<Carton>());
		this.hospitalCartons.put(DepartmentNames.ORTOPEDIA.toString().toLowerCase(), new ArrayList<Carton>());
		this.hospitalCartons.put(DepartmentNames.VIRUSOLOGIA.toString().toLowerCase(), new ArrayList<Carton>());
	}

	private Room checkForAvailableRoomForPatient(Patient patient, TreatmentPlan treatmentPlan, String department) {
		boolean isMale = patient.isMale();
	
		for (Map.Entry<String, ArrayList<Room>> entryRooms : this.hospitalRooms.entrySet()) {
			if (entryRooms.getKey().equalsIgnoreCase(department)) {
				ArrayList<Room> departmentRooms = entryRooms.getValue();
				for (int i = 0; i < departmentRooms.size(); i++) {
					if (departmentRooms.get(i).getFreePlaces() == 0) {
						continue;
					}
					
					if (departmentRooms.get(i).getFreePlaces() == Room.MAX_BEDS_PER_ROOM) {
						return departmentRooms.get(i);
					}
					
					for (int j = 0; j < departmentRooms.get(i).getPatients().size(); j++) {
						if (departmentRooms.get(j).getPatients().get(j).isMale() == isMale) {
							return departmentRooms.get(i);
						}
					}
				}
			}
		}
		
		return null;
	}

	String getDepartment(TreatmentPlan treatmentPlan) {
		
		for (Map.Entry<String, ArrayList<String>> entryMap : this.treatmentsForDepartments.entrySet()) {
			for (int i = 0; i < entryMap.getValue().size(); i++) {
				if (entryMap.getValue().get(i).equalsIgnoreCase(treatmentPlan.getDiagnosis())) {
					return entryMap.getKey();
				}
			}
		}
		
		return null;
	}

	private Doctor findFreeDoctor() {
		while(true) {
			for (int i = 0; i < this.doctorsInTheHospital.size(); i++) {
				if (this.doctorsInTheHospital.get(i).getPatients().size() != Doctor.MAX_PATIENTS_PER_DOCTOR && this.doctorsInTheHospital.get(i).isFree()) {
					return this.doctorsInTheHospital.get(i);
				}
			}
		}
	}
	
	private void addNewPatients() {
		int numberOfMalePatients = rand.nextInt(INCOMMING_PATIENTS_PER_DAY) + 1;
		int numberOfFemalePatients = INCOMMING_PATIENTS_PER_DAY - numberOfMalePatients;
		
		for (int i = 0; i < numberOfMalePatients; i++) {
			this.waitingPatients.offer(new Patient(this.menFirstNames[rand.nextInt(this.menFirstNames.length)] , this.menLastNames[rand.nextInt(this.menLastNames.length)] , generateTelephone() , (int)(rand.nextInt(101) + 20) , true));
		}
		
		for (int i = 0; i < numberOfFemalePatients; i++) {
			this.waitingPatients.offer(new Patient(this.womenFirstNames[rand.nextInt(this.womenFirstNames.length)] , this.womenLastNames[rand.nextInt(this.womenLastNames.length)] , generateTelephone() , (int)(rand.nextInt(101) + 20) , false));
		}
	}
	
	private String generateTelephone() {
		StringBuilder sb = new StringBuilder("08");
		int numberLength = 7;
		
		for (int i = 0; i < numberLength; i++) {
			sb.append(rand.nextInt(10));
		}
		
		return sb.toString();
	}

	private void addRoomsToHospital() {
		this.hospitalRooms.put(DepartmentNames.KARDIOLOGIA.toString().toLowerCase(), new ArrayList<>());
		this.hospitalRooms.put(DepartmentNames.ORTOPEDIA.toString().toLowerCase(), new ArrayList<>());
		this.hospitalRooms.put(DepartmentNames.VIRUSOLOGIA.toString().toLowerCase(), new ArrayList<>());
		
		int kardiologiaRoomNumber = 100;
		int ortopediaRoomNumber = 200;
		int virusologiaRoomNumber = 300;
		
		for (int i = 0; i < MAX_ROOMS_PER_DEPARTMENT; i++) {
			this.hospitalRooms.get(DepartmentNames.KARDIOLOGIA.toString().toLowerCase()).add(new Room(kardiologiaRoomNumber++));
			this.hospitalRooms.get(DepartmentNames.ORTOPEDIA.toString().toLowerCase()).add(new Room(ortopediaRoomNumber++));
			this.hospitalRooms.get(DepartmentNames.VIRUSOLOGIA.toString().toLowerCase()).add(new Room(virusologiaRoomNumber++));
		}
		
		// print the creatin of the rooms
//		for(Map.Entry<String, ArrayList<Room>> entry : this.hospitalRooms.entrySet()) {
//			
//			System.out.println(entry.getKey());
//			for (int i = 0; i < entry.getValue().size(); i++) {
//				System.out.println("- " + entry.getValue().get(i).getNumber());
//			}
//			
//		}
	}

	// getters and setters
	int getHospitalFreePlaces() {
		return hospitalFreePlaces;
	}
	
	void setHospitalFreePlaces(int hospitalFreePlaces) {
		this.hospitalFreePlaces = hospitalFreePlaces;
	}
	
	HashMap<String, ArrayList<String>> getTreatmentsForDepartments() {
		return treatmentsForDepartments;
	}
	
	ConcurrentLinkedQueue<Patient> getWaitingPatients() {
		return waitingPatients;
	}
	
	HashMap<String, ArrayList<Carton>> getHospitalCartons() {
		return hospitalCartons;
	}
	
	HashMap<String, ArrayList<Room>> getHospitalRooms() {
		return hospitalRooms;
	}
	
}
