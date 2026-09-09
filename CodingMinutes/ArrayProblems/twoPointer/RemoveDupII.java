package ArrayProblems.in.twoPointer;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ LeetCode 80
import java.util.Arrays;

public class RemoveDupII {
    public static void main(String[] args) {
        int arr[]={1,1,1,2,2,3};
        String resArr=removeDuplicates(arr);
        System.out.println(resArr);
    }

    public static String removeDuplicates(int[] nums) {
        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (write < 2 || nums[read] != nums[write - 2]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return Arrays.toString(Arrays.copyOf(nums,write));
    }
}
