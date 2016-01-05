package Notepad;

public interface INotepad {
	
	void addTextToPage(String text, int pageNumber);
	void replaceTextOfPage(String text, int pageNumber);
	void removeTextFromPage(int pageNumber);
	void printAllPages();
	
}
