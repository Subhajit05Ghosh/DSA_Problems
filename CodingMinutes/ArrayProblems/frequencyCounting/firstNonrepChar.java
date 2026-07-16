package ArrayProblems.in.frequencyCounting;

public class firstNonrepChar {
    public static void main(String[] args) {
        String str="eekksgforgeeks";
        Character ch=findNonrepChar(str);
        System.out.println("First nonRepeating character "+ch);
    }

    private static Character findNonrepChar(String str) {
        int[] freq=new int[26];
        for(char ch:str.toCharArray()){
            int index=ch -'a';
            freq[index]++;
        }
        for(char ch:str.toCharArray()) {
            if (freq[ch -'a']== 1) {
                return ch;
            }
        }
        return '\0';
    }
}
