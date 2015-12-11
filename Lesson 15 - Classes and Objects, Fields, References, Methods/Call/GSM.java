
public class GSM {
	
	double priceForAMinute = 0.49;
	
	String model;
	String simMobileNumber; // ako e zaredena takava
	boolean hasSimCard;
	double outgoingCallsDuration = 0;
	String lastIncommingCall;
	String lastOutgoingCall;
	
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
	
	void call(GSM receiver, double duration) {
		if (duration > 0 && !this.simMobileNumber.equals(receiver.simMobileNumber) && (this.hasSimCard != receiver.hasSimCard)) {
			this.lastOutgoingCall = receiver.simMobileNumber;
			receiver.lastIncommingCall = this.simMobileNumber;
			this.outgoingCallsDuration += duration;
		}
	}
	
	void getSumForCall() {
		System.out.println("The total sum of the last outgoing calls for telephone " + this.simMobileNumber + " : " + (this.outgoingCallsDuration * priceForAMinute));
	}
	
	void printInfoForTheLastOutgoingCall() {
		if (this.lastOutgoingCall == null) {
			System.out.println("There is no last incomming calls for the telephone!");
			return;
		}
		System.out.println("The last outgoing call for the telephone is made with: " + this.lastOutgoingCall);
	}
	
	void printInfoForTheLastIncomingCall() {
		if (this.lastIncommingCall == null) {
			System.out.println("There is no last incomming calls for the telephone!");
			return;
		}
		System.out.println("The last outgoing call for the telephone is made with: " + this.lastIncommingCall);
	}
	
}
