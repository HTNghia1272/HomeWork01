package JavaFresher01;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentManage {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so phong ban: ");
		int numDepartment = sc.nextInt();
		Department[] departments = new Department[numDepartment];

		for (int i = 0; i < departments.length; i++) {
			System.out.println("Ten phong ban thu " + (i + 1) + ": ");
			String departmentName = sc.next();
			departments[i] = new Department(departmentName, new ArrayList<Employee>());

			System.out.println("Nhap so luong nhan vien: ");
			int numEmployees = sc.nextInt();

			for (int j = 0; j < numEmployees; j++) {
				System.out.println("Chon nhap nhan vien Full time - Part time, 1 full time - 2 part time: ");
				int choose = sc.nextInt();

				Employee employee;

				if (choose == 1) {
					employee = new SalariedEmployee();
				} else if (choose == 2) {
					employee = new HourlyEmployee();
				} else {
					System.out.println("Lua chon khong hop le!");
					j--;
					continue;
				}

				employee.input();
				addEmployeeToDepartment(departments[i], employee);
				System.out.println(employee.toString());
			}
			System.out.print("Nhap ten nhan vien muon tim: ");
			String searchName = sc.next();
			searchEmployeeByName(departments[i], searchName);
		}
		System.out.println("Danh sach phong ban:");
		for (Department department : departments) {
			displayDepartmentInfo(department);
		}

		System.out.print("Nhap ten phong ban de tim danh sach nhan vien: ");
		String searchDepartmentName = sc.next();
		searchAndDisplayEmployeesByDepartmentName(departments, searchDepartmentName);
	}

	private static void addEmployeeToDepartment(Department department, Employee employee) {
		List<Employee> listOfEmployee = department.getListOfEmployee();
		listOfEmployee.add(employee);
		department.setListOfEmployee(listOfEmployee);
		System.out.println("Thong tin nhan vien da duoc nhap!");
	}

	private static void searchEmployeeByName(Department department, String name) {
		List<Employee> listOfEmployee = department.getListOfEmployee();

		System.out.println("Ket qua tim kiem '" + name + "':");
		boolean found = false;

		for (Employee employee : listOfEmployee) {
			if (employee.getFirstName().equalsIgnoreCase(name) || employee.getLastName().equalsIgnoreCase(name)) {
				System.out.println(employee.toString());
				System.out.println();
				found = true;
			}
		}

		if (!found) {
			System.out.println("Khong tim thay nhan vien ten '" + name + "'.");
			System.out.println("---");
		}
	}

	private static void displayDepartmentInfo(Department department) {
		System.out.println("Ten phong ban: " + department.getDepartmentName());
		System.out.println("So luong nhan vien: " + department.getListOfEmployee().size());
		System.out.println("---");
	}

	private static void searchAndDisplayEmployeesByDepartmentName(Department[] departments, String departmentName) {
		boolean found = false;

		for (Department department : departments) {
			if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {
				found = true;
				System.out.println("Nhan vien trong phong ban: " + departmentName);
				List<Employee> employees = department.getListOfEmployee();
				for (Employee employee : employees) {
					System.out.println("Thong tin nhan vien:");
					System.out.println(employee.toString());
				}
				break;
			}
		}

		if (!found) {
			System.out.println("Khong tim thay phong ban: " + departmentName);
		}
	}
}