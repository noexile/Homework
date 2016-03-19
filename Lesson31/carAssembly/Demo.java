package carAssembly;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {
	
	static final int TIME_TO_BUILD_TIRE = 2;
	static final int TIME_TO_BUILD_SEAT = 3;
	static final int TIME_TO_BUILD_ENGINE = 7;
	static final int TIME_TO_BUILD_FRAME = 5;
	static final int TIME_TO_SLEEP = 1000;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(3);
		ArrayList<Thread> tasks = new ArrayList();
		tasks.add(new EngineBuilder());
		tasks.add(new FrameBuilder());
		tasks.add(new SeatBuilder());		
		tasks.add(new SeatBuilder());
		tasks.add(new SeatBuilder());
		tasks.add(new SeatBuilder());
		tasks.add(new SeatBuilder());
		tasks.add(new TireBuilder());
		tasks.add(new TireBuilder());
		tasks.add(new TireBuilder());
		tasks.add(new TireBuilder());
		
		long start = System.currentTimeMillis();
		ArrayList<Future> results = new ArrayList<>();
		for(Runnable r : tasks) {
			results.add(service.submit(r));
		}
		for(Future result : results) {
			result.get();
		}
		System.out.println("Car ready in " + (System.currentTimeMillis() - start));
		service.shutdown();
		
	}
	
	private static class TireBuilder extends Thread {
		@Override
		public void run() {
			for (int i = TIME_TO_BUILD_TIRE; i > 0; i--) {
				System.out.println("Tire ready in: " + i + " hours");
				try {
					Thread.currentThread().sleep(TIME_TO_SLEEP);
				} catch (InterruptedException e) {}
			}
			
		}
	}
	
	private static class SeatBuilder extends Thread {
		@Override
		synchronized public void run() {
			for (int i = TIME_TO_BUILD_SEAT; i > 0; i--) {
				System.out.println("Seat ready in: " + i + " hours");
				try {
					Thread.currentThread().sleep(TIME_TO_SLEEP);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	private static class EngineBuilder extends Thread {
		@Override
		public void run() {
			for (int i = TIME_TO_BUILD_ENGINE; i > 0; i--) {
				System.out.println("Engine ready in: " + i + " hours");
				try {
					Thread.currentThread().sleep(TIME_TO_SLEEP);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	private static class FrameBuilder extends Thread {
		@Override
		public void run() {
			for (int i = TIME_TO_BUILD_FRAME; i > 0; i--) {
				System.out.println("Frame ready in: " + i + " hours");
				try {
					Thread.currentThread().sleep(TIME_TO_SLEEP);
				} catch (InterruptedException e) {}
			}
		}
	}
}
