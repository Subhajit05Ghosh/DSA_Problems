package ArrayProblems.in.twoPointer.Pairs;

import java.util.Arrays;

public class Pairs2Pointer {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 3, -6, 9, 11};
        int target = 4;
        int result[] = reqPairs(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }

    static int[] reqPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (target == sum) {
                return new int[]{arr[start], arr[end]};
            } else if (target < sum) {
                end--;
            } else {
                start++;
            }
        }

        return new int[]{-1, -1};
    }
}
