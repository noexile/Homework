package Notepad;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad{
	
	private String password;
	private String enteredPassword;
	private boolean isLocked;
	
	public SecuredNotepad() {
		
	}
	
	
	// TODO
	// password check on all methods
	@Override
	public void addTextToPage(String text, int pageNumber) {
		
		checkPassword(inputPassword());
		
		if (isLocked) {
			System.out.println("Incorrect password.");
			return;
		}
		
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
	
	private void checkPassword(String password) {
		if (getPassword().equals(password)) {
			setLocked(false);
		}
	}
	
	private String inputPassword() {
		Scanner input = new Scanner(System.in);
		setEnteredPassword(input.nextLine());
		
		input.close();
		return getEnteredPassword();
	}
	
	// getters and setters
	private String getPassword() {
		return this.password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private boolean isLocked() {
		return this.isLocked;
	}

	private void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	private String getEnteredPassword() {
		return enteredPassword;
	}

	private void setEnteredPassword(String enteredPassword) {
		this.enteredPassword = enteredPassword;
	}
	
}
