package MusicFestival;

public class Festival {
	
	private Act[] musicActs;
	private int freePlacesForActs;
	
	// constructor
	public Festival(int numberOfActs) {
		this.musicActs = new Act[numberOfActs];
		setFreePlacesForActs(numberOfActs);
	}
	
	
	// methods
	public void addAct(Act act) {
		if (getFreePlacesForActs() == 0) {
			System.out.println("No more free places for acts in the Festival!!!");
			return;
		}
		
		for (int i = 0; i < musicActs.length; i++) {
			if (this.musicActs[i] != null) {
				continue;
			}
			
			this.musicActs[i] = act;
			setFreePlacesForActs(getFreePlacesForActs() - 1);
			return;
		}
	}
	
	public void startFestival() {
		for (int i = 0; i < musicActs.length; i++) {
			if (musicActs[i] == null) {
				continue;
			}
			
			musicActs[i].startAct();
		}
	}

	
	// getters and setters
	public int getFreePlacesForActs() {
		return freePlacesForActs;
	}

	public void setFreePlacesForActs(int freePlacesForActs) {
		this.freePlacesForActs = freePlacesForActs;
	}
	
	
}
