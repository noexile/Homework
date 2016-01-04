package HeroesStuff;

import java.util.Random;

public class Hero {

	private String heroName;
	private int health;
	private int mana;
	
	private boolean alive;
	
	private int lowDamageDealt;
	private int highDamageDealth;
	private int movementSpeed;
	
	private double baseArmor;
	private double mainArmor;

	private int level;
	private final int maxLevel = 25;
	private int experiance;
	
	private double strength;
	private double agility;
	private double inteligence;
	private double strengthGrowth;
	private double agilityGrowth;
	private double inteligenceGrowth;
	
	private final String[] mainAttribute = { "strength", "agility", "inteligence" };
	private Items[] backpack;
	
	public Hero(String heroName, int health, int mana, int lowDamageDealt, int highDamageDealth, double baseArmor, int movementSpeed, double strength, double agility, double inteligence, double strengthGrowth, double agilityGrowth, double inteligenceGrowth) {
		setHeroName(heroName);
		
		setHealth(health);
		setMana(mana);
		
		setLowDamageDealt(lowDamageDealt);
		setHighDamageDealth(highDamageDealth);
		setBaseArmor(baseArmor);
		setMovementSpeed(movementSpeed);
		
		setStrength(strength);
		setAgility(agility);
		setInteligence(inteligence);
		
		setStrengthGrowth(strengthGrowth);
		setAgilityGrowth(agilityGrowth);
		setInteligenceGrowth(inteligenceGrowth);
		
		this.backpack = new Items[6];
		setExperiance(0);
		setLevel(1);
		setAlive(true);
	}
	
	// TODO
	// hitPointsRegen();
	
	// TODO
	// manaPointsRegen();
	
	public void attack(Hero damagedHero) {
		Random rand = new Random();
		int damage = rand.nextInt(getHighDamageDealth()) + getLowDamageDealt();
		
		damage = (int) ((damage * getMainArmor()) / 100);		
		damagedHero.setHealth(damagedHero.getHealth() - damage);
	}
	
	public void levelUp() {
		if (getLevel() > getMaxLevel()) {
			System.out.println("Max level reached: " + maxLevel);
			return;
		}
		setLevel(getLevel() + 1);
		setStrength(getStrength() + getStrengthGrowth());
		setAgility(getAgility() + getAgilityGrowth());
		setInteligence(getInteligence() + getInteligenceGrowth());
	}
	
	private void death() {
		// TODO
		// spread exp to nearby heroes
		
		setAlive(false); // remove hero - he is no longer available to be damaged or to deal damage / spells
		
		// think of a way to implement range - either variable or array / list
		
		
		System.out.println(this.heroName + " has died.");
	}
	
	
	/*
	 * 
	Getters and Setters below
	*
	*/
	public String getHeroName() {
		return this.heroName;
	}

	private void setHeroName(String heroName) {
		if (heroName.trim().isEmpty()) {
			System.out.println("You cannot enter empty Hero Name");
		}
		this.heroName = heroName;
	}

	private int getHealth() {
		return this.health;
	}

	private void setHealth(int health) {
		if (health < 0) {
			death();
		}
		this.health = (int) (health + (getStrength() * 19));
	}

	private int getMana() {
		return this.mana;
	}

	private void setMana(int mana) {
		this.mana = mana;
	}

	private double getBaseArmor() {
		return this.baseArmor;
	}

	private void setBaseArmor(double baseArmor) {
		this.baseArmor = baseArmor;
	}

	private double getMainArmor() {
		return this.mainArmor;
	}

	private void setMainArmor() {
		this.mainArmor = ((getBaseArmor() * 0.06) / (1 + 0.06 + getBaseArmor())) * 100;
	}

	private int getMovementSpeed() {
		return this.movementSpeed;
	}

	private void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	private int getLevel() {
		return this.level;
	}

	private void setLevel(int level) {
		this.level = level;
	}

	private int getExperiance() {
		return this.experiance;
	}

	private void setExperiance(int experiance) {
		this.experiance = experiance;
	}

	private double getStrength() {
		return this.strength;
	}

	private void setStrength(double strength) {
		this.strength = strength;
	}

	private double getAgility() {
		return this.agility;
	}

	private void setAgility(double agility) {
		this.agility = agility;
	}

	private double getInteligence() {
		return this.inteligence;
	}

	private void setInteligence(double inteligence) {
		this.inteligence = inteligence;
	}

	private Items[] getBackpack() {
		return this.backpack;
	}

	private void setBackpack(Items[] backpack) {
		this.backpack = backpack;
	}

	private String[] getMainAttribute() {
		return this.mainAttribute;
	}

	private int getMaxLevel() {
		return this.maxLevel;
	}

	private double getStrengthGrowth() {
		return this.strengthGrowth;
	}

	private void setStrengthGrowth(double strengthGrowth) {
		this.strengthGrowth = strengthGrowth;
	}

	private double getAgilityGrowth() {
		return this.agilityGrowth;
	}

	private void setAgilityGrowth(double agilityGrowth) {
		this.agilityGrowth = agilityGrowth;
	}

	private double getInteligenceGrowth() {
		return this.inteligenceGrowth;
	}

	private void setInteligenceGrowth(double inteligenceGrowth) {
		this.inteligenceGrowth = inteligenceGrowth;
	}

	private int getLowDamageDealt() {
		return this.lowDamageDealt;
	}

	private void setLowDamageDealt(int lowDamageDealt) {
		this.lowDamageDealt = lowDamageDealt;
	}

	private int getHighDamageDealth() {
		return this.highDamageDealth;
	}

	private void setHighDamageDealth(int highDamageDealth) {
		this.highDamageDealth = highDamageDealth;
	}

	private boolean getIsAlive() {
		return this.alive;
	}

	private void setAlive(boolean alive) {
		this.alive = alive;
	}
	
}
