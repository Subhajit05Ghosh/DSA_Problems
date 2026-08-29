package ArrayProblems.in.PrefixSum.LongestSubArrSumK;

import java.util.HashMap;
import java.util.Map;

public class LongSubArrSumK {
    public static void main(String[] args) {
        int arr[] = {2,3,-5,5,-5,1,4};
        int k = 5;
        System.out.println(longestSubarraySum(arr, k));
    }

    private static int longestSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        int result=0;
        int prefixSum=0;
        sumCountMap.put(0,-1);
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(sumCountMap.containsKey(prefixSum-k)){
                result=Math.max(result,i-sumCountMap.get(prefixSum-k));
            }
            if(!sumCountMap.containsKey(prefixSum)){
              sumCountMap.put(prefixSum,i);
            }
        }
        return result;
    }
}
