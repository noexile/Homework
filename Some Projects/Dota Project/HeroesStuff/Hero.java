package HeroesStuff;

public class Hero {

	private String heroName;
	private int health;
	private int mana;
	
	private int damageDealt;
	private int movementSpeed;
	
	private double baseArmor;
	private double mainArmor;

	private int level;
	private int experiance;
	
	private int strength;
	private int agility;
	private int inteligence;
	
	private final String[] mainAttribute = { "strength", "agility", "inteligence" };
	private Items[] backpack;
	
	public Hero(String heroName, int health, int mana, int damageDealt, double baseArmor, int movementSpeed, int strength, int agility, int inteligence) {
		setHeroName(heroName);
		
		setHealth(health);
		this.mana = mana;
		
		this.damageDealt = damageDealt;
		this.baseArmor = baseArmor;
		this.movementSpeed = movementSpeed;
		
		this.strength = strength;
		this.agility = agility;
		this.inteligence = inteligence;
		
		this.backpack = new Items[6];
		this.experiance = 0;
		this.level = 0;
	}

	public String getHeroName() {
		return heroName;
	}

	private void setHeroName(String heroName) {
		if (heroName.trim().isEmpty()) {
			System.out.println("You cannot enter empty Hero Name");
		}
		this.heroName = heroName;
	}

	public int getHealth() {
		return health;
	}
	
	public void damageDealth(int damage, Hero damagedHero) {
		damagedHero.setHealth(damagedHero.health - damage);
	}
	
	public void damageReceived(int damage) {
		// TODO
	}

	private void setHealth(int health) {
		if (health < 0) {
			death();
		}
		this.health = health;
	}

	private void death() {
		// TODO
		// spread exp to nearby heroes
		// remove hero - he is no longer available to be damaged or to deal damage / spells
		
		// think of a way to implement range - either variable or array / list
		
		System.out.println(this.heroName + " has died.");
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getDamageDealt() {
		return damageDealt;
	}

	public void setDamageDealt(int damageDealt) {
		this.damageDealt = damageDealt;
	}

	public double getBaseArmor() {
		return baseArmor;
	}

	public void setBaseArmor(double baseArmor) {
		this.baseArmor = baseArmor;
	}

	public double getMainArmor() {
		return mainArmor;
	}

	public void setMainArmor(double mainArmor) {
		this.mainArmor = mainArmor;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getInteligence() {
		return inteligence;
	}

	public void setInteligence(int inteligence) {
		this.inteligence = inteligence;
	}

	public Items[] getBackpack() {
		return backpack;
	}

	public void setBackpack(Items[] backpack) {
		this.backpack = backpack;
	}

	public String[] getMainAttribute() {
		return mainAttribute;
	}
	
}
