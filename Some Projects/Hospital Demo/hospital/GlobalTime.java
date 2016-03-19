package hospital;

public class GlobalTime extends Thread {

	static final int TIME_IN_ONE_DAY = 5000;
	
	private Hospital hospital;
	private long startTime;
	
	GlobalTime(Hospital hospital) {
		this.hospital = hospital;
	}
	
	
	@Override
	public void run() {
		startTime = System.currentTimeMillis();
		
		while(true) {
			if (System.currentTimeMillis() - startTime >= TIME_IN_ONE_DAY) {
				hospital.endOfDay(); // all personal stop work
				System.out.println("FAAA");
				break;
			}
		}
	}
	
	long getStartTime() {
		return startTime;
	}
}
