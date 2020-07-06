
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        System.out.println(password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}") ? "YES" : "NO");
    }
}