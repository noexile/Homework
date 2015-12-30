package WorkDemo;

public class AllWork {

	Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassugnedTask;

	AllWork() {
		setFreePlacesForTasks(10);
		setCurrentUnassugnedTask(0);
		tasks = new Task[getFreePlacesForTasks()];
	}

	void addTask(Task task) {
		if (getFreePlacesForTasks() == 0) {
			System.out.println("Maximum task limit is reached: " + tasks.length);
			System.out.println("You cannot ");
			return;
		}

		tasks[tasks.length - getFreePlacesForTasks()] = task;
		setFreePlacesForTasks(getFreePlacesForTasks() - 1);
	}

	Task getNextTask() {
		int taskNumber = getCurrentUnassugnedTask();
		setCurrentUnassugnedTask(getCurrentUnassugnedTask() + 1);

		if ((taskNumber) >= tasks.length) {
			System.out.println("has no more tasks to work on.");
			return null;
		}

		return tasks[taskNumber];
	}
	
	boolean isAllWorkDone() {
		int counter = tasks.length;
		
		for (int i = 0; i < tasks.length - getFreePlacesForTasks(); i++) {
			if (this.tasks[i].getWorkingHours() == 0) {
				counter--;
			}
		}
		if (counter == 0) {
			return false;
		}

		return true;
	}

	// getters and setters
	public int getFreePlacesForTasks() {
		return this.freePlacesForTasks;
	}

	public void setFreePlacesForTasks(int freePlacesForTasks) {
		this.freePlacesForTasks = freePlacesForTasks;
	}

	public int getCurrentUnassugnedTask() {
		return this.currentUnassugnedTask;
	}

	public void setCurrentUnassugnedTask(int currentUnassugnedTask) {
		this.currentUnassugnedTask = currentUnassugnedTask;
	}

}
