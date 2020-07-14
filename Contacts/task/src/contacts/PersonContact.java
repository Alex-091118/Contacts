package contacts;

public class PersonContact extends Contact {
	
	private String name;
	private String surname;
	private String birthDate;
	private String gender;
	
		
	PersonContact() {
		super();
		setName();
		setSurname();
		setBirthDate();
		setGender();
		setPhoneNumber();
		isPerson = true;
		type = Type.PERSON;
	}
		
	public void setName() {
		System.out.println("Enter the name of the person:");
		this.name = scanner.nextLine();
	}

	public void setSurname() {
		System.out.println("Enter the surname of the person:");
		this.surname = scanner.nextLine();
	}

	public void setBirthDate() {
		System.out.println("Enter th birth date:");
		String birthDate = scanner.nextLine();
		if (birthDate.matches("(0[1-9]|[1-2][0-9]|3[01])[.\\-/\\s](0[1-9]|1[0-2])[.\\-/\\s]\\d{2,4}")) {
		this.birthDate = birthDate;
		} else {
			this.birthDate = "[no data]";
			System.out.println("Bad birth date!");
		}
	}

	public void setGender() {
		System.out.println("Enter the gender (M, F):");
		String gender = scanner.nextLine();
		switch(gender.toUpperCase()) {
		case "M":
			this.gender = "Male";
			break;
		case "F":
			this.gender = "Female";
			break;
		default:
			this.gender = "[no data]";
			System.out.println("Bad gender!");
		}
	}
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	public String getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

	String info() {
		String info = "Name: " + name + "\n" + "Surname: " + surname + "\n" + 
						"Birth date: " + birthDate + "\n" + "Gender: " + gender + "\n" +
						super.info();
		return info;
	}
	
}
