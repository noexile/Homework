package carAssembly;

import java.util.HashMap;
import java.util.Map;

public class Demo {
	
	static final int NEEDED_TYRES = 4;
	static final int NEEDED_SEATS = 5;
	static final int NEEDED_ENGINES = 1;
	static final int NEEDED_FRAMES = 1;
	static final String TYRE = "tyre";
	static final String SEAT = "seat";
	static final String ENGINE = "engine";
	static final String FRAME = "frame";
	
	static int currentTyreNumber = 0;
	static int currentSeatNumber = 0;
	static int currentEngineNumber = 0;
	static int currentFrameNumber = 0;
	
	static HashMap<String, Integer> parts = new HashMap<String, Integer>();
	
	static {
		parts.put("tyre", 2);
		parts.put("seat", 3);
		parts.put("engine", 7);
		parts.put("frame", 5);
	}

	public static void main(String[] args) throws InterruptedException {
		
		Thread builder1 = new Builder();
		Thread builder2 = new Builder();
		Thread builder3 = new Builder();
		Thread builder4 = new Builder();
		Thread builder5 = new Builder();
		Thread builder6 = new Builder();
		builder1.start();
		builder2.start();
		builder3.start();
		builder4.start();
		builder5.start();
		builder6.start();
//		builder1.join();
//		builder2.join();
//		builder3.join();
//		builder4.join();
		
	}
	
	private static class Builder extends Thread {
		
		public void run() {
			
			for (Map.Entry<String, Integer> map : parts.entrySet()) {
				System.out.println(Thread.currentThread().getId() + " starts building.");
				while(true) {
					for (int i = 0; i < map.getValue(); i++) {
						
						try {
							Thread.currentThread().sleep(1000);
							System.out.println(Thread.currentThread().getName() + " " + "builds part: " + map.getKey() + ". Time remaining: " + (map.getValue() - i) + " hours.");
							
							
						} catch (InterruptedException e) {
	
						}
						if (map.getKey().equalsIgnoreCase(TYRE) && currentTyreNumber != NEEDED_TYRES) {
							currentTyreNumber++;
						} else if (map.getKey().equalsIgnoreCase(SEAT) && currentSeatNumber != NEEDED_SEATS) {
							currentSeatNumber++;
						} else if (map.getKey().equalsIgnoreCase(ENGINE) && currentEngineNumber != NEEDED_ENGINES) {
							currentEngineNumber++;
						} else if (map.getKey().equalsIgnoreCase(FRAME) && currentFrameNumber != NEEDED_FRAMES) {
							currentFrameNumber++;
						}
					}
					if (currentTyreNumber == NEEDED_TYRES && currentSeatNumber == NEEDED_SEATS && currentEngineNumber == NEEDED_ENGINES && currentFrameNumber == NEEDED_FRAMES) {
						break;
					}
				}
				
			}
		}
	}
}
