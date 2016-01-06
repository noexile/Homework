package Notepad;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad{
	
	private String password;
	private String enteredPassword;
	
	protected SecuredNotepad(String password) {
		super();
		setPassword(password);
	}
	
	public static SecuredNotepad createNewSecuredNotepad(String password) {
		if (isStrongPassword(password)) {
			return new SecuredNotepad(password);
		}
		
		return null;
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
	
	protected boolean checkPassword() {
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
	
	private static boolean isStrongPassword(String pass) {
		if(pass.length() < 5) {
			System.out.println("The entered password is short!");
			return false;
		}

		if(!containsSybmol(pass, '0', '9')) {
			System.out.println("The entered password is weak!");
			return false;
		}

		if(!containsSybmol(pass, 'a', 'z')) {
			System.out.println("The entered password is weak!");
			return false;
		}

		if(!containsSybmol(pass, 'A', 'Z')) {
			System.out.println("The entered password is weak!");
			return false;
		}
			
		return true;
	}
	
	private static boolean containsSybmol(String text, char start, char end) {
		for (int i = 0; i < text.length(); i++) {
			if(start <= text.charAt(i) && text.charAt(i) <= end) {
				return true;
			}
		}
		return false;
	}
	
	// getters and setters
	private String getPassword() {
		return this.password;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	protected String getEnteredPassword() {
		return enteredPassword;
	}

	protected void setEnteredPassword(String enteredPassword) {
		this.enteredPassword = enteredPassword;
	}
	
}
