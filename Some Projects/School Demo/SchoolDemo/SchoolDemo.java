package SchoolDemo;

import School.School;
import School.Student;
import School.StudentGroup;
import School.Teacher;

public class SchoolDemo {

	public static void main(String[] args) {
		
		School hots = new School("Heroes of the Storm");
		
		StudentGroup tank = new StudentGroup("Proper Tanking");
		StudentGroup dps = new StudentGroup("Proper DPS-ing");
		StudentGroup support = new StudentGroup("How to not let our teammates DIE HORRIBLY!");

		hots.addGroupInSchool(tank);
		hots.addGroupInSchool(dps);
		hots.addGroupInSchool(support);
		
		Teacher chen = new Teacher("Chen", "Stormstout");
		Teacher illidan = new Teacher("Illidan", "Stormrage");
		Teacher thrall = new Teacher("Go'", "el");
		
		Student johanna = new Student("Crusader", "Johanna");
		Student muradin = new Student("Muradin", "Bronzebeard");
		Student arthas = new Student("Arthas", "Menethil");
		Student leoric = new Student("King", "Leoric");
		Student uther = new Student("Uther", "the Lightbringer");
//		Student test1 = new Student("test", "test");
//		Student test2 = new Student("test", "test");
//		Student test3 = new Student("test", "test");
//		Student test4 = new Student("test", "test");
//		Student test5 = new Student("test", "test");
//		Student test6 = new Student("test", "test");
//		Student test7 = new Student("test", "test");
		
		Student raynor = new Student("Jimmy", "Raynor");
		Student tychus = new Student("Tychus", "Findlay");
		Student kerrigan = new Student("Sarrah", "Kerrigan");
		Student butcher = new Student("The", "Butcher");
		Student jaina = new Student("Jaina", "Proudmoore");
		
		Student lili = new Student("Li", "Li");
		Student malfurion = new Student("Malfurion", "Stormrage");
		Student tyrande = new Student("Tyrande", "Whisperwind");
		Student morales = new Student("Lt.", "Morales");
		Student reghar = new Student("Reghar", "Earthfury");
		
		tank.addTeacherToGroup(chen);
		tank.addStudentToGroup(johanna);
		tank.addStudentToGroup(muradin);
		tank.addStudentToGroup(arthas);
		tank.addStudentToGroup(leoric);
		tank.addStudentToGroup(uther);
//		tank.addStudentToGroup(test1);
//		tank.addStudentToGroup(test2);
//		tank.addStudentToGroup(test3);
//		tank.addStudentToGroup(test4);
//		tank.addStudentToGroup(test5);
//		tank.addStudentToGroup(test6);
//		tank.addStudentToGroup(test7);
		
		dps.addTeacherToGroup(thrall);
		dps.addStudentToGroup(raynor);
		dps.addStudentToGroup(tychus);
		dps.addStudentToGroup(kerrigan);
		dps.addStudentToGroup(butcher);
		dps.addStudentToGroup(jaina);
		
		
		support.addTeacherToGroup(thrall);
		support.addStudentToGroup(lili);
		support.addStudentToGroup(malfurion);
		support.addStudentToGroup(tyrande);
		support.addStudentToGroup(morales);
		support.addStudentToGroup(reghar);
		
		thrall.printTeacherInfo();
		illidan.printTeacherInfo();
		chen.printTeacherInfo();
	}

}
