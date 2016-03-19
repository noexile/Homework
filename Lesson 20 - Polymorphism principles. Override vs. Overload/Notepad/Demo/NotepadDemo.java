package Notepad.Demo;

import Notepad.SimpleNotepad;
import Notepad.SecuredNotepad;
import Notepad.ElectronicSecuredNotepad;

public class NotepadDemo {

	public static void main(String[] args) {
		
//		SimpleNotepad notepad = new SimpleNotepad();
//		notepad.addTextToPage("some text.", 2);
//		notepad.addTextToPage("\nsome more text", 1);
//		notepad.addTextToPage("\nalso here is this text.", 1);
//		notepad.addTextToPage("\nfinally we finished.\n", 1);
//		notepad.addTextToPage("mnogo po-nov text.", 3);
//		notepad.addTextToPage("\nfinally we finished.\n", 11);
//		notepad.addTextToPage("test subject on page 9", 9);
//		notepad.addTextToPage("just passing by", 8);
//		
//		notepad.replaceTextOfPage("the new and only text is here", 3);
//		notepad.removeTextFromPage(8);
		
//		ElectronicSecuredNotepad notepad = new ElectronicSecuredNotepad("pass");
//		notepad.start();
//		notepad.addTextToPage("some text.", 2);
//		notepad.addTextToPage("\nsome more text but on 1st page", 1);
//		notepad.addTextToPage("\nalso here is this text.", 1);
//		notepad.addTextToPage("\nfinally we finished.\n", 1);
//		notepad.addTextToPage("mnogo po-nov text.", 3);
//		notepad.addTextToPage("\nfinally we finished.\n", 11);
//		notepad.addTextToPage("test subject on page 9", 9);
//		notepad.stop();
//		notepad.addTextToPage("just passing by", 8);
//		
//		notepad.replaceTextOfPage("the new and only text is here", 3);
//		notepad.removeTextFromPage(8);
//		
//		System.out.println(notepad.searchWord("by"));
//		notepad.start();
//		notepad.printAllPagesWithDigits();
//		notepad.printAllPages();
		
		SecuredNotepad notepad = SecuredNotepad.createNewSecuredNotepad("pasa1As");
		notepad.addTextToPage("some text.", 2);
		notepad.addTextToPage("\nsome more text but on 1st page", 1);
		notepad.addTextToPage("\nalso here is this text.", 1);
		notepad.addTextToPage("\nfinally we finished.\n", 1);
		notepad.addTextToPage("mnogo po-nov text.", 3);
		notepad.addTextToPage("\nfinally we finished.\n", 11);
		notepad.addTextToPage("test subject on page 9", 9);
		notepad.addTextToPage("just passing by", 8);
		notepad.replaceTextOfPage("the new and only text is here", 3);
		notepad.removeTextFromPage(8);
		
		System.out.println(notepad.searchWord("by"));
		notepad.printAllPagesWithDigits();
		notepad.printAllPages();
	}

}
