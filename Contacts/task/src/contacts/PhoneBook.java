package contacts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

	private List<Contact> phoneBook = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	void phoneBookAction() {
		boolean work = true;
		while (work) {
			System.out.println("Enter action (add, remove, edit, count, info, list, exit):");
			String action = scanner.nextLine();
			switch (action) {
			case "add":
				addContact();
				break;
			case "remove":
				removeContact();
				break;
			case "edit":
				editContact();
				break;
			case "count":
				System.out.println("The Phone Book has " + phoneBook.size() + " records\n");
				break;
			case "info":
				infoContact();
				break;
			case "list":
				if (phoneBook.isEmpty()) {
					System.out.println("List is empty\n");
				} else {
					System.out.println(toString());
				}
				break;
			case "exit":
				work = false;
				break;
			default:
				System.out.println("Wrong input\n");
				break;
			}
		}
	}

	void addContact() {
		System.out.println("Enter the type (person, organization):");
		String type = scanner.nextLine();
		boolean added = true;
		switch (type) {
		case "person": 
			phoneBook.add(new PersonContact());
			break;
		case "organization":
			phoneBook.add(new OrganizationContact());
			break;
		default:
			added = false;
			break;
		}
		if(added) {
			System.out.println("The record added.\n");
		} else {
			System.out.println("Wrong type! The record hasn't added\n");
		}
	}

	void removeContact() {
		if (phoneBook.isEmpty()) {
			System.out.println("No records to remove!\n");
		} else {
			System.out.println(toString());
			System.out.println("Select a record:");
			int select = Integer.parseInt(scanner.nextLine());
			if (select > phoneBook.size()) {
				System.out.println("The record doesn't exist\n");
			} else {
				phoneBook.remove(select - 1);
				System.out.println("The record removed!\n");
			}
		}
	}

	void editContact() {
		if (phoneBook.isEmpty()) {
			System.out.println("No records to edit!\n");
		} else {
			System.out.print(toString());
			System.out.print("Select a record:");
			int select = Integer.parseInt(scanner.nextLine());
			if (select > phoneBook.size()) {
				System.out.println("The record doesn't exist\n");
			} else {
				Contact selectedContact = phoneBook.get(select - 1);
				if (selectedContact.type == Type.PERSON) {
					editPersonContact((PersonContact) selectedContact);
				} else if (selectedContact.type == Type.ORGANIZATION) {
					editOrganizationContact((OrganizationContact) selectedContact);
				} else {
					System.out.println("Unknown type of contact\n");
				}

			}
		}
	}

	private void editOrganizationContact(OrganizationContact contact) {
		System.out.println("Select a field (name, address, number):");
		String field = scanner.nextLine();
		boolean updated = true;
		switch (field) {
		case "name":
			contact.setNameOfOrganization();
			break;
		case "address":
			contact.setAddress();
			break;
		case "number":
			contact.setPhoneNumber();
			break;
		default:
			updated = false;
			break;
		}
		if (updated) {
			contact.timeLastEdit = LocalDateTime.now();
			System.out.println("The record updated!\n");
		} else {
			System.out.println("Wrong input. The record hasn't updated!\n");
		}
	}

	void editPersonContact(PersonContact contact) {
		System.out.println("Select a field (name, surname, birth, gender, number):");
		String field = scanner.nextLine();
		boolean updated = true;
		switch (field) {
		case "name":
			contact.setName();
			break;
		case "surname":
			contact.setSurname();
			break;
		case "birth":
			contact.setBirthDate();
			break;
		case "gender":
			contact.setGender();
			break;
		case "number":
			contact.setPhoneNumber();
			break;
		default:
			updated = false;
			break;
		}
		if (updated) {
			contact.timeLastEdit = LocalDateTime.now();
			System.out.println("The record updated!\n");
		} else {
			System.out.println("Wrong input. The record hasn't updated!\n");
		}
	}

	private void infoContact() {
		if (phoneBook.isEmpty()) {
			System.out.println("No records to info!\n");
		} else {
			System.out.print(toString());
			System.out.print("Enter index to show info:");
			int select = Integer.parseInt(scanner.nextLine());
			if (select == 0) {
				infoAtAll();
				return;
			}
			if (select > phoneBook.size()) {
				System.out.println("The record doesn't exist\n");
			} else {
				System.out.println(phoneBook.get(select - 1).info());
			}
		}		
	}
	
	private void infoAtAll() {
		for(Contact contact : phoneBook) {
			System.out.println("\n\t" + contact.toString() + "\n" + contact.info() + 
					"\n- - - - - - - - - - - - - - - - - - - -");
					
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Contact x : phoneBook) {
			result.append(phoneBook.indexOf(x) + 1).append(". ").append(x.toString()).append("\n");
		}
		return result.toString();
	}

}
