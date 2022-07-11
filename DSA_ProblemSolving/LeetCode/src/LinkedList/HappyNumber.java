package LinkedList;

public class HappyNumber {

    static public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(n);
            fast = findSquare(findSquare(n));
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;
    }

    static public int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number =number/ 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        HappyNumber hp = new HappyNumber();
        boolean res = hp.isHappy(49);
        System.out.println(res);
    }
}
