package ArrayProblems.in.frequencyCounting;

public class firstRepChar {
    public static void main(String[] args) {
        String str = "gEEksforgEEks";
        Character ch = findRepChar(str);
        Character rep = findRepCharFirst(str);
        System.out.println("First Repeating character " + ch);
    }

    private static Character findRepChar(String str) {
        int[] freq = new int[128];
        for (char ch : str.toCharArray()) {
            int index = ch;
            freq[index]++;
            if (freq[index] > 1) {
                return ch;
            }

        }
        return '\0';
    }

    private static Character findRepCharFirst(String str) {
        int[] freq = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
            if (freq[ch] > 1) {
                return ch;
            }

        }
        return '\0';
    }
}
