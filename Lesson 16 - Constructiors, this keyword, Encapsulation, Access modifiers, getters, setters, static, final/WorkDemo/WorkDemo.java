package WorkDemo;

public class WorkDemo {

	public static void main(String[] args) {
		
		Task task = new Task("lepi plochki", 11);

		Employee ivan = new Employee("bai Ivan");
		
		ivan.setCurrentTask(task);
		ivan.setHoursLeft(8);
		ivan.work();
		ivan.setHoursLeft(8);
		ivan.work();
		
		ivan.setHoursLeft(6);
		task.setWorkingHours(32);
		
		ivan.work();
		ivan.work();
	}

}
