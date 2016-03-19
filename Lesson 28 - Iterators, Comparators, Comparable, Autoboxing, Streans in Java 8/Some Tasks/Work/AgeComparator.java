package Work;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee first, Employee second) {
		if (first.getAge() > second.getAge())
			return 1;
		if (first.getAge() < second.getAge())
			return -1;
		return 0;
	}
	
}
