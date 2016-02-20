package Library;

public class NotExistItemException extends Exception {
	
	private static String message = "Readable item does not exist";
	
	public NotExistItemException() {
		super(message);
	}
	
	public NotExistItemException(String message) {
		super(message);
	}
	
}
