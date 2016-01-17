package MusicFestival;

public class Vocal extends Musician {
	
	private String sings;
	
	// constructor
	public Vocal(String name) {
		super(name);
		this.setSings(" is Singing.");
	}
	
	
	// methods
	public void isPlaying() {
		System.out.println(this.getName() + sings);
	}
	
	
	// getters and setters
	public String getSings() {
		return sings;
	}

	public void setSings(String sings) {
		this.sings = sings;
	}
}
