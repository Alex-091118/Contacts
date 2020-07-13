package contacts;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
	
	private String name;
	private String surname;
	private String phoneNumber;
	private Scanner scanner = new Scanner(System.in);
	
	public Contact() {
		
		setName();
		setSurname();
		setPhoneNumber();
		
		System.out.println("The record added.");
	}

	@Override
	public String toString() {
		return name + " " + surname + ", " + phoneNumber + "\n";
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName() {
		System.out.println("Enter the name of the person:");
		this.name = scanner.nextLine();
	}

	public void setSurname() {
		System.out.println("Enter the surname of the person:");
		this.surname = scanner.nextLine();
	}

	public void setPhoneNumber() {
		System.out.println("Enter the number:");
		String phoneNumber = scanner.nextLine();
		if (checkPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			this.phoneNumber = "[no number]";
		}
	}
	boolean hasNumber() {
		if ("[no number]".equals(phoneNumber)) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkPhoneNumber(String phoneNumber) {
//      Pattern pattern = Pattern.compile(
//      "([+]?\\(?(\\w+)\\)?[-\\s]?\\(?\\w{2,}\\)?[-\\s]?(\\w{2,}[-\\s]?)*)");
		Pattern pattern = Pattern.compile("([+]?(\\(\\w+\\)[-\\s]?)(\\w{2,}[-\\s]?)*)"
				+ "|([+]?(\\w+[-\\s])\\(\\w{2,}\\)[-\\s]?(\\w{2,}[-\\s]?)*)"
				+ "|([+]?(\\w)?[-\\s]?(\\w{2,}[-\\s]?)*)");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return true;
		} else {
			System.out.println("Wrong number format");
			return false;
		}
	}

}
