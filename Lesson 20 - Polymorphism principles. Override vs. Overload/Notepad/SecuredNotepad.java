package Notepad;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad{
	
	private String password;
	private String enteredPassword;
	
	SecuredNotepad(String password) {
		super();
		setPassword(password);
	}
	
	@Override
	public boolean searchWord(String word) {
		
		if (checkPassword()) {
			System.out.println("Incorrect password.");
			return false;
		}
		
		return super.searchWord(word);
	}
	
	@Override
	public void printAllPagesWithDigits() {
		if (checkPassword()) {
			System.out.println("Incorrect password.");
			return;
		}
		
		super.printAllPagesWithDigits();
	}
	
	@Override
	public void addTextToPage(String text, int pageNumber) {
		
		if (checkPassword()) {
			System.out.println("Incorrect password.");
			return;
		}
		
		if (checkIfPageIsInTheNotePad(pageNumber)) {
			super.addTextToPage(text, pageNumber);	
		}
	}

	@Override
	public void replaceTextOfPage(String text, int pageNumber) {
		
		if (checkPassword()) {
			System.out.println("Incorrect password.");
			return;
		}
		
		if (checkIfPageIsInTheNotePad(pageNumber)) {
			super.replaceTextOfPage(text, pageNumber);
		}
		
	}

	@Override
	public void removeTextFromPage(int pageNumber) {
		
		if (checkPassword()) {
			System.out.println("Incorrect password.");
			return;
		}
		
		if (checkIfPageIsInTheNotePad(pageNumber)) {
			super.removeTextFromPage(pageNumber);
		}
		
	}

	@Override
	public void printAllPages() {
		
		if (checkPassword()) {
			System.out.println("Incorrect password.");
			return;
		}
		
		for (int i = 0; i < page.length; i++) {
			if (page[i] != null) {
				System.out.println(page[i].showText());
			}
		}
		
	}
	
	private boolean checkPassword() {
		String pass = inputPassword();
		
		if (pass.equals(getPassword())) {
			return false;
		}
		return true;
	}
	
	private String inputPassword() {
		System.out.print("Enter password: ");
		Scanner input = new Scanner(System.in);
		System.out.println();
		setEnteredPassword(input.nextLine());
		
		return getEnteredPassword();
	}
	
	// getters and setters
	private String getPassword() {
		return this.password;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	private String getEnteredPassword() {
		return enteredPassword;
	}

	private void setEnteredPassword(String enteredPassword) {
		this.enteredPassword = enteredPassword;
	}
	
}
