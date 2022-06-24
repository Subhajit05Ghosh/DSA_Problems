package ds.stack;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        String str = "HelloWorld";
        String result = stringRev(str);
        System.out.println(result);
    }

    static String stringRev(String str) {
        int j = 0;
        char[] fin = new char[str.length()];
        Stack<Character> ch = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            ch.push(str.charAt(i));
        }
        while (!ch.empty()) {
            fin[j++] = ch.pop();
        }
        return String.valueOf(fin);
    }
}
