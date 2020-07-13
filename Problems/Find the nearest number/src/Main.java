import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = new ArrayList<>();
        String[] ls = scanner.nextLine().split("\\s+");
        for (String s : ls) {
            list1.add(Integer.parseInt(s));
        }
        list1.sort(Integer::compareTo);
        int n = scanner.nextInt();
        boolean equals = false;
        for (Integer x : list1) {
            if (x.equals(n)) {
                System.out.print(x + " ");
                equals = true;
            }
        }
        if (!equals) {
            if (n < list1.get(0)) {
                for (Integer x : list1) {
                    if (x.equals(list1.get(0))) {
                        System.out.print(x + " ");
                    }
                }
            } else if (n > list1.get(list1.size() - 1)) {
                for (Integer x : list1) {
                    if (x.equals(list1.get(list1.size() - 1))) {
                        System.out.print(x + " ");
                    }
                }
            } else {
                for (Integer x : list1) {
                    if (x == n - 1 || x == n + 1) {
                        System.out.print(x + " ");
                    }
                }
            }
        }

    }
}