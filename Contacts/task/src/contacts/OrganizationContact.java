package contacts;


public class OrganizationContact extends Contact {

	String nameOfOrganization; 
	String address;
	
	public OrganizationContact() {
		super();
		setNameOfOrganization();
		setAddress();
		setPhoneNumber();
		type = Type.ORGANIZATION;
	}
	
	public String getNameOfOrganization() {
		return nameOfOrganization;
	}

	public String getAddress() {
		return address;
	}

	public void setNameOfOrganization() {
		System.out.println("Enter the organization name:");
		this.nameOfOrganization = scanner.nextLine();
	}

	public void setAddress() {
		System.out.println("Enter the address:");
		this.address = scanner.nextLine();
	}

	@Override
	public String toString() {
		return nameOfOrganization;
	}
	
	String info() {
		String info = "Organization name: " + nameOfOrganization + "\n"
				+ "Address: " + address + "\n" + 
				super.info();
		return info;
	}
	
}
