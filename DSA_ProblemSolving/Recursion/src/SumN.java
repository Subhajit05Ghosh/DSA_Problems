public class SumN {
    public static void main(String[] args) {
        int fact = sum(5);
        System.out.println(fact);
    }

    private static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
