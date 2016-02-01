//	Write a demo that creates the company and adds employees into different departments.
//	Then list all employees that the company has. The output of the program should be a list of
//	departments and a sublist of employees for each department.

package WorkDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import Work.AgeComparator;
import Work.Company;
import Work.Employee;
import Work.NameComparator;
import Work.SalaryComparator;

public class Demo {
	public static void main(String[] args) {
		
		Company tsak = new Company("Tsatchets AD");
		
		Employee gosho = new Employee("Georgi", 29, 800, "8612291120");
		Employee tsanyo = new Employee("Tsanko", 26, 2100, "1001110101");
		Employee tisho = new Employee("Tihomir", 25, 500, "123456790");
		Employee milena = new Employee("Milena", 22, 1349, "0987654321");
		Employee simona = new Employee("Simona", 19, 650, "9612164221");
		Employee genadi = new Employee("Genadi", 32, 1800, "8301263560");
		Employee lili = new Employee("Liliya", 27, 1950, "8807192253");
		
		ArrayList<Employee> logistics = new ArrayList<Employee>();
		logistics.add(gosho);
		logistics.add(lili);
		logistics.add(tisho);
		
		ArrayList<Employee> sk = new ArrayList<Employee>();
		sk.add(tsanyo);
		sk.add(genadi);
		
		ArrayList<Employee> sales = new ArrayList<Employee>();
		sales.add(milena);
		sales.add(simona);
		
		tsak.getDepartmentList().put("Logistics ", logistics);
		tsak.getDepartmentList().put("Schetovodstvo i Kontrol ", sk);
		tsak.getDepartmentList().put("Sales ", sales);
		
		for (Map.Entry<String, ArrayList<Employee>> e : tsak.getDepartmentList().entrySet()) {
			System.out.println(e);
		}
		
		
		System.out.println("-----SORT BY SALARY-----");
		Collections.sort(sk, new SalaryComparator());
		Collections.sort(logistics, new SalaryComparator());
		Collections.sort(sales, new SalaryComparator());
		
		for (Map.Entry<String, ArrayList<Employee>> e : tsak.getDepartmentList().entrySet()) {
			System.out.println(e);
		}
		
		System.out.println("-----SORT BY NAME-----");
		Collections.sort(sk, new NameComparator());
		Collections.sort(logistics, new NameComparator());
		Collections.sort(sales, new NameComparator());
		
		for (Map.Entry<String, ArrayList<Employee>> e : tsak.getDepartmentList().entrySet()) {
			System.out.println(e);
		}
		
		System.out.println("-----SORT BY AGE-----");
		Collections.sort(sk, new AgeComparator());
		Collections.sort(logistics, new AgeComparator());
		Collections.sort(sales, new AgeComparator());
		
		for (Map.Entry<String, ArrayList<Employee>> e : tsak.getDepartmentList().entrySet()) {
			System.out.println(e);
		}
		
	}

}
