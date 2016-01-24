package Market;

public abstract class Dostavchik {
	
	private String name;
	private String address;
	private String workingTime;
	
	// constructor
	public Dostavchik(String name, String address, String workingTime) {
		setName(name);
		setAddress(address);
		setWorkingTime(workingTime);
	}
	
	// getters and setters
	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getAddress() {
		return address;
	}
	
	protected void setAddress(String address) {
		this.address = address;
	}
	
	protected String getWorkingTime() {
		return workingTime;
	}
	
	protected void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}
	
}
