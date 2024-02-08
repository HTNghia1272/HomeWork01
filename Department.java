package JavaFresher01;

import java.util.List;

public class Department {
	private String departmentName;
	private List<Employee> listOfEmployee;

	public Department(String departmentName, List<Employee> listOfEmployee) {
		this.departmentName = departmentName;
		this.listOfEmployee = listOfEmployee;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public void display() {
		System.out.println("Department Name: " + getDepartmentName());
		System.out.println("List of employee: " + getListOfEmployee());
	}
}