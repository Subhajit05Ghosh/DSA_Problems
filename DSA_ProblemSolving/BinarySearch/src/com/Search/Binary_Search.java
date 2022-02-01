package com.Search;

import java.util.Scanner;

public class Binary_Search {

	public static void main(String[] args) {
		int[] arr = { 4, 8, 22, 34, 44, 51, 63, 78, 90, 100 };
		System.out.println("Enter the number you want to search");
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		sc.close();
		int r = binarySearch(arr, inp);
		if (r == -1) {
			System.out.println(inp + " is not present in the array");
		} else {
			System.out.println("The searched number is at " + r + " position in the array");
		}
	}

	static int binarySearch(int[] arr, int inp) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (inp > arr[mid])
				start = mid + 1;
			else if (inp < arr[mid])
				end = mid - 1;
			else
				return mid;
		}
		return -1;
	}
}
