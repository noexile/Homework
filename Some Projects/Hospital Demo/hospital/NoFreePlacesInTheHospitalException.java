package hospital;

public class NoFreePlacesInTheHospitalException extends Exception {
		
	public NoFreePlacesInTheHospitalException() {}
	
	public NoFreePlacesInTheHospitalException(String message) {
		super(message);
	}
	
}
