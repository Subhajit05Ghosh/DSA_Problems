package Arrays.part2.DuplicateNumber;

//Rotate slow pointer by one step and fast pointer by two steps.After their meeting point need to place the
//fast pointer in first element of array, then need to move both pointers by one step.Meeting point is answer
public class TortoiseMethod {
    public static void main(String args[]) {
        int arr[] = {1, 3, 4, 2, 3};
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}