package School;

public class Teacher extends Person {
	
	public static final int MAX_GROUPS_TEACHER_CAN_TEACH = 5;
	private int freeGroupsToTeach;
	
	StudentGroup[] groupsIsTeaching;
	
	// Constructor
	public Teacher(String firstName, String lastName) {
		super(firstName, lastName);
		groupsIsTeaching = new StudentGroup[MAX_GROUPS_TEACHER_CAN_TEACH];
		setFreeGroupsToTeach(MAX_GROUPS_TEACHER_CAN_TEACH);
	}
	
	
	// Methods
	public void printTeacherInfo() {
		for (int i = 0; i < groupsIsTeaching.length; i++) {
			if (groupsIsTeaching[i] != null) {
				System.out.println("Teacher name: " + getFirstName() + " " + getLastName());
				System.out.println("Groups to teach: ");
				System.out.println("- " + groupsIsTeaching[i].getGroupName());
				System.out.println("Students:");
				groupsIsTeaching[i].printStudentsInGroup();
				System.out.println("-----");
			}
		}
		
	}
	
	
	// getters and setters
	public int getFreeGroupsToTeach() {
		return freeGroupsToTeach;
	}

	public void setFreeGroupsToTeach(int freeGroupsToTeach) {
		this.freeGroupsToTeach = freeGroupsToTeach;
	}
	
	
	
}
