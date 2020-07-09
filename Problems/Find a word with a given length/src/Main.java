import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b[a-z]+\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean yes = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            int lengthWord = end - start;
            if (lengthWord == size) {
                System.out.println("YES");
                yes = true;
                break;
            }
        }
        if (!yes) {
            System.out.println("NO");
        }

    }
}