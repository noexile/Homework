package Notepad;

public class Page {
	private String title;
	private String text;
	
	
	void addText(String newText) {
		this.text += newText;
	}
	
	void deleteText() {
		this.text = "";
	}
	
	String showText() {
		StringBuilder text = new StringBuilder();
		text.append(getTitle()).append("/n").append(getText());
		
		return text.toString();
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
