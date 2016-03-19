package School;

public class School {
	
	public static String SCHOOL_NAME;
	public static final int MAX_GROUPS_IN_THE_SCHOOL = 3;
	public static final int MAX_FREE_TEACHER_PLACES_IN_SCHOOL = MAX_GROUPS_IN_THE_SCHOOL * 2;
	private int freeGroupPlacesInSchool;
	private int freeTeacherPlacesInSchool;
	private int freeStudentPlacesInSchool;
	Teacher[] teacherList;
	StudentGroup[] studentGroupList;
	Student[] studentList;
	
	// Constructor
	public School (String schoolName) {
		setSCHOOL_NAME(schoolName);
		setFreeGroupsInSchool(MAX_GROUPS_IN_THE_SCHOOL);
		setFreeTeacherPlacesInSchool(MAX_FREE_TEACHER_PLACES_IN_SCHOOL);
		setFreeStudentPlacesInSchool(MAX_GROUPS_IN_THE_SCHOOL * StudentGroup.MAX_FREE_PLACES_IN_THE_GROUP);
		this.teacherList = new Teacher[MAX_FREE_TEACHER_PLACES_IN_SCHOOL];
		this.studentGroupList = new StudentGroup[MAX_GROUPS_IN_THE_SCHOOL];
		this.studentList = new Student[MAX_GROUPS_IN_THE_SCHOOL * StudentGroup.MAX_FREE_PLACES_IN_THE_GROUP];
	}
	
	// Methods
	public void addGroupInSchool(StudentGroup group) {
		if (studentGroupList.length == 0) {
			System.out.println("No more free places for groups in " + getSCHOOL_NAME());
			return;
		}
		
		this.studentGroupList[this.studentGroupList.length - this.freeGroupPlacesInSchool--] = group;
	}
	
	
	// getters and setters
	private void setSCHOOL_NAME(String sCHOOL_NAME) {
		if (sCHOOL_NAME.trim().isEmpty() ) {
			SCHOOL_NAME = sCHOOL_NAME;
		}		
	}
	
	static String getSCHOOL_NAME() {
		return SCHOOL_NAME;
	}

	public int getFreeGroupsInSchool() {
		return freeGroupPlacesInSchool;
	}

	public void setFreeGroupsInSchool(int freeGroupPlacesInSchool) {
		this.freeGroupPlacesInSchool = freeGroupPlacesInSchool;
	}


	public int getFreeTeacherPlacesInSchool() {
		return freeTeacherPlacesInSchool;
	}


	public void setFreeTeacherPlacesInSchool(int freeTeacherPlacesInSchool) {
		this.freeTeacherPlacesInSchool = freeTeacherPlacesInSchool;
	}


	public int getFreeStudentPlacesInSchool() {
		return freeStudentPlacesInSchool;
	}


	public void setFreeStudentPlacesInSchool(int freeStudentPlacesInSchool) {
		this.freeStudentPlacesInSchool = freeStudentPlacesInSchool;
	}
}
