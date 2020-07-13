package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
	
	private List<Contact> phoneBook = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	
	void phoneBookAction() {
		boolean work = true;
		while(work) {
		System.out.println("Enter action (add, remove, edit, count, list, exit):");
		String action = scanner.nextLine();
		switch(action) {
		case "add":
			phoneBook.add(new Contact());
			break;
		case "remove":
			removeContact();
			break;
		case "edit":
			editContact();
			break;
		case "count":
			System.out.println("The Phone Book has " + phoneBook.size() + " records");
			break;
		case "list":
			if (phoneBook.isEmpty()) {
				System.out.println("List is empty");
			} else {
			System.out.println(toString());
			}
			break;
		case "exit":
			work = false;
			break;
		default:
			System.out.println("Wrong input");
			break;
			}
		}
	}
	
	void removeContact() {
		if (phoneBook.isEmpty()) {
			System.out.println("No records to remove!");
		} else {
			System.out.println(toString());
			System.out.println("Select a record:");
			int select = Integer.parseInt(scanner.nextLine());
			if (select > phoneBook.size()) {
				System.out.println("The record doesn't exist");
			} else {
			phoneBook.remove(select - 1);
			System.out.println("The record removed!");
			}
		}
	}
	
	void editContact() {
		if (phoneBook.isEmpty()) {
			System.out.println("No records to edit!");
		} else {
			System.out.println(toString());
			System.out.println("Select a record:");
			int select = Integer.parseInt(scanner.nextLine());
			if (select > phoneBook.size()) {
				System.out.println("The record doesn't exist");
			} else {
			Contact selectedContact = phoneBook.get(select - 1);
			System.out.println("Select a field (name, surname, number):");
			
			String field = scanner.nextLine();
			switch(field) {
			case "name":
				selectedContact.setName();
				System.out.println("The record updated!");
				break;
			case "surname":
				selectedContact.setSurname();
				System.out.println("The record updated!");
				break;
			case "number":
				selectedContact.setPhoneNumber();
				System.out.println("The record updated!");
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
			
			}
		}
	}
	
	
	@Override
	public String toString() {
		String result = "";
		for (Contact x : phoneBook) {
			result += phoneBook.indexOf(x) + 1 + ". " + x.toString();
		}
		return result;
	}

}
