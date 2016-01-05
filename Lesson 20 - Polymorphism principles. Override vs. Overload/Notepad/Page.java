package Notepad;

public class Page {
	private String title;
	private String text;
	
	Page(String title, String text) {
		setTitle(title);
		setText(text);
	}
	
	void addText(String newText) {
		setText(getText() + newText);
	}
	
	void deleteText() {
		this.text = "";
	}
	
	String showText() {
		StringBuilder text = new StringBuilder();
		text.append(getTitle()).append("/n").append(getText());
		
		return text.toString();
	}
	
	boolean searchWord(String word) {
		if (getText().contains(word)) {
			return true;
		}
		
		return false;
	}
	
	boolean containsDigits() {
		if(getText().matches(".*\\d.*")) {
			return true;
		}
		
		return false;
	}
	
	// getters and setters
	
	private String getTitle() {
		return this.title;
	}
	
	private void setTitle(String title) {
		this.title = title;
	}
	
	private String getText() {
		return this.text;
	}
	
	private void setText(String text) {
		this.text = text;
	}
	
}
