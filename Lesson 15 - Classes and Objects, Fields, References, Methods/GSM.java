
public class GSM {
	
	String model;
	String simMobileNumber; // ako e zaredena takava
	boolean hasSimCard;
	double outgoingCallsDuration;
	Call lastIncommingCall;
	Call lastOutgoingCall;
	
	void insertSimCard(String simMobileNumber) {
		
		String checker = simMobileNumber;
		boolean isDigit = true;
		
		for (int i = 0; i < checker.length(); i++) {
			if (!(Character.isDigit(checker.charAt(i)))) {
				isDigit = false;
				break;
			}
		}
		if (isDigit) {
			if(simMobileNumber.length() == 10 && simMobileNumber.startsWith("08")) {
				this.simMobileNumber = simMobileNumber;
				hasSimCard = true;
			}
		}
	}
	
	void removeSimCard() {
		hasSimCard = false;
	}
	
	void call(Call receiver, double duration) {
		if (duration > 0 && receiver.equals(simMobileNumber) /* && imat sim karti */ ) {
			
		}
	}
	
}
