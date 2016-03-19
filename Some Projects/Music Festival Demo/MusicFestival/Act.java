package MusicFestival;

public class Act {
	
	Group groupName;
	private String timeOnStage;
	private String timeOffStage;
	
	// constrictor
	public Act(Group groupName, String timeOnStage, String timeOffStage) {
		this.groupName = groupName;
		setTimeOnStage(timeOnStage);
		setTimeOffStage(timeOffStage);
	}
	
	// methods
	public void startAct() {
		System.out.println(groupName.getBandName() + " is getting on the stage.");
		System.out.println("Starting time: " + getTimeOnStage());
		System.out.println("Finishing time: " + getTimeOffStage());
		
		groupName.playSongs();	
		System.out.println();
	}
	
	
	//getters and setters
	public String getTimeOnStage() {
		return timeOnStage;
	}
	
	public void setTimeOnStage(String timeOnStage) {
		this.timeOnStage = timeOnStage;
	}
	
	public String getTimeOffStage() {
		return timeOffStage;
	}
	
	public void setTimeOffStage(String timeOffStage) {
		this.timeOffStage = timeOffStage;
	}
	
	
}
