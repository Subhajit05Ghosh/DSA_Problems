package arrayMisc;

public class SingleDigSum {

    static int digSum(int n) {
        int sum = 0;

        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while (n > 0 || sum > 9) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String argc[]) {
        int n = 1234;
        System.out.println(digSum(n));
    }
}