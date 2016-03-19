package Creep;

public interface ICreep {

	void moveForwardWhileNoEnemyInRange();
	void focusTarget();
	void attack();
	void changeTarget();
	void levelUp();
	void die();
	
}
