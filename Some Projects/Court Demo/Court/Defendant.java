package Court;

public class Defendant extends Citizen {

	Lawyer[] lawyerList;
	private int freePlacesForLawyers;
	
	
	// constructor
	public Defendant(String firstName, String middleName, String lastName, String address, int age, int numberOfLawyers) {
		super(firstName, middleName, lastName, address, age);
		this.lawyerList = new Lawyer[numberOfLawyers];
		setFreePlacesForLawyers(numberOfLawyers);
	}
	
	
	// methods
	// TODO
	public void addLawyer(LegalEntity lawyer) {
		if (getFreePlacesForLawyers() == 0) {
			System.out.println("Maximum limit of lawyers for the defendant is reached: " + getLawyerList().length);
			return;
		}
		
		if (lawyer instanceof Lawyer) {
			for (int i = 0; i < getLawyerList().length; i++) {
				if (getLawyerList()[i] == null) {
					this.lawyerList[i] = (Lawyer) lawyer;
					setFreePlacesForLawyers(getFreePlacesForLawyers() - 1);
					return;
				}
				
			}
		}
	}
	
	
	// getters and setters
	public int getFreePlacesForLawyers() {
		return freePlacesForLawyers;
	}

	public void setFreePlacesForLawyers(int freePlacesForLawyers) {
		this.freePlacesForLawyers = freePlacesForLawyers;
	}
	
	public Lawyer[] getLawyerList() {
		return lawyerList;
	}

}
