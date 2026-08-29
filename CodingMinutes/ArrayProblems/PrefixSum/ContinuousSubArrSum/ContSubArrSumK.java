package ArrayProblems.in.PrefixSum.ContinuousSubArrSum;

import java.util.HashMap;
import java.util.Map;

public class ContSubArrSumK {
    public static void main(String[] args) {
        int arr[] = {32,2,4,6,7};
        int k = 6;
        System.out.println(contSubarraySumK(arr, k));
    }

    private static boolean contSubarraySumK(int[] arr, int k) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        sumCountMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int rem = prefixSum % k;
            if (sumCountMap.containsKey(rem) && (i - sumCountMap.get(rem) >= 2)) {
                return true;
            } else {
                sumCountMap.put(rem, i);
            }
        }
        return false;
    }
}

