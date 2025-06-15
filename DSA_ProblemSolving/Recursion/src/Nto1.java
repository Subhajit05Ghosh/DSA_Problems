public class Nto1 {
    public static void main(String[] args) {
        fun(5);
        System.out.println("--------------");
        funRev(5);
    }

    private static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun(n - 1);
    }

    private static void funRev(int n) {
        if (n == 0) {
            return;
        }
        funRev(n - 1);
        System.out.println(n);
    }
}
