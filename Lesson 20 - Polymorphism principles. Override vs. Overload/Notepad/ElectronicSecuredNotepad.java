package Notepad;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IЕlectronicDevice {
	
	private boolean started;
	
	public ElectronicSecuredNotepad(String password) {
		super(password);
	}

	@Override
	public void start() {
		System.out.println("The device is on.");
		setStarted(true);
	}

	@Override
	public void stop() {
		System.out.println("The device is off.");
		setStarted(false);
	}

	@Override
	public boolean isStarted() {
		return getStarted();
	}
	
	@Override
	public boolean searchWord(String word) {
		
		if (isStarted()) {
			return super.searchWord(word);
		}
		System.out.println("The electronic device is not activated!");
		return false;
	}
	
	@Override
	public void printAllPagesWithDigits() {
		if (isStarted()) {
			super.printAllPagesWithDigits();
			return;
		}
		System.out.println("The electronic device is not activated!");
	}
	
	@Override
	public void addTextToPage(String text, int pageNumber) {
		if (isStarted()) {		
			super.addTextToPage(text, pageNumber);
			return;
		}
		System.out.println("The electronic device is not activated!");	
	}

	@Override
	public void replaceTextOfPage(String text, int pageNumber) {
		if (isStarted()) {		
			super.replaceTextOfPage(text, pageNumber);
			return;
		}
		System.out.println("The electronic device is not activated!");	
	}

	@Override
	public void removeTextFromPage(int pageNumber) {
		if (isStarted()) {		
			super.removeTextFromPage(pageNumber);
			return;
		}
		System.out.println("The electronic device is not activated!");	
	}

	@Override
	public void printAllPages() {
		super.printAllPages();		
	}
	
	// getters and setters
	private boolean getStarted() {
		return this.started;
	}
	
	private void setStarted(boolean started) {
		this.started = started;
	}
	
}
