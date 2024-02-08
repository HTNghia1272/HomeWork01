package JavaFresher01;

public class HourlyEmployee extends Employee {
	private double wage, workingHours;

	public HourlyEmployee() {
		super();
	}

	public HourlyEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email,
			double wage, double workingHours) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		this.wage = wage;
		this.workingHours = workingHours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public void input() {
		super.input();
		System.out.print("Wage: ");
		wage = sc.nextDouble();
		System.out.print("Working Hours: ");
		workingHours = sc.nextDouble();
		System.out.println("---");
	}

	@Override
	public double getPaymentAmount() {
		return getWage() * getWorkingHours();
	}

	@Override
	public String toString() {
		return super.toString() + "\nWage: " + wage + "\nWorking Hours: " + workingHours + "\nTotal Salary: " + getPaymentAmount() + "\n---";
	}

}