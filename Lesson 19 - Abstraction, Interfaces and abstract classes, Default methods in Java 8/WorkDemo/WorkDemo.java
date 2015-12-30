package WorkDemo;

public class WorkDemo {

	public static void main(String[] args) {
		
		AllWork stroezha = new AllWork();
		
		Task task1 = new Task("lepi plochki", 3);
		Task task2 = new Task("pravi kofrazh", 24);
		Task task3 = new Task("zidai tuhli", 19);
		Task task4 = new Task("burkai beton", 22);
		Task task5 = new Task("kopai osnovi", 11);
		Task task6 = new Task("gledai chertezh", 4);
		Task task7 = new Task("pravi zamazka", 11);
		Task task8 = new Task("rezhi gredi", 18);
		Task task9 = new Task("boiadisvai", 20);
		Task task10 = new Task("prepravyai zidaria", 26);
//		Task task11 = new Task("slagai prozorci0", 12);
//		Task task12 = new Task("plashtai zaplati", 2);
		
		
		
		stroezha.addTask(task1);
		stroezha.addTask(task2);
		stroezha.addTask(task3);
		stroezha.addTask(task4);
		stroezha.addTask(task5);
		stroezha.addTask(task6);
		stroezha.addTask(task7);
		stroezha.addTask(task8);
		stroezha.addTask(task9);
		stroezha.addTask(task10);
//		stroezha.addTask(task11);
//		stroezha.addTask(task12);
		
		Employee ivan = new Employee("Bai Ivan");
		Employee hasan = new Employee("Hasan Fevzi");
		Employee kolyo = new Employee("Kolyo Zidara");
		
		ivan.setAllWork(stroezha);
		hasan.setAllWork(stroezha);
		kolyo.setAllWork(stroezha);
		
		int day = 1;
		
		// TODO checker
		do {
			System.out.println("Day: " + day++);
			ivan.startWorkingDay();
			hasan.startWorkingDay();
			kolyo.startWorkingDay();
			
			ivan.work();
			hasan.work();
			kolyo.work();
			
			System.out.println("---------------------------------");
		} while(stroezha.isAllWorkDone());
	}

}
