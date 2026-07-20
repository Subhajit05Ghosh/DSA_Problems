package ArrayProblems.in.PrefixSum;

public class SubarraySumKPositive {
    public static void main(String[] args) {
        int arr[] = {9,4,20,3,10,5};
        int k = 33;
        System.out.println(subarraySum(arr, k));
    }

    private static int subarraySum(int[] arr, int k) {
        int count=0;
        int sum=0;
        int left=0;
        for (int right=0;right<arr.length;right++){
            sum+=arr[right];
            while (sum>k){
                sum-=arr[left];
            }
            if(sum==k){
                count++;
            }
        }
        return count;
    }
}
