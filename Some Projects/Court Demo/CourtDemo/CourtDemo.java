//	Да се реализира демо програма, която има следните възможности:
//	1. Създаване на районен съд –Велико Търново;
//	2. Създаване и вписване на различни юридически лица в съда –трима съдии, 10 съдебни заседателя, 5 адвоката и двама прокурори.
//	3. Създаване на граждани –5 обвинителя, 5 обвиняеми и 10 свидетеля.
//	4. Създаване на три граждански дела. За всяко дело юристите и гражданите се зачисляват на произволен принцип.
//	5. Създаване на три наказателни дела. За всяко дело юристите и гражданите се зачисляват на произволен принцип.
//	6. За всяко дело да се извика метода „проведи“.
//	7. Да се извика метод в Court класа, който изписва данните на всички юристи заедно с техния брой дела, в който са взимали участие. Метода да се извика преди и след провеждане на всички дела. Метода да извежда юристите и техните дела в табличен вид, сортирани по азбучен ред, разделени с тире. Пример:
//	Иван Иванов – 5
//	Петър Петров – 14

package CourtDemo;

import Court.Accuser;
import Court.Case;
import Court.Citizen;
import Court.Court;
import Court.CriminalCase;
import Court.CivilCase;
import Court.Defendant;
import Court.Judge;
import Court.JudicialAssessor;
import Court.LegalEntity;
import Court.PublicProsecutor;
import Court.Witnes;
import Court.Lawyer;

public class CourtDemo {

