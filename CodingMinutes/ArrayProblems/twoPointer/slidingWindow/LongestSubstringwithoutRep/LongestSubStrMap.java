package ArrayProblems.in.twoPointer.slidingWindow.LongestSubstringwithoutRep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrMap {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = findLongestSubStr(str);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }

    private static int findLongestSubStr(String str) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> strElm = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            if (strElm.containsKey(str.charAt(right))) {
                left = Math.max(left, strElm.get(str.charAt(right)) + 1);
            }
            strElm.put(str.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
