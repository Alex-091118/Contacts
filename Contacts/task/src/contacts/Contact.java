package contacts;

import java.util.Scanner;

class Contact {
    String name;
    String surname;
    String phoneNumber;

    public Contact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        this.name = scanner.nextLine();
        System.out.println("Enter the surname of the person:");
        this.surname = scanner.nextLine();
        System.out.println("Enter the number:");
        this.phoneNumber = scanner.nextLine();
        System.out.println();
        System.out.println("A record created!\n" +
                "A Phone Book with a single record created!");
    }
}
