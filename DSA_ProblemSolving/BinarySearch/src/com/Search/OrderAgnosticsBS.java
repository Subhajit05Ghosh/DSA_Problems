package com.Search;

public class OrderAgnosticsBS {

	public static void main(String[] args) {
		int[] arr = { 99, 80, 75, 22, 11, 10, 5, 2, -3 };
		// int[] arr = { 4, 8, 22, 34, 44, 51, 63, 78, 90, 100 };
		int target = 22;
		int ans = orderAgnosticsBS(arr, target);
		if (ans == -1) {
			System.out.println(ans + " is not present in the array");
		} else {
			System.out.println("The searched number is at " + ans + " position in the array");
		}
	}

	static int orderAgnosticsBS(int[] arr, int inp) {
		int start = 0;
		int end = arr.length - 1;
		// Find whether the array is ascending or descending
		boolean isAsc = arr[start] < arr[end];
		while (start <= end) {
			// int mid=(start+end)/2;//Might possible start+end exceeds the range of int in
			// Java
			int mid = start + (end - start) / 2;
			if (arr[mid] == inp) {
				return mid;
			}
			if (isAsc) {
				if (inp < arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (inp > arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
}
