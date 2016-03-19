package MusicFestival;

public class Group {
	
	Musician[] musicians;
	private int freePlacesForMusicians;
	private Song[] songs;
	private int freePlacesForSongs;
	private String bandName;

	// constructor
	public Group (int musicians, int songs, String bandName) {
		this.musicians = new Musician[musicians];
		setFreePlacesForMusicians(musicians);
		this.songs = new Song[songs];
		setFreePlacesForSongs(songs);
		setBandName(bandName);
	}
	
	// methods
	public void addSong(Song song) {
		if (getFreePlacesForSongs() == 0) {
			System.out.println("The maximum limit for songs in the group is reached: " + this.songs.length);
		}
		
		for (int i = 0; i < songs.length; i++) {
			if (songs[i] != null) {
				continue;
			}
			
			this.songs[i] = song;
			setFreePlacesForSongs(getFreePlacesForSongs() - 1);
			return;
		}
	}
	
	public void addMusician(Musician musician) {
		if (getFreePlacesForMusicians() == 0) {
			System.out.println("The maximum limit for musicians in the group is reached: " + this.musicians.length);
		}
		
		for (int i = 0; i < musicians.length; i++) {
			if (musicians[i] != null) {
				continue;
			}
			
			this.musicians[i] = musician;
			setFreePlacesForMusicians(getFreePlacesForMusicians() - 1);
			return;
		}
	}
	
	public void playSongs() {
		for (int i = 0; i < musicians.length; i++) {
			if (musicians[i] == null) {
				continue;
			}
			
			if (musicians[i] instanceof Vocal) {
				((Vocal)musicians[i]).isPlaying();
			} else if (musicians[i] instanceof InstrumentPlayer) {
				((InstrumentPlayer)musicians[i]).isPlaying();
			}
			
			
		}
		
		for (int i = 0; i < songs.length; i++) {
			if (songs[i] == null) {
				continue;
			}
			
			System.out.println();
			System.out.println("Title: " + songs[i].getTitle());
			System.out.println(songs[i].getText());
			
		}
	}
	
	
	// getteds and setters
	private int getFreePlacesForMusicians() {
		return freePlacesForMusicians;
	}

	private void setFreePlacesForMusicians(int freePlacesForMusicians) {
		this.freePlacesForMusicians = freePlacesForMusicians;
	}

	private int getFreePlacesForSongs() {
		return freePlacesForSongs;
	}

	private void setFreePlacesForSongs(int freePlacesForSongs) {
		this.freePlacesForSongs = freePlacesForSongs;
	}
	
	String getBandName() {
		return bandName;
	}

	private void setBandName(String bandName) {
		this.bandName = bandName;
	}
}
