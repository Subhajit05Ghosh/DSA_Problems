package ArrayProblems.in.frequencyCounting;

public class firstRepChar {
    public static void main(String[] args) {
        String str="geeksforgeeks";
        Character ch=findNonrepChar(str);
        System.out.println("First Repeating character "+ch);
    }

    private static Character findNonrepChar(String str) {
        int[] freq=new int[26];
        for(char ch:str.toCharArray()){
            int index=ch -'a';
            freq[index]++;
            if(freq[index]>1){
                return ch;
            }

        }
        return '\0';
    }
}
