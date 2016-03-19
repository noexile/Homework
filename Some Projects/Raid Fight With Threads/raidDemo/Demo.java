package raidDemo;

import java.util.ArrayList;

public class Demo {
	
	static ArrayList<Hero> heroes = new ArrayList<Hero>();
	static Boss azmodan;
	
	public static void main(String[] args) {
		
		Hero tank1 = new Hero("Tankirashtiya", "tank");
		Hero tank2 = new Hero("Nosya na boi", "tank");
		
		Hero dps1 = new Hero("Kufara", "dps");
		Hero dps2 = new Hero("Neshtastnik", "dps");
		Hero dps3 = new Hero("Slabaka", "dps");
		Hero dps4 = new Hero("Lentyai", "dps");
		Hero dps5 = new Hero("Slepiya", "dps");
		
		Hero healer1 = new Hero("Murzela", "healer");
		Hero healer2 = new Hero("Nyama mana", "healer");
		Hero healer3 = new Hero("Onzi s cd-tata", "healer");
		
		azmodan = new Boss("Azmodan");
		
		heroes.add(tank1);
		heroes.add(tank2);
		
		heroes.add(dps1);
		heroes.add(dps2);
		heroes.add(dps3);
		heroes.add(dps4);
		heroes.add(dps5);
		
		heroes.add(healer1);
		heroes.add(healer2);
		heroes.add(healer3);
		
		azmodan.start();
		tank1.start();
		tank2.start();
		dps1.start();
		dps2.start();
		dps3.start();
		dps4.start();
		dps5.start();
		healer1.start();
		healer2.start();
		healer3.start();
	}
}
