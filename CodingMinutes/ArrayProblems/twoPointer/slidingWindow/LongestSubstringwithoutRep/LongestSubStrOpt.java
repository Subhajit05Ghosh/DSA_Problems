package ArrayProblems.in.twoPointer.slidingWindow.LongestSubstringwithoutRep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrOpt {
    public static void main(String[] args) {
        String str = "abcabcebb";
        int length = findLongestSubStr(str);
        String sub = findLongestSubString(str);
        System.out.println("Length of longest substring: " + sub + " without repeating characters: " + length);
    }

    private static int findLongestSubStr(String str) {
        int left = 0, right = 0;
        int maxLength = 0;
        int[] arr = new int[256];
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            int currentCharAscii = (int) currentChar;
            arr[currentCharAscii]++;
            while (arr[currentCharAscii] > 1) {
                char leftChar = str.charAt(left);
                int leftCharAscii = (int) leftChar;
                arr[leftCharAscii]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    private static String findLongestSubString(String str) {
        int left = 0, right = 0;
        int maxLength = 0;
        int startIndex = 0;
        int[] arr = new int[256];
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            int currentCharAscii = (int) currentChar;
            arr[currentCharAscii]++;
            while (arr[currentCharAscii] > 1) {
                char leftChar = str.charAt(left);
                int leftCharAscii = (int) leftChar;
                arr[leftCharAscii]--;
                left++;
            }
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = left;
            }
            right++;
        }
        return str.substring(startIndex, startIndex + maxLength);
    }
}
