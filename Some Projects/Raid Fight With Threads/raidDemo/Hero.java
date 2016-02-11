package raidDemo;

enum HeroType {TANK, DPS, HEALER}

public class Hero extends Thread {
	
	public static final int TANK_DAMAGE = 10_000;
	public static final int DPS_DAMAGE = 30_000;
	
	public static final int TANK_MAX_HEALTH = 250_000;
	public static final int DPS_MAX_HEALTH = 160_000;
	public static final int HEALER_MAX_HEALTH = 140_000;
	public static final int HEALER_HEALS_EACH_TURN = 20000;
	public static int healerCount;
	private String heroName;
	private String heroType;
	private int health;
	
	public Hero(String heroName, String heroType) {
		try {
			if (!(heroType.equalsIgnoreCase(HeroType.TANK.toString()) || heroType.equalsIgnoreCase(HeroType.DPS.toString()) || heroType.equalsIgnoreCase(HeroType.HEALER.toString()))) {
				throw new IncorrectHeroTypeException();
			}
			
			this.heroName = heroName;
			this.heroType = heroType.toLowerCase();
			
			if (heroType.equalsIgnoreCase(HeroType.TANK.toString())) {
				this.health = TANK_MAX_HEALTH;
			} else if (heroType.equalsIgnoreCase(HeroType.DPS.toString())) {
				this.health = DPS_MAX_HEALTH;
			} else if (heroType.equalsIgnoreCase(HeroType.HEALER.toString())) {
				this.health = HEALER_MAX_HEALTH;
				healerCount++;
			}			
		} catch (IncorrectHeroTypeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(200);
				Demo.azmodan.takeDamage();
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	// getters and setters
	String getHeroName() {
		return heroName;
	}
	
	String getHeroType() {
		return heroType;
	}
	
	int getHealth() {
		return health;
	}
	
	void setHealth(int health) {
		this.health = health;
	}
}
