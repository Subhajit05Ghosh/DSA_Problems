package ArrayProblems.in.twoPointer.slidingWindow.LongestSubstringwithoutRep;

import java.util.HashSet;

public class LongestSubStr {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = findLongestSubStr(str);
        String res=findLongestSubString(str);
        System.out.println("Length of longest substring:"+res+" without repeating characters: " + length);
    }

    private static int findLongestSubStr(String str) {
        int left=0;
        int maxLength=0;
        HashSet<Character> strElm=new HashSet<>();
        for (int right=0;right<str.length();right++){
            while (strElm.contains(str.charAt(right))){
                strElm.remove(str.charAt(left));
                left++;
            }
          strElm.add(str.charAt(right));
          maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

    private static String findLongestSubString(String str) {
        int left=0;
        int maxLength=0;
        int startIndex=0;
        HashSet<Character> strElm=new HashSet<>();
        for (int right=0;right<str.length();right++){
            while (strElm.contains(str.charAt(right))){
                strElm.remove(str.charAt(left));
                left++;
            }
            strElm.add(str.charAt(right));
            int currentLength=right-left+1;
            if(currentLength>maxLength){
                maxLength=currentLength;
                startIndex=left;
            }
        }
        return str.substring(startIndex,startIndex+maxLength);
    }
}
