package raidDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Boss extends Thread {
	
	static long start = System.currentTimeMillis();
	private Random rand = new Random();
	static final int MAX_HEALTH = 100_000_000;
	static final int AOE_SPELL_DAMAGE = 20_000;
	static final String AOE_SPELL_DAMAGE_NAME = "Smelly Fart";
	static final int SINGLE_TARGET_DAMAGE = 70_000;
	static final String SINGLE_TARGET_DAMAGE_NAME = "Ass Stomp";
	private String name;
	private int health;
	
	private ArrayList<Hero> heroesAttackingBoss;
	private ArrayList<Hero> tanks;
	
	public Boss(String name) {
		this.health = MAX_HEALTH;
		this.name = name;
		this.heroesAttackingBoss = Demo.heroes;
		this.tanks = new ArrayList<Hero>(getTanks());	
			
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(200);
				Demo.azmodan.startBattle();
			} catch (Exception e) {
				
			}
		}
	}
	
	private void startBattle() {
		int temp = rand.nextInt(15); // random boss fight pattern
		
		if (temp >= 10 && temp < 15 && Boss.start >= 2_000) {
			doAoEDamageToRaid();
			Boss.start = 0;
		} else {
			doDamageToHero();
		}
		heal();		
	}

	synchronized public void takeDamage() {
		for (int i = 0; i < tanks.size(); i++) {
			this.health -= Hero.TANK_DAMAGE;
			System.out.println(tanks.get(i).getHeroName() + " does " + Hero.TANK_DAMAGE + " to " + this.name);
			if (isBossDead()) {
				System.out.println("The boss: " + this.name + " died.");
				System.exit(0);
			}
		}
		
		for (int i = 0; i < heroesAttackingBoss.size(); i++) {
			this.health -= Hero.DPS_DAMAGE;
			System.out.println(heroesAttackingBoss.get(i).getHeroName() + " does " + Hero.DPS_DAMAGE + " to " + this.name);
			if (isBossDead()) {
				System.out.println("The boss: " + this.name + " died.");
				System.exit(0);
			}
		}
		System.out.println(this.name + " healt left: " + this.health);
	}
	
	// TODO
	synchronized public void healPerSecond() {
		// implement boss heal per second
	}
	
	synchronized public void doDamageToHero() {
		int temp;
		
		if (this.tanks.size() != 0) { // checks if there is a tank in the raid and does damage to him with priority than the others
			temp = rand.nextInt(this.tanks.size());
			this.tanks.get(temp).setHealth(this.tanks.get(temp).getHealth() - SINGLE_TARGET_DAMAGE);
			if (this.tanks.get(temp).getHealth() <= 0) {
				heroHasDiedMessage(this.tanks, temp, SINGLE_TARGET_DAMAGE_NAME); // prints dead hero info and removes him from the list
				return;
			}
			System.out.println(this.tanks.get(temp).getHeroName() + " - " + this.tanks.get(temp).getHealth() + " health");
		} else if (this.heroesAttackingBoss.size() != 0) {
			temp = rand.nextInt(this.heroesAttackingBoss.size());
			this.heroesAttackingBoss.get(temp).setHealth(this.heroesAttackingBoss.get(temp).getHealth() - SINGLE_TARGET_DAMAGE);
			if (this.heroesAttackingBoss.get(temp).getHealth() <= 0) {
				heroHasDiedMessage(this.heroesAttackingBoss, temp, SINGLE_TARGET_DAMAGE_NAME); // prints dead hero info and removes him from the list
				return;
			}
			System.out.println(this.heroesAttackingBoss.get(temp).getHeroName() + " - " + this.heroesAttackingBoss.get(temp).getHealth() + " health");
		} else {
			thePartyIsDeadMessage();
		}
	}
	
	
	synchronized public void doAoEDamageToRaid() {
		System.out.println(this.name + " is casting " + AOE_SPELL_DAMAGE_NAME);
		doDamage(this.heroesAttackingBoss);
		doDamage(this.tanks);
		
		// printing heroes health
		printRaidInfo();
	}
	
	synchronized private void doDamage(ArrayList<Hero> heroes) {
		ArrayList<Hero> healersAndDamageHealers = heroes;
		for (int i = 0; i < healersAndDamageHealers.size(); i++) {
			if (healersAndDamageHealers.get(i) == null) {
				continue;
			}
			
			healersAndDamageHealers.get(i).setHealth(healersAndDamageHealers.get(i).getHealth() - 20_000);
			if (healersAndDamageHealers.get(i).getHealth() <= 0) {
				heroHasDiedMessage(healersAndDamageHealers, i, AOE_SPELL_DAMAGE_NAME); // prints dead hero info and removes him from the list
				continue;
			}
			System.out.println(healersAndDamageHealers.get(i).getHeroName() + " - " + healersAndDamageHealers.get(i).getHealth() + " health");
		}		
	}

	private ArrayList<Hero> getTanks() {
		ArrayList<Hero> temp = new ArrayList<Hero>();
		for (int i = 0; i < this.heroesAttackingBoss.size(); i++) {
			if (this.heroesAttackingBoss.get(i) == null) {
				continue;
			}
			
			if (this.heroesAttackingBoss.get(i).getHeroType().equalsIgnoreCase(HeroType.TANK.toString())) {
				temp.add(this.heroesAttackingBoss.get(i));
				this.heroesAttackingBoss.remove(i); // removing the tanks from the array of other heroes
			}
		}
		return temp;
	}
	
	private void heroHasDiedMessage(ArrayList<Hero> heroesList, int index, String damageType) {
		System.out.println(heroesList.get(index).getHeroName() + " has died from " + damageType);
		heroesList.remove(index);
	}
	
	private void thePartyIsDeadMessage() {
		System.out.println("The party has wiped - no loot for you!");
		System.out.println(this.name + " health left: " + this.health);
		System.exit(0);
	}

	private void printRaidInfo() {
		ArrayList<Hero> wholeList = new ArrayList<Hero>();
		wholeList.addAll(tanks);
		wholeList.addAll(heroesAttackingBoss);
		
		for (int i = 0; i < wholeList.size(); i++) {
			if (wholeList.get(i) != null) {
				System.out.println(wholeList.get(i).getHeroName() + ": " + wholeList.get(i).getHealth() + " hp");
			}
		}
		
	}

	private boolean isBossDead() {
		if (this.health <= 0) {
			return true;
		}
		return false;
	}
	
	private void heal() {
		Collections.sort(this.tanks, new CompareByMissingHealth());
		Collections.sort(this.heroesAttackingBoss, new CompareByMissingHealth());
		
		int liveHealers = checkAliveHealers();
		if (liveHealers > 0) {
			if (liveHealers == 1) {
				healTanks();
				return;
			}
			
			healDPS();
		}
		
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			
		}
				
	}
	
	private void healDPS() {
		for (int i = 0; i < this.heroesAttackingBoss.size(); i++) {
			if (this.heroesAttackingBoss.get(i).getHealth() < Hero.TANK_MAX_HEALTH) {
				if (this.heroesAttackingBoss.get(i).getHealth() + Hero.HEALER_HEALS_EACH_TURN > Hero.TANK_MAX_HEALTH) {
					this.heroesAttackingBoss.get(i).setHealth(Hero.TANK_MAX_HEALTH);
					continue;
				}
				
				this.heroesAttackingBoss.get(i).setHealth(this.heroesAttackingBoss.get(i).getHealth() + Hero.HEALER_HEALS_EACH_TURN);
			}
			System.out.println(this.heroesAttackingBoss.get(i).getHeroName() + " healed for " + Hero.HEALER_HEALS_EACH_TURN);
		}
	}

	private void healTanks() {
		for (int i = 0; i < this.tanks.size(); i++) {
			if (this.tanks.get(i).getHealth() < Hero.TANK_MAX_HEALTH) {
				if (this.tanks.get(i).getHealth() + Hero.HEALER_HEALS_EACH_TURN > Hero.TANK_MAX_HEALTH) {
					this.tanks.get(i).setHealth(Hero.TANK_MAX_HEALTH);
					continue;
				}
				
				this.tanks.get(i).setHealth(this.tanks.get(i).getHealth() + Hero.HEALER_HEALS_EACH_TURN);
			}
			System.out.println(tanks.get(i).getHeroName() + " healed for " + Hero.HEALER_HEALS_EACH_TURN);
		}
	}

	private int checkAliveHealers() {
		int healerCount = 0;
		for(int i = 0; i < heroesAttackingBoss.size(); i++) {
			if (heroesAttackingBoss != null && heroesAttackingBoss.get(i).getHeroType().equalsIgnoreCase(HeroType.HEALER.toString())) {
				healerCount += 1;
			}
		}
		Hero.healerCount = healerCount;
		return healerCount;
	}

	private class CompareByMissingHealth implements Comparator<Hero> {
		@Override
		public int compare(Hero hero1, Hero hero2) {
			if (hero1.getHealth() > hero2.getHealth())
				return 1;
			else if (hero1.getHealth() < hero2.getHealth())
				return -1;
			else
				return 0;
		}
	}
}
