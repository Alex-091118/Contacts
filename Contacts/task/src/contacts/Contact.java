package contacts;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Contact {
    String name;
    String surname;
    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
//        Pattern pattern = Pattern.compile(
//                "([+]?\\(?(\\w+)\\)?[-\\s]?\\(?\\w{2,}\\)?[-\\s]?(\\w{2,}[-\\s]?)*)");
        Pattern pattern = Pattern.compile(
                "([+]?\\(?(\\w+)\\)?[-\\s]?\\w{2,}[-\\s]?(\\w{2,}[-\\s]?)*)" +
                        "|([+]?(\\w+)[-\\s]?\\(?\\w{2,}\\)?[-\\s]?(\\w{2,}[-\\s]?)*)" +
                        "|([+]?(\\w+)[-\\s]?\\w{2,}[-\\s]?(\\w{2,}[-\\s]?)*)");
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean check = matcher.matches();
        if (check) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format");
        }

    }

    public static void main(String[] args) {

    }
}