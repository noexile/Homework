package MusicFestival;

public class Song {
	
	private String title;
	private String text;

	// constructor
	public Song(String title, String text) {
		setTitle(title);
		setText(text);
	}

	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title.trim().isEmpty()) {
			System.out.println("The title cannot be empty!");
			return;
		}
		
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if (text.trim().isEmpty()) {
			System.out.println("The text cannot be empty!");
			return;
		}
		
		this.text = text;
	}

}
