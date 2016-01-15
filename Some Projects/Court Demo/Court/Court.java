//	Всеки съд съдържа в себе си следните характеристики:
//	- Наименование;
//	- Адрес;
//	- Юридически лица (юристи);
//	- Списък с дела.

package Court;

public class Court {
	
	private String name;
	private String address;
	private LegalEntity[] legalEntityes;
	private int freePlacesForLegalEntityes;
	private Case[] cases;
	
	public Court(String name, String address, int legalEntityes) {
		setName(name);
		setAddress(address);
		this.legalEntityes = new LegalEntity[legalEntityes];
		setFreePlacesForLegalEntityes(legalEntityes);
		// TODO cases
	}
	
	public void addLegalEntityToCourt(LegalEntity person) {
		for (int i = 0; i < legalEntityes.length; i++) {
			if (getFreePlacesForLegalEntityes() == 0) {
				System.out.println("Maximum places for Legal Entityes reached: " + this.legalEntityes.length + ". Cannot add " + person.getPosition() + " " + person.getName() + " to the court.");
				return;
			}
			
			if (this.legalEntityes[i] == null) {
				this.legalEntityes[i] = person;
				System.out.println(person.getPosition() + " " + person.getName() + " is added to the court.");
				setFreePlacesForLegalEntityes(getFreePlacesForLegalEntityes() - 1);
				return;
			}
		}
	}
	
	// getters and setters
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private String getAddress() {
		return address;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	private LegalEntity[] getLegalEntityes() {
		return legalEntityes;
	}
	private void setLegalEntityes(LegalEntity[] legalEntityes) {
		this.legalEntityes = legalEntityes;
	}
	private Case[] getCases() {
		return cases;
	}
	private void setCases(Case[] cases) {
		this.cases = cases;
	}

	public int getFreePlacesForLegalEntityes() {
		return freePlacesForLegalEntityes;
	}

	public void setFreePlacesForLegalEntityes(int freePlacesForLegalEntityes) {
		this.freePlacesForLegalEntityes = freePlacesForLegalEntityes;
	}
	
}
