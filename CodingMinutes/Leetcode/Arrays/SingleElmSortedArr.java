package Leetcode.Arrays;

public class SingleElmSortedArr {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int elm = singleDuplicate(arr);
        System.out.println(elm);
    }

    private static int singleDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isEven = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
