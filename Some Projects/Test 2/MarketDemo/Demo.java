//	Да се реализира демо, което:
//	1. Създава 10 доставчика на произволен принцип – на дребно и на едро.
//	2. Създава 20 търговски обекта на произволен принцип – сергии, магазини и будки.
//	3. Създава един амбулантен търговец с капитал 100 лева, един ЕТ с капитал 500 лева и една търговска верига с капитал 3000 лева.
//	4. Подава на търговците съответни търговски обекти на произволен принцип.
//	5. Да се извика метод, който приема списък от създадените търговци и за всеки търговец се започва търговска дейност. Търговската дейност представлява:
//	◦ поръчка на стоки от доставчик за всеки търговски обект. Да се извежда на екрана списъка със стоки, сортиран по цена в нарастващ ред.
//	◦ прибиране на оборот от всеки търговски обект – да се извежда на екрана общата сума на печалбата. След продажба списъкът с останалите стоки в магазина трябва отново да е сортиран по цена.
//	◦ плащане на месечен данък към държавата за всеки търговски обект.
//	6. Да се изпише текущия паричен баланс на всеки обект след упражняването на търговска дейност.
//	7. Да се изведе търговецът с най-голям брой продадени стоки за месеца.
//	8. Да се изведе търговецът с най-голям размер на изплатения данък към държавата.

package MarketDemo;

import java.util.Random;

import Market.AmbulantenTargovec;
import Market.ButkaNaUlicata;
import Market.Dostavchik;
import Market.DostavchikNaDrebno;
import Market.DostavchikNaEdro;
import Market.ET;
import Market.MagazinVMola;
import Market.Sergia;
import Market.Targovec;
import Market.TargovskaVeriga;
import Market.TargovskiObekt;

public class Demo {
	public static void main(String[] args) {
		
		// TODO
		// Fixing whole demo

		Dostavchik[] dostavchici = new Dostavchik[10];
		TargovskiObekt[] targovskiObekti = new TargovskiObekt[20];
		Targovec[] targovci = new Targovec[3];
		
		Targovec ambulantenTargovec = new AmbulantenTargovec("Ambulanten targovec", "ulica nezabravka 1", 100);
		Targovec et = new ET("ET 1", "bul. ivan shishman 1", 500);
		Targovec targovskaVeriga = new TargovskaVeriga("Shano magazini" , "ul. Izmislena", 3000);

		targovci[0] = ambulantenTargovec;
		targovci[1] = et;
		targovci[2] = targovskaVeriga;
		
				
		Random rand = new Random();
		int etTargovskiObektNumber;
		int start;
		int end;
		
		int counter1 = 1;
		int counter2 = 1;
		int counter3 = 1;
		
		// adding randomized Targovski Obekt na Targoveca
		do {
			etTargovskiObektNumber = rand.nextInt(19 - 0) + 0;
			et.addTargovskiObekt(targovskiObekti[etTargovskiObektNumber]);
		} while (targovskiObekti[etTargovskiObektNumber] instanceof MagazinVMola);
		
		if (etTargovskiObektNumber < 10) {
			start = 10;
			end = 19;
		} else {
			start = 0;
			end = 8;
		}
		
		int counter = 0;
		 
		for (int i = start; i < end; i++) {
			if (counter == 5) {
				break;
			}
			
			targovskaVeriga.addTargovskiObekt(targovskiObekti[start]);
			counter++;			
		}
		
		
		for (int i = 0; i < dostavchici.length; i++) {
			boolean temp = rand.nextBoolean();
			if (temp) {
				dostavchici[i] = new DostavchikNaDrebno("Dostavchik na drebno " + counter1, "ul. nezabravka " + counter1++, "08:00 - 20:00");
			} else {
				dostavchici[i] = new DostavchikNaEdro("Dostavchik na edro " + counter2, "ul. nezabravka " + counter2++, "08:00 - 20:00");
			}
		}
		counter1 = 1;
		counter2 = 1;
		
		
		for (int i = 0; i < targovskiObekti.length; i++) {
			int temp = rand.nextInt(3 - 1) + 1;
			
			switch(temp) {
				case 1: targovskiObekti[i] = new Sergia("ul. Klokotnica " + counter1++, "09:00 - 18:00");
					break;
				case 2: targovskiObekti[i] = new MagazinVMola("ulicata na Mol Serdika " + counter2++, "10:00 - 21:00");
					break;
				case 3: targovskiObekti[i] = new ButkaNaUlicata("ul. Sharena " + counter3++, "08:00 - 15:00");
					break;
					
					default: System.out.println("If you are reading this than the shit got real!");
			}
		}
		
		// printing ballance of the Targovci С…СЉ-С…СЉ
		for (int i = 0; i < targovci.length; i++) {
			targovci[i].printBallance();
		}
		
		
		for (int i = 0; i < targovci.length; i++) {
			for (int j = 0; j < targovci[i].targovskiObekt.length; j++) {
				if (targovci[i].targovskiObekt[j] instanceof ButkaNaUlicata) {
					targovci[i].tax(50);
				} else if (targovci[i].targovskiObekt[j] instanceof MagazinVMola) {
					targovci[i].tax(150);
				} else if (targovci[i].targovskiObekt[j] instanceof ButkaNaUlicata) {
					targovci[i].tax(50);
				}
			}
		}
		
		if (targovci[0].getMoney() > targovci[1].getMoney() && targovci[0].getMoney() > targovci[2].getMoney()) {
			System.out.println(targovci[0].getName() + " " + targovci[0].getMoney());
		} else if (targovci[1].getMoney() > targovci[0].getMoney() && targovci[1].getMoney() > targovci[2].getMoney()) {
			System.out.println(targovci[1].getName() + " " + targovci[0].getMoney());
		} else {
			System.out.println(targovci[1].getName() + " " + targovci[0].getMoney());
		}

	}
}
