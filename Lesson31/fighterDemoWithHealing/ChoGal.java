package fighterDemoWithHealing;

import java.util.Random;

public class ChoGal extends Thread {
	
	Random rand = new Random();
	
	final int maxHealth = 1000;;
	final int moralesMaxMana = 1000;
	static final int MANA_FOR_CASTING_HEAL = 50;
	int health = 500;
	volatile int moralesMana = 1000;
	
	void heal() {
		health += 50;
		moralesMana -=100;
	}
	
	synchronized void zemiDamage() throws InterruptedException {

		Thread.currentThread().sleep(200);
		health -= rand.nextInt((31 - 20) + 20);
		System.out.println("Cho Gal health: " + health);
		moralesMana++;
		notifyAll();
		if (health <= 0) {
			System.out.println("Cho Gal is Dead.");
			System.exit(0);
		}
	}
	
	synchronized void zemiHealec() throws InterruptedException {
		
		Thread.currentThread().sleep(200);
		if (health >= ((maxHealth / 100) * 90)){
			wait();
		} else {
			if (moralesMana >= moralesMaxMana) {
				wait();
			}
			if (moralesMana > MANA_FOR_CASTING_HEAL) {
				heal();
				System.out.println("Morales mana: " + moralesMana);
			}
			
			moralesMana++;
			
		}
		System.out.println("Cho Gal health: " + health);
	}
}
