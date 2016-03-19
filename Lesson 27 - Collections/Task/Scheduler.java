package Task;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {

	private Queue<Task> tasks;

	public Scheduler() {
		this.tasks = new LinkedList<Task>();
	}

	void push(Task c) {
		this.tasks.offer(c);
	}

	void main() {
		System.out.println("Start working on tasks.");
		for (Iterator<Task> it = this.tasks.iterator(); it.hasNext();) {
			((Task) it.next()).doWork();
		}
		System.out.println("gg wp !!!");
	}
}
