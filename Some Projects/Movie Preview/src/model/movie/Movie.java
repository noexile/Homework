package model.movie;

public class Movie {
	
	private String title;
	private String year;
	private String actors;
	private String awards;
	private String poster;
	
	public Movie(String name, String year) {
		this.title = name;
		this.year = year;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public String getYear() {
		return year;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
}
