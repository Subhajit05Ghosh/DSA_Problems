public class DigitProduct {
    public static void main(String[] args) {
        int fact = digitProd(143);
        System.out.println(fact);
    }

    private static int digitProd(int n) {
        if (n%10 == n) {
            return n;
        }
        return n%10 * digitProd(n/10);
    }
}
