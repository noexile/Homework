package Notepad;

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
		
		SecuredNotepad notepad = new SecuredNotepad("pass");
		notepad.addTextToPage("some text.", 2);
		notepad.addTextToPage("\nsome more text", 1);
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
