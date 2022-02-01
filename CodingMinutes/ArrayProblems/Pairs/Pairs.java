package ArrayProblems.in.Pairs;

import java.util.HashMap;

public class Pairs {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 3, -6, 9, 11};
        int sum = 4;
        int result[] = reqPairs(arr, sum);
        System.out.println(result[0] + " " + result[1]);
    }

    static int[] reqPairs(int[] arr, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            target = sum - arr[i];
            if (hm.containsKey(target)) {
                return new int[]{arr[i], target};
            } else {
                hm.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
