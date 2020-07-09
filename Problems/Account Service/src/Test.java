public class Test {
    static int count() {
        int[] arr = {1, 2, 3, 1, 5, 6};
        for (int x : arr) {
            if (x == 8) {
                return 55;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Test.count());
    }
}
