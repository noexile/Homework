package MusicFestival;

public class Musician {
	
	private String name;
	
	// constructor
	public Musician(String name) {
		setName(name);
	}

	
	// methods
	public void isPlaying() {
		System.out.println("just playin'");
	}
		
	
	// getters and setters
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
}
