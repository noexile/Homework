package Library;

import java.util.Comparator;

public class BookSortComparator implements Comparator {

	@Override
	public int compare(Object b1, Object b2) {
		if (((Book)b1).getReleaseDate().isBefore(((Book)b2).getReleaseDate())) {
			return 1;
		} else if (((Book)b1).getReleaseDate().isAfter(((Book)b2).getReleaseDate())) {
			return -1;
		}
		return 0;
	}
}
