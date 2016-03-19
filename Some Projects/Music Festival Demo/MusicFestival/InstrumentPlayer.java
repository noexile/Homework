package MusicFestival;

public class InstrumentPlayer extends Musician {
	
	private String instrument;
	
	// constructor
	public InstrumentPlayer(String name, String instrument) {
		super(name);
		this.setInstrument(" is playing " + instrument);
	}

	// methods
	public void isPlaying() {
		System.out.println(this.getName() + instrument);
	}
	
	// getters and setters
	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
}
