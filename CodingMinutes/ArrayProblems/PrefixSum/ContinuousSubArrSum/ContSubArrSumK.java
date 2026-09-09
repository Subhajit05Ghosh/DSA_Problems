package ArrayProblems.in.PrefixSum.ContinuousSubArrSum;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/continuous-subarray-sum/description/?envType=problem-list-v2&envId=prefix-sum LeetCode:523bg
public class ContSubArrSumK {
    public static void main(String[] args) {
        int arr[] = {32,2,4,6,7};
        int k = 6;
        System.out.println(contSubarraySumK(arr, k));
    }

    private static boolean contSubarraySumK(int[] arr, int k) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        int prefixSum = 0;
        sumCountMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int rem = prefixSum % k;
            if (sumCountMap.containsKey(rem)) {
                if((i - sumCountMap.get(rem) >= 2))
                return true;
            } else {
                sumCountMap.put(rem, i);
            }
        }
        return false;
    }
}

