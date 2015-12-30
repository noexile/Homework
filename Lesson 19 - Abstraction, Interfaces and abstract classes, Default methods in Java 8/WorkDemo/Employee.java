package WorkDemo;

public class Employee {

	final int workingHours = 8;
	private String name;
	private Task currentTask;
	private int hoursLeft;
	AllWork allWork;

	Employee(String name) {
		setName(name);
	}

	void startWorkingDay() {
		this.setHoursLeft(workingHours);
	}

	AllWork getAllWork() {
		return allWork;
	}

	void setAllWork(AllWork allWork) {
		this.allWork = allWork;
	}

	// TODO
	void work() {
		
		if (this.currentTask == null) {
			this.setCurrentTask(allWork.getNextTask());
			System.out.println(this.getName() + " starts working on task " + this.currentTask.getTaskName());
		}
		if (this.allWork.getCurrentUnassugnedTask() < allWork.tasks.length) {
			if (this.currentTask.getWorkingHours() <= this.getHoursLeft()) {
				this.setHoursLeft(getHoursLeft() - this.currentTask.getWorkingHours());
				showReport();
				this.setCurrentTask(allWork.getNextTask());
				System.out.println(this.getName() + " starts working on task " + this.currentTask.getTaskName());
				this.currentTask.setWorkingHours(this.currentTask.getWorkingHours() - this.getHoursLeft());
				this.setHoursLeft(0);
			} else {
				this.currentTask.setWorkingHours(this.currentTask.getWorkingHours() - this.getHoursLeft());
				this.setHoursLeft(0);
			}
			showReport();
		} else {
			System.out.println(this.name + " has finished work.");
		}
	}

	public void showReport() {

		if (allWork.getCurrentUnassugnedTask() > 9) {
			System.out.println(this.name + " finished work.");
			return;
		}

		System.out.println("Worker name: " + this.getName());
		System.out.println("Work order name: " + this.currentTask.getTaskName());
		System.out.println("Working hours left: " + this.getHoursLeft());
		System.out.println("Order's hours left: " + this.currentTask.getWorkingHours());
		System.out.println();
	}

	// getters and setters
	public void setName(String name) {
		if (name.trim().isEmpty()) {
			System.out.println("You cannot input empty employee name!");
			return;
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public Task getCurrentTask() {
		return this.currentTask;
	}

	public void setHoursLeft(int hoursLeft) {
		if (hoursLeft < 1) {
			return;
		}
		this.hoursLeft = hoursLeft;
	}

	public int getHoursLeft() {
		return this.hoursLeft;
	}

}
