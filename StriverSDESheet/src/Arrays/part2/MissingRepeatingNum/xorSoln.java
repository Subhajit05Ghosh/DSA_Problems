package Arrays.part2.MissingRepeatingNum;

public class xorSoln {
    public static void main(String[] args) {
        int arr[] = {7, 3, 4, 5, 5, 6, 2};
        int n = arr.length;
        missingRepeat(arr, n);
    }

    private static void missingRepeat(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        for (int i = 0; i < n; i++) {
            xor ^= i;
        }
        int rsb = xor & -xor;
        int x = 0;
        int y = 0;
        for (int val : arr) {
            if ((rsb & val) == 0)
                x = x ^ val;
            else y = y ^ val;
        }
        for (int i = 0; i < n; i++) {
            if ((rsb & i) == 0)
                x = x ^ i;
            else y = y ^ i;
        }

        for (int val : arr) {
            if (val == x) {
                x = x ^ val;
                System.out.println("Missing number -> " + y);
                System.out.println("Repeating number -> " + x);
                break;
            }
            else if (val == y){
                System.out.println("Missing number -> " + x);
                System.out.println("Repeating number -> " + y);
                break;
            }

        }
    }

}
