package Creep;

public class Creep implements ICreep{
	
	
	private String creepName;
	private int health;
	private int mana;
	
	private boolean alive;
		
	// TODO
	// attack speed
	
	private int lowDamageDealt;
	private int highDamageDealth;
	private int movementSpeed;
	
	private double baseArmor;
	private int attackRange;
	private int sightRange;
	
	// Constructor
	public Creep(String creepName, int health, int mana, int lowDamageDealt, int highDamageDealth, int movementSpeed, double baseArmor, int attackRange, int sightRange) {
		setCreepName(creepName);
		setHealth(health);
		setMana(mana);
		setAlive(true);
		setLowDamageDealt(lowDamageDealt);
		setHighDamageDealth(highDamageDealth);
		setMovementSpeed(movementSpeed);
		setBaseArmor(baseArmor);
		setAttackRange(attackRange);
		setSightRange(sightRange);
	}
	
	// methods	
	// TODO
	@Override
	public void moveForwardWhileNoEnemyInRange() {

	}
	
	// TODO
	@Override
	public void focusTarget() {
		
	}

	// TODO
	@Override
	public void attack() {
		
	}

	// TODO
	@Override
	public void changeTarget() {
		
	}

	// TODO
	@Override
	public void levelUp() {
		
	}

	// TODO
	@Override
	public void die() {
		
	}

	
	// getters and setters
	protected String getCreepName() {
		return creepName;
	}

	protected void setCreepName(String creepName) {
		this.creepName = creepName;
	}

	protected int getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}

	protected int getMana() {
		return mana;
	}

	protected void setMana(int mana) {
		this.mana = mana;
	}

	protected boolean isAlive() {
		return alive;
	}

	protected void setAlive(boolean alive) {
		this.alive = alive;
	}

	protected int getLowDamageDealt() {
		return lowDamageDealt;
	}

	protected void setLowDamageDealt(int lowDamageDealt) {
		this.lowDamageDealt = lowDamageDealt;
	}

	protected int getHighDamageDealth() {
		return highDamageDealth;
	}

	protected void setHighDamageDealth(int highDamageDealth) {
		this.highDamageDealth = highDamageDealth;
	}

	protected int getMovementSpeed() {
		return movementSpeed;
	}

	protected void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	protected double getBaseArmor() {
		return baseArmor;
	}

	protected void setBaseArmor(double baseArmor) {
		this.baseArmor = baseArmor;
	}

	protected int getAttackRange() {
		return attackRange;
	}

	protected void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	protected int getSightRange() {
		return sightRange;
	}

	protected void setSightRange(int sightRange) {
		this.sightRange = sightRange;
	}
	
	
}
