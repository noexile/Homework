package Notepad;

public class SimpleNotepad implements INotepad {
	
	private static final int TOTAL_PAGE_NUMBERS = 10;
	Page[] page;
	
	SimpleNotepad() {
		page = new Page[TOTAL_PAGE_NUMBERS];
		for (int i = 0; i < TOTAL_PAGE_NUMBERS; i++) {
			page[i] = new Page("Page " + (i + 1), "");
		}
	}
	
	@Override
	public boolean searchWord(String word) {
		for (int i = 0; i < page.length; i++) {
			if (page[i] != null && page[i].searchWord(word)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < page.length; i++) {
			if(page[i] != null && page[i].contaisDigit()) {
				System.out.println(page[i].showText());
			}
		}
	}
	
	@Override
	public void addTextToPage(String text, int pageNumber) {
		if (checkIfPageIsInTheNotePad(pageNumber)) {
			page[pageNumber - 1].addText(text);		
		}
	}

	@Override
	public void replaceTextOfPage(String text, int pageNumber) {
		if (checkIfPageIsInTheNotePad(pageNumber)) {
			page[pageNumber - 1].deleteText();
			page[pageNumber - 1].addText(text);		
		}
		
	}

	@Override
	public void removeTextFromPage(int pageNumber) {
		if (checkIfPageIsInTheNotePad(pageNumber)) {
			page[pageNumber - 1].deleteText();	
		}
		
	}

	@Override
	public void printAllPages() {
		for (int i = 0; i < page.length; i++) {
			if (page[i] != null) {
				System.out.println(page[i].showText());
			}
		}
		
	}
	
	protected boolean checkIfPageIsInTheNotePad(int pageNumber) {
		if(pageNumber > 0 && pageNumber <= TOTAL_PAGE_NUMBERS) {
			return true;
		}
		System.out.println("Invalid page number.");
		return false;
	}
	
}
