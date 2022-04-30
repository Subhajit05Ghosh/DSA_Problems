package arrayMisc;

import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
    //    int[] arr = {0, 1, 2, 4, 5, 6};
        int[] arr = {0, 1};
        int ans = missingNumber(arr);
        System.out.println(ans);
        int misNum = numberMissing(arr);
        System.out.println(misNum);
    }

    private static int numberMissing(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != i) {
                return i;
            }
        }
        return n;
    }

    private static int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
        }
        return sum - arrSum;
    }
}

