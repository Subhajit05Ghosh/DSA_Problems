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
            //Update maxFreq to the maximum frequency of any character in the current window
            maxFreq = Math.max(maxFreq, freq[ch]);
            //Window size - maxFreq > k means we need to shrink the window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left)]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}