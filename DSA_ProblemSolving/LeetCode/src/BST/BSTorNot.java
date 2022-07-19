package BST;

public class BSTorNot {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean checkBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        if (checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max)) {
            return true;
        }
        return false;
    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        BSTorNot tree = new BSTorNot();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);

        if (tree.isValidBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}