	public static void main(String[] args) {
		
		Court court = new Court("Veliko Turnovo", "bul. Vasil Levski 16", 23, 6);
		
		LegalEntity theButcher = Judge.createJudge("The Butcher", 15, 33);
		LegalEntity stitches = Judge.createJudge("Stitches", 6, 4);
		LegalEntity kerrigan = Judge.createJudge("Sarah Kerrigan", 13, 66);
		
		LegalEntity tyrande = new JudicialAssessor("Tyrande", 1, 1);
		LegalEntity raynor = new JudicialAssessor("Jimmy Raynor", 1, 1);
		LegalEntity chen = new JudicialAssessor("Chen", 1, 1);
		LegalEntity murky = new JudicialAssessor("Murky", 1, 1);
		LegalEntity diablo = new JudicialAssessor("Diablo", 1, 1);
		LegalEntity muradin = new JudicialAssessor("Muradin", 1, 1);
		LegalEntity sonya = new JudicialAssessor("Sonya", 1, 1);
		LegalEntity rexxar = new JudicialAssessor("Rexxar", 1, 1);
		LegalEntity leoric = new JudicialAssessor("Leoric", 1, 1);
		LegalEntity nova = new JudicialAssessor("Nova", 1, 1);
		LegalEntity zagara = new JudicialAssessor("Zagara", 1, 1);
		LegalEntity nazeeboo = new JudicialAssessor("Nazeeboo", 1, 1);
		LegalEntity johanna = new JudicialAssessor("Johanna", 1, 1);
		
		LegalEntity azmodan = Lawyer.createPublicProsecutor("Azmodan", 230, 1687);
		LegalEntity illidan = Lawyer.createPublicProsecutor("Illidan", 10000, 999);
		LegalEntity gazlowe = Lawyer.createPublicProsecutor("Gazlowe", 3, 19);
		LegalEntity jaina = Lawyer.createPublicProsecutor("Jaina", 30, 666);
		LegalEntity sylvanas = Lawyer.createPublicProsecutor("Sylvanas", 10, 31);
		
		
		court.addLegalEntityToCourt(theButcher);
		court.addLegalEntityToCourt(stitches);
		court.addLegalEntityToCourt(kerrigan);
		
		court.addLegalEntityToCourt(tyrande);
		court.addLegalEntityToCourt(raynor);
		court.addLegalEntityToCourt(chen);
		court.addLegalEntityToCourt(murky);
		court.addLegalEntityToCourt(diablo);
		court.addLegalEntityToCourt(muradin);
		court.addLegalEntityToCourt(sonya);
		court.addLegalEntityToCourt(rexxar);
		court.addLegalEntityToCourt(leoric);
		court.addLegalEntityToCourt(nova);
		court.addLegalEntityToCourt(zagara);
		court.addLegalEntityToCourt(nazeeboo);
		court.addLegalEntityToCourt(johanna);
		
		court.addLegalEntityToCourt(azmodan);
		court.addLegalEntityToCourt(illidan);
		court.addLegalEntityToCourt(gazlowe);
		court.addLegalEntityToCourt(jaina);
		court.addLegalEntityToCourt(sylvanas);
		
		LegalEntity arthas = PublicProsecutor.createPublicProsecutor("Arthas", 15, 11);
		LegalEntity kelthas = PublicProsecutor.createPublicProsecutor("Kel'Thas", 15, 11);
		LegalEntity anubarak = PublicProsecutor.createPublicProsecutor("Anub'Arak", 15, 11);

		court.addLegalEntityToCourt(arthas);
		court.addLegalEntityToCourt(kelthas);
//		court.addLegalEntityToCourt(anubarak);
		
		Citizen peon1 = new Accuser("Horde", "Peon", "1", "Orgrimmar", 20, 1);
		Citizen peon2 = new Accuser("Horde", "Peon", "2", "Undercity", 21, 2);
		Citizen peon3 = new Accuser("Horde", "Peon", "3", "Silvermoon", 22, 1);
		Citizen peon4 = new Accuser("Horde", "Peon", "4", "Thunder Bluff", 23, 3);
		Citizen peon5 = new Accuser("Horde", "Peon", "5", "Shattrath", 24, 2);
		
		((Accuser)peon1).addLawyer(azmodan);
		
		((Accuser)peon2).addLawyer(illidan);
		((Accuser)peon2).addLawyer(jaina);
		
		((Accuser)peon3).addLawyer(gazlowe);
		
		((Accuser)peon4).addLawyer(jaina);
		((Accuser)peon4).addLawyer(gazlowe);
		((Accuser)peon4).addLawyer(azmodan);
		
		((Accuser)peon5).addLawyer(illidan);
		
		Citizen human1 = new Defendant("Alliance", "Worker", "1", "Stormwind", 20, 2);
		Citizen human2 = new Defendant("Alliance", "Worker", "2", "Ironforge", 21, 3);
		Citizen human3 = new Defendant("Alliance", "Worker", "3", "Darnassus", 22, 2);
		Citizen human4 = new Defendant("Alliance", "Worker", "4", "Exodar", 23, 1);
		Citizen human5 = new Defendant("Alliance", "Worker", "5", "Warspear", 24, 1);
		
		((Defendant) human1).addLawyer(azmodan);
		((Defendant) human1).addLawyer(illidan);
//		((Defendant) human1).addLawyer(gazlowe);
		
		((Defendant) human2).addLawyer(azmodan);
		((Defendant) human2).addLawyer(jaina);
		((Defendant) human2).addLawyer(gazlowe);
		
		((Defendant) human3).addLawyer(illidan);
		((Defendant) human3).addLawyer(sylvanas);
		
		((Defendant) human4).addLawyer(gazlowe);
		
		((Defendant) human5).addLawyer(azmodan);
		
		Citizen neutral1 = new Witnes("Neutral", "Witnes", "1", "Crossroads", 33);
		Citizen neutral2 = new Witnes("Neutral", "Witnes", "2", "Okril'lon Hold", 33);
		Citizen neutral3 = new Witnes("Neutral", "Witnes", "3", "Aerie Peak", 33);
		Citizen neutral4 = new Witnes("Neutral", "Witnes", "4", "Revantusk Village", 33);
		Citizen neutral5 = new Witnes("Neutral", "Witnes", "5", "Krom'Gap Fortress", 33);
		Citizen neutral6 = new Witnes("Neutral", "Witnes", "6", "Temple of Earth", 33);
		Citizen neutral7 = new Witnes("Neutral", "Witnes", "7", "Allerian Stronghold", 33);
		Citizen neutral8 = new Witnes("Neutral", "Witnes", "8", "Shado-Pan Monastery", 33);
		Citizen neutral9 = new Witnes("Neutral", "Witnes", "9", "Axefall", 33);
		Citizen neutral10 = new Witnes("Neutral", "Witnes", "10", "The Argent Stand", 33);
		
		Case civilCase1 = CivilCase.createCivilCase(theButcher, human3, 9, peon1);
		Case civilCase2 = CivilCase.createCivilCase(stitches, human4, 4, peon2);
		Case civilCase3 = CivilCase.createCivilCase(kerrigan, human5, 3, peon3);
		
		civilCase1.addWitnes(neutral1);
		civilCase1.addWitnes(neutral2);
		civilCase1.addWitnes(neutral3);
		civilCase1.addWitnes(neutral4);
		civilCase1.addWitnes(neutral5);
		civilCase1.addWitnes(neutral6);
		civilCase1.addWitnes(neutral7);
		civilCase1.addWitnes(neutral8);
		civilCase1.addWitnes(neutral9);
//		civilCase1.addWitnes(neutral10);
		
		civilCase1.addJudicialAssessors(tyrande);
		civilCase1.addJudicialAssessors(chen);
		civilCase1.addJudicialAssessors(diablo);
		
		civilCase2.addWitnes(neutral10);
		civilCase2.addWitnes(neutral1);
		civilCase2.addWitnes(neutral5);
		civilCase2.addWitnes(neutral6);
		
		civilCase2.addJudicialAssessors(leoric);
		civilCase2.addJudicialAssessors(sonya);
		civilCase2.addJudicialAssessors(muradin);
		
		civilCase3.addWitnes(neutral3);
		civilCase3.addWitnes(neutral4);
		civilCase3.addWitnes(neutral8);
		
		civilCase3.addJudicialAssessors(rexxar);
		civilCase3.addJudicialAssessors(nova);
		civilCase3.addJudicialAssessors(murky);
		
		
		Case criminalCase1 = CriminalCase.createCriminalCase(theButcher, human1, 5, arthas);
		Case criminalCase2 = CriminalCase.createCriminalCase(stitches, human2, 4, kelthas);
		Case criminalCase3 = CriminalCase.createCriminalCase(kerrigan, human3, 3, anubarak);
		
		criminalCase1.addWitnes(neutral10);
		criminalCase1.addWitnes(neutral1);
		criminalCase1.addWitnes(neutral5);
		criminalCase1.addWitnes(neutral6);
		criminalCase1.addWitnes(neutral9);
		
		criminalCase1.addJudicialAssessors(tyrande);
		criminalCase1.addJudicialAssessors(raynor);
		criminalCase1.addJudicialAssessors(chen);
		criminalCase1.addJudicialAssessors(murky);
		criminalCase1.addJudicialAssessors(diablo);
		criminalCase1.addJudicialAssessors(muradin);
		criminalCase1.addJudicialAssessors(sonya);
		criminalCase1.addJudicialAssessors(rexxar);
		criminalCase1.addJudicialAssessors(leoric);
		criminalCase1.addJudicialAssessors(nova);
		criminalCase1.addJudicialAssessors(zagara);
		criminalCase1.addJudicialAssessors(nazeeboo);
		criminalCase1.addJudicialAssessors(johanna);
		
		criminalCase2.addWitnes(neutral1);
		criminalCase2.addWitnes(neutral2);
		criminalCase2.addWitnes(neutral3);
		criminalCase2.addWitnes(neutral5);
		
		criminalCase2.addJudicialAssessors(tyrande);
		criminalCase2.addJudicialAssessors(raynor);
		criminalCase2.addJudicialAssessors(chen);
		criminalCase2.addJudicialAssessors(murky);
		criminalCase2.addJudicialAssessors(diablo);
		criminalCase2.addJudicialAssessors(muradin);
		criminalCase2.addJudicialAssessors(sonya);
		criminalCase2.addJudicialAssessors(rexxar);
		criminalCase2.addJudicialAssessors(leoric);
		criminalCase2.addJudicialAssessors(nova);
		criminalCase2.addJudicialAssessors(zagara);
		criminalCase2.addJudicialAssessors(nazeeboo);
		criminalCase2.addJudicialAssessors(johanna);
		
		criminalCase3.addWitnes(neutral1);
		criminalCase3.addWitnes(neutral10);
		criminalCase3.addWitnes(neutral9);
		
		criminalCase3.addJudicialAssessors(tyrande);
		criminalCase3.addJudicialAssessors(raynor);
		criminalCase3.addJudicialAssessors(chen);
		criminalCase3.addJudicialAssessors(murky);
		criminalCase3.addJudicialAssessors(diablo);
		criminalCase3.addJudicialAssessors(muradin);
		criminalCase3.addJudicialAssessors(sonya);
		criminalCase3.addJudicialAssessors(rexxar);
		criminalCase3.addJudicialAssessors(leoric);
		criminalCase3.addJudicialAssessors(nova);
		criminalCase3.addJudicialAssessors(zagara);
		criminalCase3.addJudicialAssessors(nazeeboo);
		criminalCase3.addJudicialAssessors(johanna);
		
		court.addCase(civilCase1);
		court.addCase(civilCase2);
		court.addCase(civilCase3);
		court.addCase(criminalCase1);
		court.addCase(criminalCase2);
		court.addCase(criminalCase3);
		
		court.printLegalEntityesInfo();
		
		court.conductCases();
		
		court.printLegalEntityesInfo();
	}

}
