
package Market;

public class AmbulantenTargovec extends Targovec {
	
	final static int NUMBER_OF_TARGOVSKI_OBEKTI = 0;
	final static int NUMBER_OF_DOSTAVCHICI = 1;

	// constructor
	public AmbulantenTargovec(String name, String registrationAddress, int money) {
		super(name, registrationAddress, money, NUMBER_OF_TARGOVSKI_OBEKTI, NUMBER_OF_DOSTAVCHICI);
		addDostavchici();
	}
	
	// methods
	@Override
	protected void addTargovskiObekt() {
		System.out.println("Does not operate with Targovski Obekti");	
	}

	@Override
	protected void addDostavchici() {
		for (int i = 0; i < dostavchik.length; i++) {
			this.dostavchik[i] = new DostavchikNaDrebno("Bai Ivan Eood", "ul. nezabravka 1", "08:00 - 20:00");
		}		
	}	

}
