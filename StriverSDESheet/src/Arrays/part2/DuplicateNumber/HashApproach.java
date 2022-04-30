package Arrays.part2.DuplicateNumber;

import java.util.*;

public class HashApproach {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        int duplicate = duplicateNumber(nums);
        System.out.println(duplicate);
    }

    private static int duplicateNumber(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int num : nums) {
            if (hs.contains(num))
                return num;
            hs.add(num);
        }
        return -1;
    }
}
