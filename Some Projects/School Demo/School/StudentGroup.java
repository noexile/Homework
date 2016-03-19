package School;

public class StudentGroup {
	
	public static final int MAX_FREE_PLACES_IN_THE_GROUP = 10;
	public Teacher groupTeaher;
	private String groupName;
	private int freePlaces;
	public Student[] studentList;
	
	// Constructor
	public StudentGroup(String groupName) {
		setGroupName(groupName);
		studentList = new Student[MAX_FREE_PLACES_IN_THE_GROUP];
		setFreePlaces(MAX_FREE_PLACES_IN_THE_GROUP);
	}

	// Methods
	public void addStudentToGroup(Student student) {
		if (getFreePlaces() == 0) {
			System.out.println("No more free places in group: " + getGroupName());
			return;
		}
		
		studentList[studentList.length - this.freePlaces--] = student;
	}
	
	
	public void addTeacherToGroup(Teacher teacher) {
		if (groupTeaher != null) {
			System.out.println("Group " + getGroupName() + " has already assigned teacher: " + groupTeaher);
			return;
		}
		
		if (teacher.getFreeGroupsToTeach() == 0) {
			System.out.println("Maximum groups to teach is reached!");
			return;
		}
		
		groupTeaher = teacher;
		groupTeaher.groupsIsTeaching[groupTeaher.groupsIsTeaching.length - groupTeaher.getFreeGroupsToTeach()] = this;
		groupTeaher.setFreeGroupsToTeach(groupTeaher.getFreeGroupsToTeach() - 1);
	}
	
	public void printStudentsInGroup() {
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] != null) {
				System.out.println("- " + studentList[i].getFirstName() + " " + studentList[i].getLastName());
			}
		}
	}
	
	// getters and setters
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getFreePlaces() {
		return freePlaces;
	}

	public void setFreePlaces(int freePlaces) {
		this.freePlaces = freePlaces;
	}
	
}
