//  1. Създава 10 доставчика на произволен принцип – на дребно и на едро - създадени и добавени на търговците
//	2. Създава 20 търговски обекта на произволен принцип – сергии, магазини и будки - създадени и добавени на търговците
//	3. Създава един амбулантен търговец с капитал 100 лева, един ЕТ с капитал 500 лева и една търговска верига с капитал 3000 лева.
//	4. Подава на търговците съответни търговски обекти на произволен принцип.

//	5. Да се извика метод, който приема списък от създадените търговци и за всеки търговец се започва търговска дейност. Търговската дейност представлява:
//	   - поръчка на стоки от доставчик за всеки търговски обект. Да се извежда на екрана списъка със стоки, сортиран по цена в нарастващ ред.
//	   - прибиране на оборот от всеки търговски обект – да се извежда на екрана общата сума на печалбата. След продажба списъкът с
//	     останалите стоки в магазина трябва отново да е сортиран по цена.
//	   - плащане на месечен данък към държавата за всеки търговски обект.

//	6. Да се изпише текущия паричен баланс на всеки обект след упражняванетона търговска дейност.

//	7. Да се изведе търговецът с най-голям брой продадени стоки за месеца.

//	8. Да се изведе търговецът с най-голям размер на изплатения данък към държавата.

package MarketDemo;

import Market.AmbulantenTargovec;
import Market.ET;
import Market.Targovec;
import Market.TargovskaVeriga;

public class Demo {
	public static void main(String[] args) {
	
		Targovec[] targovci = new Targovec[3];

		Targovec ambulantenTargovec = new AmbulantenTargovec("Ambulanten targovec", "ulica nezabravka 1", 100);
		Targovec et = new ET("ET 1", "bul. ivan shishman 1", 500);
		Targovec targovskaVeriga = new TargovskaVeriga("Shano magazini" , "ul. Izmislena", 3000);
		
		targovci[0] = ambulantenTargovec;
		targovci[1] = et;
		targovci[2] = targovskaVeriga;
		
			
	}	
}
