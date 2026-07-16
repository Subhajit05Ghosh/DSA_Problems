package ArrayProblems.in.twoPointer;

import java.util.Arrays;

//nikhilLohia
public class moveZeroes {
    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 4, 0, 5, 6};
        int[] arrLen = moveZeroVals(arr);
        System.out.println(Arrays.toString(arrLen));
    }

    private static int[] moveZeroVals(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                arr[i] = arr[j];
                i++;
            }
        }
        while (i < arr.length) {
            arr[i++] = 0;
        }

        return arr;
    }
}
