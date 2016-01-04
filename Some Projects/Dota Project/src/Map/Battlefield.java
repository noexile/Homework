package Map;

import HeroesStuff.Hero;

public class Battlefield {
	
	public static final int MAX_HEROES_IN_THE_GAME = 10;
	
	Hero[] heroesInMiddleLine;
	Hero[] heroesInTopLine;
	Hero[] heroesInBottomLine;
	
	public Battlefield() {
		
		heroesInMiddleLine = new Hero[MAX_HEROES_IN_THE_GAME];
		heroesInTopLine = new Hero[MAX_HEROES_IN_THE_GAME];
		heroesInBottomLine = new Hero[MAX_HEROES_IN_THE_GAME];
	}
	
	
	//TODO
	public void getHeroInMiddleLine(Hero hero) {
		for (int i = 0; i < heroesInMiddleLine.length; i++) {
			if (heroesInMiddleLine[i] == null) {
				heroesInMiddleLine[i] = hero;
			}
		}
	}
	
	// TODO
	void switchLine(Hero hero) {
		
	}
	
}
