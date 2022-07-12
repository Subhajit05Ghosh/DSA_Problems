package arrayMisc;

public class SingleDigProduct {

    static int digSum(int n) {
        int product = 0;

        // Loop to do product while
        // product is not less than
        // or equal to 9
        while (n > 0 || product > 9) {
            if (n == 0) {
                n = product;
                product = 0;
            }
            if(product==0){
                product=n%10;
            }else {
                product *= n % 10;
            }
            n /= 10;
        }
        return product;
    }

    public static void main(String argc[]) {
        int n = 47;
        System.out.println(digSum(n));
    }
}