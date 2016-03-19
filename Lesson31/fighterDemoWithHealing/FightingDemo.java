package fighterDemoWithHealing;

public class FightingDemo {
	
	static ChoGal choGal = new ChoGal();
	
	public static void main(String[] args) {
		
		new Morales().start();
		new Zaratul().start();
		new Raynor().start();
		
	}

	static class Morales extends Thread {
		@Override
		public void run() {
			
			while(true) {
				try {
					choGal.zemiHealec();
				} catch (InterruptedException e) {
					
				}
			}
		}
	}
	
	static class Zaratul extends Thread{
		
		@Override
		public void run() {
			
			while(true) {
				try {
					choGal.zemiDamage();
				} catch (InterruptedException e) {
					
				}
			}
		}
	}
	
	static class Raynor extends Thread{
		@Override
		public void run() {
			
			while(true) {
				try {
					choGal.zemiDamage();
				} catch (InterruptedException e) {
					
				}
			}
		}
	}
}
