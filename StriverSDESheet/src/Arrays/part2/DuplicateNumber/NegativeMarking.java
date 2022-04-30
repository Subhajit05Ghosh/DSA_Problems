package Arrays.part2.DuplicateNumber;

import java.util.Arrays;

public class NegativeMarking {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 5};
        int duplicate = duplicateNumber(nums);
        System.out.println(duplicate);
    }

    private static int duplicateNumber(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }

        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
}
