package Task;



public class Demo {
	public static void main(String[] args) throws InterruptedException{
		Scheduler schedule1 = new Scheduler();
		
		schedule1.push(new Task() {

			@Override
			public void doWork() {
				System.out.println("work work");
				
			}
			
		});
		
		schedule1.push(() -> {
			System.out.println("No time for slacking - must work harder !");
		});
		
		schedule1.push(() -> {
			System.out.println("Lets sing a song - it will boost our spirit !!!");
			System.out.println("*singing: yo-ho-ho, yo-ho-ho and a buttle of rum !");
			System.out.println("--- and a couple of hours later ---");
			System.out.println("100 little bugs in the code, 100 little bugs in the code, take one down, patch it around, 127 little bugs in the code...");
		});
		
		schedule1.main();
		
	}
}
