package BST;

public class MaxOrMin {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int minValue(TreeNode node) {
        if (node == null)
            return -1;
        TreeNode curr = node;
        if (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }

    public int maxValue(TreeNode node) {
        if (node == null)
            return -1;
        TreeNode curr = node;
        if (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    public static void main(String[] args) {
        MaxOrMin tree = new MaxOrMin();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        System.out.println("The min value is " + tree.minValue(tree.root));
        System.out.println("The max value is " + tree.maxValue(tree.root));

    }
}

