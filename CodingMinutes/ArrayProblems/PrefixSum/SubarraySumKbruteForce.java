package ArrayProblems.in.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumKbruteForce {
    public static void main(String[] args) {
        int arr[] = {2,3,-5,5,-5,1,4};
        int k = 5;
        System.out.println(subarraySum(arr, k));
    }

    private static int subarraySum(int[] arr, int k) {
        int count=0;
        for (int i=0;i<arr.length;i++){
            int sum=0;
            for (int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
