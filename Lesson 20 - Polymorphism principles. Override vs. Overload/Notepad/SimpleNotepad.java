package Notepad;

public class SimpleNotepad implements INotepad {
	
	Page[] page;
	private final int totalPageNumbers = 10;
	
	public SimpleNotepad() {
		page = new Page[totalPageNumbers];
	}

	@Override
	public void addTextToPage(String text, int pageNumber) {
		boolean checker = checkIfPageIsInTheNotePad(pageNumber);
		
		if (checker) {
			page[pageNumber].addText(text);		
		}
	}

	@Override
	public void replaceTextOfPage(String text, int pageNumber) {
		boolean checker = checkIfPageIsInTheNotePad(pageNumber);
		
		if (checker) {
			page[pageNumber].deleteText();
			page[pageNumber].addText(text);		
		}
		
	}

	@Override
	public void removeTextFromPage(int pageNumber) {
		boolean checker = checkIfPageIsInTheNotePad(pageNumber);
		
		if (checker) {
			page[pageNumber].deleteText();	
		}
		
	}

	@Override
	public void printAllPages() {
		for (int i = 0; i < page.length; i++) {
			if (page[i] != null) {
				page[i].showText();
			}
		}
		
	}
	
	boolean checkIfPageIsInTheNotePad(int pageNumber) {
		if (pageNumber > getTotalPageNumbers() || pageNumber < 0) {
			System.out.println("There is no such page in our notepad. The maximum page number is: " + getTotalPageNumbers());
			return false;
		}
		
		return true;
	}
	
	// getters and setters
	
	private int getTotalPageNumbers() {
		return totalPageNumbers;
	}
	
}
