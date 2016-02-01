//	The company has a name and a
//	collection of Employees separated in different
//	departments.

package Work;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	
	private String companyName;
	private HashMap<String, ArrayList<Employee>> departmentList;
	
	// constructor
	public Company(String companyName) {
		setCompanyName(companyName);
		this.departmentList = new HashMap<String, ArrayList<Employee>>();
	}
	
	// methods
	
	
	// getters and setters
	protected String getCompanyName() {
		return companyName;
	}

	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public HashMap<String, ArrayList<Employee>> getDepartmentList() {
		return departmentList;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + "]";
	}

}
