package ArrayProblems.in.twoPointer;
//https://leetcode.com/problems/remove-element/ LeetCode 27
import java.util.Arrays;

public class RemoveElm {
    public static void main(String[] args) {
        int arr[]={4,42,3,4,4,4,5,7};
        System.out.println(removeElement(arr,4));
    }

    public static int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        System.out.println("The array::"+Arrays.toString(Arrays.copyOf(nums,i)));
        return i;
    }
}
