package Library;

import java.util.Comparator;

public class SortByDateTaken implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String o1TakenOn;
		String o2TakenOn;
//		
//		if (o1 instanceof Book) {
//			o1TakenOn = ((Book) o1).getTakenOn().get(((Book) o1).getTakenOn().size() - 1);
//			o2TakenOn = ((Book) o1).getTakenOn().get(((Book) o1).getTakenOn().size() - 1);
//			return o1TakenOn.compareTo(o2TakenOn);
//		} else if (o1 instanceof Textbook) {
//			o1TakenOn = ((Textbook) o1).getTakenOn().get(((Textbook) o1).getTakenOn().size() - 1);
//			o2TakenOn = ((Textbook) o1).getTakenOn().get(((Textbook) o1).getTakenOn().size() - 1);
//			return o1TakenOn.compareTo(o2TakenOn);
//		}
//		
		return 0;
	}
}
