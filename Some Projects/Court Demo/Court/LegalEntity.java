//	Всяко юридическо лице има следните характеристики
//	- Наименование;
//	- Длъжност;
//	- Стаж –брой години служба.
//	- Брой дела, в които са участвали.

package Court;

public class LegalEntity {

	private String name;
	private String position; // ??? may not be string ???
	private int yearsOfService;
	private int numberOfCasesWorked;

	// TODO
	public LegalEntity(String name, int yearsOfService, int numberOfCasesWorked, String position) {
		setName(name);
		setYearOfService(yearsOfService);
		setNumberOfCasesWorked(numberOfCasesWorked);
		setPosition(position);
	}

	// methods

	public void askQuestionToACitizen(Citizen[] citizen) {
		
		for (int i = 0; i < citizen.length; i++) {
			if (citizen[i] == null) {
				continue;
			}
			takeNote();
			return;
		}
	}
	
	public void askQuestionToDefendant(Defendant defendant) {
		takeNote();
	}

	private void takeNote() {
		System.out.println("taking note");
	}

	// getters and setters
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getPosition() {
		return position;
	}

	protected void setPosition(String position) {
		this.position = position;
	}

	protected int getyearOfService() {
		return yearsOfService;
	}

	protected void setYearOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	protected int getNumberOfCasesWorked() {
		return numberOfCasesWorked;
	}

	protected void setNumberOfCasesWorked(int numberOfCasesWorked) {
		this.numberOfCasesWorked = numberOfCasesWorked;
	}

}
