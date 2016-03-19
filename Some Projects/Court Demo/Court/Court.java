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
	private int freePlacesForCases;
	
	
	// constructor
	public Court(String name, String address, int legalEntityes, int cases) {
		setName(name);
		setAddress(address);
		this.legalEntityes = new LegalEntity[legalEntityes];
		setFreePlacesForLegalEntityes(legalEntityes);
		this.cases = new Case[cases];
		setFreePlacesForCases(cases);
	}
	
	// methods
	public void addLegalEntityToCourt(LegalEntity person) {
		for (int i = 0; i < legalEntityes.length; i++) {
			if (getFreePlacesForLegalEntityes() == 0) {
				System.out.println("Maximum places for Legal Entityes reached: " + this.legalEntityes.length + ". Cannot add " + person.getPosition() + " " + person.getName() + " to the court.");
				return;
			}
			
			if (this.legalEntityes[i] == null) {
				this.legalEntityes[i] = person;
				
				// System.out.println(person.getPosition() + " " + person.getName() + " is added to the court.");
				setFreePlacesForLegalEntityes(getFreePlacesForLegalEntityes() - 1);
				return;
			}
		}
	}
	
	public void addCase(Case currentCase) {
		if (getFreePlacesForCases() == 0) {
			System.out.println("Court's maximum limit for cases is reached: " + cases.length);
			return;
		}
		
		for (int i = 0; i < cases.length; i++) {
			if (getCases()[i] == null) {
				this.cases[i] = currentCase;
				setFreePlacesForCases(getFreePlacesForCases() - 1);
				return;
			}
		}
	}
	
	public void conductCases() {
		for (int i = 0; i < cases.length; i++) {
			if (cases[i] == null) {
				continue;
			}
			
			if (cases[i] instanceof CivilCase) {
				System.out.println("----------------");
				System.out.println("civil case");
				((CivilCase)cases[i]).conductCase();
			} else if (cases[i] instanceof CriminalCase) {
				System.out.println("----------------");
				System.out.println("criminal case");
				((CriminalCase)cases[i]).conductCase();
			}
		}
	}
	
	public void printLegalEntityesInfo() {
		int counter = 1;
		for (int i = 0; i < getLegalEntityes().length; i++) {
			if (getLegalEntityes()[i] == null) {
				continue;
			}
			
			System.out.println(counter++ + ". " + getLegalEntityes()[i].getPosition() + " " + getLegalEntityes()[i].getName());
			System.out.println("- years of service: " + getLegalEntityes()[i].getyearOfService());
			System.out.println("- number of worked cases: " + getLegalEntityes()[i].getNumberOfCasesWorked());
			System.out.println("-----");
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
	
	public int getFreePlacesForCases() {
		return freePlacesForCases;
	}

	public void setFreePlacesForCases(int freePlacesForCases) {
		this.freePlacesForCases = freePlacesForCases;
	}

}
