package MaxSumSubarr.SizeK;

public class BruteForce {
	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		System.out.println(maxSum(arr, k));
	}

	private static int maxSum(int[] arr, int k) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - (k - 1); i++) {
			int currentSum = 0;
			for (int j = 0; j < k; j++) {
				currentSum += arr[i+j];
				maxSum = Math.max(maxSum, currentSum);
			}
		}
		return maxSum;
	}
}
