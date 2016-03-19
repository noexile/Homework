package Notepad;

public class Page {
	private String title;
	private String text;
	
	public Page(String title, String text) {
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
		return title + "\n" + text;
	}
	
	boolean searchWord(String word) {
		return getText().contains(word);
	}
	
	boolean contaisDigit() {
		for (int i = 0; i < text.length(); i++) {
			if (Character.isDigit(text.charAt(i))) {
				return true;
			}
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
