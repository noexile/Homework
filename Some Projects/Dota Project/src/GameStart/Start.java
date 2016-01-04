package GameStart;

import HeroesStuff.Hero;
import HeroesStuff.Heroes.Abbadon;
import Map.Battlefield;

public class Start {

	public static void main(String[] args) {
		Battlefield battlefield = new Battlefield();
		
		Hero hero1 = new Abbadon();
		Hero hero2 = new Abbadon();
		
		battlefield.getHeroInMiddleLine(hero1);
		battlefield.getHeroInMiddleLine(hero2);
		

		// TODO 
		// teams
		
	}

}
