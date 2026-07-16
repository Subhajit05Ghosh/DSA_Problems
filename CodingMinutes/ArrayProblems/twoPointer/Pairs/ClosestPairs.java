package ArrayProblems.in.twoPointer.Pairs;

import java.util.Arrays;

public class ClosestPairs {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 3, -6, 9, 11};
        int target = 6;
        int result[] = reqPairs(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }


    static int[] reqPairs(int[] arr, int target) {

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        int bestFirst = arr[start];
        int bestSecond = arr[end];
        int closestDiff = Integer.MAX_VALUE;

        while (start < end) {

            int sum = arr[start] + arr[end];
            int currentDiff = Math.abs(target - sum);

            if (currentDiff < closestDiff) {
                closestDiff = currentDiff;
                bestFirst = arr[start];
                bestSecond = arr[end];
            }

            if (sum == target) {
                return new int[]{arr[start], arr[end]};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return new int[]{bestFirst, bestSecond};
    }

    static int[] reqPairs1(int[] arr, int target) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int num1=arr[start];
        int num2=arr[end];
        int diff=Math.abs(target-(arr[start]+arr[end]));
        while (start < end) {
            int sum = arr[start] + arr[end];
            int minDiff=Math.abs(target-(arr[start]+arr[end]));
            if (minDiff<diff) {
                diff=minDiff;
                num1=arr[start];
                num2=arr[end];
            }  if (target < sum) {
                end--;
            } else {
                start++;
            }
        }

        return new int[]{num1,num2};
    }
}
