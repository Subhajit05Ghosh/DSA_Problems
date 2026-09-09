package ArrayProblems.in.twoPointer;
//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args) {
        String str1="A man, a plan, a canal: Panama";
        String str="race a car";
        if(palindromeCheck(str)){
            System.out.println("The String is Palindrome");
        }
        else{
            System.out.println("The String is not Palindrome");
        }
    }

    private static boolean palindromeCheck1(String inp) {
        String str = inp.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0;
        int j=str.length()-1;
        while (i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            } else {
                i++;
                j--;
            }
        }
  return true;  }


        public static boolean palindromeCheck(String s) {

            int left = 0;
            int right = s.length() - 1;

            while (left < right) {

                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }

                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                if (Character.toLowerCase(s.charAt(left)) !=
                        Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }

}
