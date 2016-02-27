package hospital;

public class NoPatientsWaitingException extends Exception {

	public NoPatientsWaitingException() {}
	
	public NoPatientsWaitingException(String message) {
		super(message);
	}
	
}
