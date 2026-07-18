package ArrayProblems.in.twoPointer.slidingWindow.LongestRepCharRepl;

public class LongestRepeatingReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    private static int characterReplacement(String s, int k) {
        int[] freq = new int[128];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch]++;
            maxFreq = Math.max(maxFreq, freq[ch]);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left)]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}