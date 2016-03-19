package Library;

import java.time.LocalDate;
import java.util.ArrayList;

public class Magazine implements IReadable {
	
	private String name;
	private String izdatelstvo;
	private int number;
	private boolean isTaken;
	private LocalDate releaseDate;
	private ArrayList<String> takenOn;
	
	Magazine(String name, String izdatelstvo, int number, LocalDate releaseDate) {
		this.name = name;
		this.izdatelstvo = izdatelstvo;
		this.number = number;
		this.releaseDate = releaseDate;
		this.takenOn = new ArrayList<String>();
		this.isTaken = false;
	}
	
	
	// getters and setters
	String getName() {
		return name;
	}
	
	String getIzdatelstvo() {
		return izdatelstvo;
	}
	
	int getNumber() {
		return number;
	}
	
	LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	boolean getIsTaken() {
		return isTaken;
	}
	
	void setIsTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
}
