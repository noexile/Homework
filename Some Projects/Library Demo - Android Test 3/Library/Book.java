package Library;

import java.time.LocalDate;

public class Book extends ReadableItem implements IReadable {

	private LocalDate releaseDate;
	
	Book(String name, String author, String izdatelstvo, LocalDate releaseDate) {
		super(name, author, izdatelstvo);
		this.releaseDate = releaseDate;
	}

	
	// getters and setters
	LocalDate getReleaseDate() {
		return releaseDate;
	}

}
