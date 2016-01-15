//	Да се реализира демо програма, която има следните възможности:
//	1. Създаване на районен съд –Велико Търново;
//	2. Създаване и вписване на различни юридически лица в съда –трима съдии, 10 съдебни
//	заседателя, 5 адвоката и двама прокурори.
//	3. Създаване на граждани –5 обвинителя, 5 обвиняеми и 10 свидетеля.
//	4. Създаване на три граждански дела. За всяко дело юристите и гражданите се зачисляват
//	на произволен принцип.
//	5. Създаване на три наказателни дела. За всяко дело юристите и гражданите се зачисляват
//	на произволен принцип.
//	6. За всяко дело да се извика метода „проведи“.
//	7. Да се извика метод в Court класа, който изписва данните на всички юристи заедно с
//	техния брой дела, в който са взимали участие. Метода да се извика преди и след
//	провеждане на всички дела. Метода да извежда юристите и техните дела в табличен вид,
//	сортирани по азбучен ред, разделени с тире. Пример:
//	Иван Иванов – 5
//	Петър Петров – 14

package CourtDemo;

import Court.Court;
import Court.Judge;
import Court.JudicialAssessor;
import Court.LegalEntity;
import Court.PublicProsecutor;
import Court.Lawyer;

public class CourtDemo {

	public static void main(String[] args) {
		
		Court court = new Court("Veliko Turnovo", "bul. Vasil Levski 16", 20);
		
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
		court.addLegalEntityToCourt(anubarak);
		
	}

}
