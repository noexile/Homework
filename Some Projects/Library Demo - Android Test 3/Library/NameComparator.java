package Library;

import java.util.Comparator;

public class NameComparator implements Comparator {
	
	@Override
	public int compare(Object tb1, Object tb2) {
		return ((Textbook) tb1).getName().compareTo(((Textbook) tb2).getName());
	}

}
