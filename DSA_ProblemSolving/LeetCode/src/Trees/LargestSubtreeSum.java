package Trees;

public class LargestSubtreeSum {
    static int ans=Integer.MIN_VALUE;
    static public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);
        System.out.println(findLargestSubtreeSum(root,ans));
    }

    private static int findLargestSubtreeSum(Node root,int ans) {
        //int ans = 0;
        int currentSum = 0;
        if (root == null)
            return 0;
        currentSum = root.data + findLargestSubtreeSum(root.left,ans) + findLargestSubtreeSum(root.right,ans);

        ans = Math.max(ans, currentSum);
        return ans;
    }
}
