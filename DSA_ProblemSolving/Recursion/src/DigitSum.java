public class DigitSum {
    public static void main(String[] args) {
        int fact = digitSum(143);
        System.out.println(fact);
    }

    private static int digitSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n%10 + digitSum(n/10);
    }
}
