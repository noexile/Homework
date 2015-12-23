package WorkDemo;

public class AllWork {
	
	public static Task[] tasks;
	
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	
	AllWork() {
		setFreePlacesForTasks(10);
		setCurrentUnassignedTask(0);
		tasks = new Task[this.getFreePlacesForTasks()];
	}
	
	private void setFreePlacesForTasks(int freePlacesForTasks) {
		this.freePlacesForTasks = freePlacesForTasks;
	}
	
	private int getFreePlacesForTasks() {
		return this.freePlacesForTasks;
	}
	
	private void setCurrentUnassignedTask(int currentUnassignedTask) {
		this.currentUnassignedTask = currentUnassignedTask;
	}
	
	private int getCurrentUnassignedTask() {
		return this.currentUnassignedTask;
	}
	
	void addTask(String taskName, int taskHours) {
		if (getFreePlacesForTasks() == 0) {
			System.out.println("Maximum task limit is reached!");
			return;
		}
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] == null) {
				tasks[i] = new Task(taskName, taskHours);
				setFreePlacesForTasks(getFreePlacesForTasks() - 1);
				return;
			}
		}
				
	}
	
	Task getNextTask() {
		
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] == null) {
				continue;
			}
			if (getFreePlacesForTasks() == 0) {
				System.out.println("There are no more tasks left.");
				break;
			}	
			
			setCurrentUnassignedTask(i);
			break;
		}
		
		return tasks[getCurrentUnassignedTask()];
	}
	
	void isAllWorkDone() {
		boolean checker = true;
		for(int i = 0; i < tasks.length; i++) {
			if (tasks[i] == null) {
				continue;
			}
			if (tasks[i].getWorkingHours() <= 0) {
				checker = false;
				System.out.println("Task " + (i + 1) + " is not finished. Hours left to finish the job: " + tasks[i].getWorkingHours());
			}
		}
		
		if (checker) {
			System.out.println("All tasks are done!");
		}
	}
}
