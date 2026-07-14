package JavaStreamExample;

public class Panagram {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog!!";
        long count=str.toLowerCase().chars().filter(Character::isLetter).distinct().count();
        if(count==26) {
            System.out.println("The given string is a panagram");
        }
        else {
            System.out.println("The given string is not a panagram");
        }
        boolean isPanagram = isPangram(str);
        if (isPanagram) {
            System.out.println("The given string is a panagram");
        } else {
            System.out.println("The given string is not a panagram");
        }
    }

    public static boolean isPangram(String input) {
        boolean[] seen = new boolean[26];
        int count = 0;

        for (char ch : input.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                if (!seen[idx]) {
                    seen[idx] = true;
                    count++;
                    if (count == 26) return true;
                }
            }
        }
        return false;
    }

}
