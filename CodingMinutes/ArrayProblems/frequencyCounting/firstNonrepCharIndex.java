package ArrayProblems.in.frequencyCounting;
//https://leetcode.com/problems/first-unique-character-in-a-string/ LeetCode 387
public class firstNonrepCharIndex {
    public static void main(String[] args) {
        String str="eekksgforgeeks";
        int index=findNonrepChar(str);
        System.out.println("First nonRepeating character "+index);
    }

    private static int findNonrepChar(String str) {
        int[] freq=new int[26];
        for(char ch:str.toCharArray()){
            int index=ch -'a';
            freq[index]++;
        }
        for(int i=0;i<str.length();i++) {
            if (freq[str.charAt(i) -'a']== 1) {
                return i;
            }
        }
        return -1;
    }
}
