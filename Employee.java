package JavaFresher01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements Payable {
	private static String ssn;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phone;
	private String email;
	Scanner sc = new Scanner(System.in);

	public Employee() {

	}

	public Employee(String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
	}

	// ssn
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// first name
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// last name
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// birth date
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
		dFormat.setLenient(false);
		try {
			dFormat.parse(birthDate);
			this.birthDate = birthDate;
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date. Date format dd/MM/yyyy");
		}
	}

	// phone
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		try {
			if (phone.matches("\\d{7,}")) {
				this.phone = phone;
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid phone number. Phone number has atleast 7 integer number.");
		}
	}

	// email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		try {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				this.email = email;
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid email. Email format abc123@abc.com");
		}
	}

	@Override
	public String toString() {
		return "SSN: " + ssn + "\nHo va ten: " + firstName + " " + lastName + "\nPhone: " + phone + "\nEmail: " + email
				+ "\nBirth: " + birthDate;
	}

	public void input() {
		System.out.print("SSN: ");
		setSsn(sc.next());
		System.out.print("First Name: ");
		setFirstName(sc.next());
		System.out.print("Last Name: ");
		setLastName(sc.next());
		System.out.print("Birth Date (dd/MM/yyyy): ");
		setBirthDate(sc.next());
		System.out.print("Phone: ");
		setPhone(sc.next());
		System.out.print("Email: ");
		setEmail(sc.next());
	}

	public void display() {
		System.out.println("SSN: " + ssn);
		System.out.println("Full name: " + firstName + " " + lastName);
		System.out.println("Phone: " + phone);
		System.out.println("Email: " + email);
		System.out.println("Birth date: " + birthDate);
	}

}