package Work;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee first, Employee second) {
		if (first.getSalary() > second.getSalary())
			return 1;
		if (first.getSalary() < second.getSalary())
			return -1;
		return 0;
	}
	
}
