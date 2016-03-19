package Library;

public abstract class ReadableItem {
	
	private String name;
	private String author;
	private String izdatelstvo;
	private boolean isTaken;
	long takenOn;
	private Person takenFrom;
	
	ReadableItem(String name, String author, String izdatelstvo) {
		this.name = name;
		this.author = author;
		this.izdatelstvo = izdatelstvo;
		this.isTaken = false;
		this.takenOn = 0;
	}
	
	
	// getters and setters
	String getName() {
		return name;
	}
	
	String getAuthor() {
		return author;
	}
	
	String getIzdatelstvo() {
		return izdatelstvo;
	}

	boolean getIsTaken() {
		return isTaken;
	}
	
	void setIsTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	void setTakenOn(long time) {
		this.takenOn = time;
	}
	
	long getTakenOn() {
		return takenOn;
	}

	Person getTakenFrom() {
		return takenFrom;
	}

	void setTakenFrom(Person takenFrom) {
		this.takenFrom = takenFrom;
	}
	
}
