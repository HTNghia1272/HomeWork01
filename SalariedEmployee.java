package JavaFresher01;

public class SalariedEmployee extends Employee {
	private double commissionRate, grossSales, basicSalary;

	public SalariedEmployee() {
		super();
	}

	public SalariedEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email,
			double commissionRate, double grossSales, double basicSalary) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	@Override
	public void input() {
		super.input();
		System.out.print("Basic Salary: ");
		basicSalary = sc.nextDouble();
		System.out.print("Commission Rate: ");
		commissionRate = sc.nextDouble();
		System.out.print("Gross Sales: ");
		grossSales = sc.nextDouble();
		System.out.println("---");
	}

	@Override
	public double getPaymentAmount() {
		return getBasicSalary() + getGrossSales() * getCommissionRate() / 100;
	}

	@Override
	public String toString() {
		return super.toString() + "\nBasic Salary: " + getBasicSalary() + "\nGross Sale: " + getGrossSales() + "\nCommission Rate: "
				+ getCommissionRate() + "\nTotal Salary: " + getPaymentAmount() + "\n---";
	}

}