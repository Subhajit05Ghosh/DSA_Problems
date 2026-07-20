package ArrayProblems.in.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {
    public static void main(String[] args) {
        int arr[] = {2,3,-5,5,-5,1,4};
        int k = 5;
        System.out.println(subarraySum(arr, k));
    }

    private static int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0,1);
        int result = 0;
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            if (sumCountMap.containsKey(prefixSum - k)) {
                result += sumCountMap.get(prefixSum - k);
            }
            sumCountMap.put(prefixSum, sumCountMap.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
