package arrayMisc;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LengthofLongestSubstring {
    public static void main(String[] args) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str));
    }

    private static int solve(String str) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;
        LinkedHashSet<Character> hs = new LinkedHashSet<>();
        while (b_pointer < str.length()) {
            if (!hs.contains(str.charAt(b_pointer))) {
                hs.add(str.charAt(b_pointer));
                b_pointer++;
                max = Math.max(hs.size(), max);
            } else {
                hs.remove(str.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }
}
