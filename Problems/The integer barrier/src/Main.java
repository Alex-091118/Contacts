import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int sum = 0;
        while (true) {
            num = scanner.nextInt();
            sum +=num;
            if (sum >= 1000) {
                System.out.println(sum - 1000);
                break;
            }
            if (num == 0) {
                System.out.println(sum);
                break;
            }
        }
    }
}