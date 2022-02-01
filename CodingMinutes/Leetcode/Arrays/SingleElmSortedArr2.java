package Leetcode.Arrays;

public class SingleElmSortedArr2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int elm = singleDuplicate(arr);
        System.out.println(elm);
    }

    private static int singleDuplicate(int[] arr) {
        int n = arr.length;
        int high = n - 1;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((mid % 2 == 0 && mid + 1 < n && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && mid - 1 >= 0 && arr[mid] == arr[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid;
            }
            if (mid + 1 < n && mid - 1 >= 0 && arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }
        }
        return arr[low];
    }
}
