//	къде, кога, кои групи ще свирят и часовете на излизане ислизане от сцената, 
//	както и да отрази самото протичане на фестивала.

package Demo;

import MusicFestival.Group;
import MusicFestival.InstrumentPlayer;
import MusicFestival.Musician;
import MusicFestival.Song;
import MusicFestival.Vocal;
import MusicFestival.Act;
import MusicFestival.Festival;

public class MusicFestivalDemo {
	public static void main(String[] args) {
		
		Festival someFestival = new Festival(5);
		
		Musician fredDurst = new Vocal("Fred Durst");
		Musician samRivers = new InstrumentPlayer("Sam Rivers", "Bass guitar");
		Musician johnOtto = new InstrumentPlayer("John Otto", "Drums");
		Musician wesBorland = new InstrumentPlayer("Wes Borland", "Guitar");
		
		Musician jacobyShaddix = new Vocal("Jacoby Shaddix");
		Musician jerryHorton = new InstrumentPlayer("Jerry Horton", "Guitar");
		Musician tonyPalermo = new InstrumentPlayer("Tony Palermo", "Drums");

		Group limpBizkit = new Group(4, 3, "Limp Bizkit");
		limpBizkit.addMusician(fredDurst);
		limpBizkit.addMusician(samRivers);
		limpBizkit.addMusician(johnOtto);
		limpBizkit.addMusician(wesBorland);	
		
		Group papaRoach = new Group(3, 3, "Papa Roach");
		papaRoach.addMusician(jacobyShaddix);
		papaRoach.addMusician(jerryHorton);
		papaRoach.addMusician(tonyPalermo);
		
		Song myWay = new Song("My Way", "You think you're special \nYou do\nI can see it in your eyes...");
		Song myGeneration = new Song("My Generation" , "if only we could fly limp bizkit style john otto take'em\nto the matthews bridge can you feel it my generation...");
		Song nookie = new Song("Nookie", "I came into this world as a reject \nLook into these eyes\nThen you'll see the size of these flames...");
		
		Song lastResort = new Song("Last Resort", "Cut my life into pieces \nThis is my last resort,\nSuffocation, no breathing\nDon't give a fuck if I cut my arm bleeding...");
		Song scars = new Song("Scars", "I tear my heart open, I sew myself shut\nMy weakness is that I care too much\nAnd my scars remind me that the past is real\nI tear my heart open just to feel");
		Song sheLovesMeNot = new Song("She loves me not", "when i see her eyes\nlook into my eyes\nthen i realize that\nshe could see inside my head");
				
		limpBizkit.addSong(myWay);
		limpBizkit.addSong(myGeneration);
		limpBizkit.addSong(nookie);	
		
		papaRoach.addSong(lastResort);
		papaRoach.addSong(scars);
		papaRoach.addSong(sheLovesMeNot);
		
		Act firstAct = new Act(limpBizkit, "22:00", "22:30");
		Act secondAct = new Act(papaRoach, "22:45", "23:30");
		
		someFestival.addAct(firstAct);
		someFestival.addAct(secondAct);
		
		someFestival.startFestival();
		
	}
}
