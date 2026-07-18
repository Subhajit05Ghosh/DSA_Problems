package ArrayProblems.in.twoPointer.slidingWindow.LongestSubstringwithoutRep;

import java.util.Arrays;

public class LongestSubstrArr {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = findLongestSubStr(str);
        String res=findLongestSubString(str);
        System.out.println("Length of longest substring: "+res+" without repeating characters: " + length);
    }

    private static int findLongestSubStr(String str) {
        int left = 0;
        int maxLength = 0;
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            left = Math.max(left, lastSeen[ch] + 1);
            lastSeen[ch] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    private static String findLongestSubString(String str) {
        int left = 0;
        int maxLength = 0;
        int startIndex=0;
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            left = Math.max(left, lastSeen[ch] + 1);
            lastSeen[ch] = right;
            int currentLength=right - left + 1;
            if(currentLength>maxLength){
                maxLength=currentLength;
                startIndex=left;
            }
        }
        return str.substring(startIndex,startIndex+maxLength);
    }
}
