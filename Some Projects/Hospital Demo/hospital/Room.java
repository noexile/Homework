package hospital;

import java.util.ArrayList;

public class Room {
	

	public static final int MAX_BEDS_PER_ROOM = 3;
	private final int ROOM_NUMBER;
	private int freePlaces;
	ArrayList<Patient> patients;
	
	// constructor
	Room(int roomNumber) {
		this.freePlaces = MAX_BEDS_PER_ROOM;
		this.ROOM_NUMBER = roomNumber;
		this.patients = new ArrayList<>();
	}
	
	
	// getters and setters
	int getFreePlaces() {
		return freePlaces;
	}
	
	void setFreePlaces(int freePlaces) {
		this.freePlaces = freePlaces;
	}
	
	int getNumber() {
		return ROOM_NUMBER;
	}
	
	ArrayList<Patient> getPatients() {
		return patients;
	}
	
}
