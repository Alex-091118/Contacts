package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

	protected Scanner scanner = new Scanner(System.in);
	private String phoneNumber;
	Type type;
	boolean isPerson;
	LocalDateTime timeCreated;
	LocalDateTime timeLastEdit;

	public Contact() {
		timeCreated = LocalDateTime.now();
		timeLastEdit = timeCreated;
	}

	String info() {
		String info = "Number: " + phoneNumber + "\n" + "Time created: " + timeCreated + "\n" + "Time last edit: "
				+ timeLastEdit + "\n";
		return info;
	}

	public String getPhoneNumber() {

		return phoneNumber;
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
		Pattern pattern = Pattern.compile("([+]?(\\(\\w+\\)[-\\s]?)(\\w{2,}[-\\s]?)*)"
				+ "|([+]?(\\w+[-\\s])\\(\\w{2,}\\)[-\\s]?(\\w{2,}[-\\s]?)*)" + "|([+]?(\\w)?[-\\s]?(\\w{2,}[-\\s]?)*)");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return true;
		} else {
			System.out.println("Wrong number format");
			return false;
		}
	}

}
