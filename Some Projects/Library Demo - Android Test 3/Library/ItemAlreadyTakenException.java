package Library;

public class ItemAlreadyTakenException extends Exception {
	
	private static String message = " is already taken";
	
	public ItemAlreadyTakenException() {
		super(message);
	}
	
	public ItemAlreadyTakenException(String message) {
		super(message);
	}
	
}
