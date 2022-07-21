package BST;

import Trees.BinaryTrees;

public class MergeBST {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        MergeBST tree = new MergeBST();
        tree.root = new TreeNode(1);
        tree.root.right = new TreeNode(2);
        tree.root.left = new TreeNode(3);
        tree.root.left.left = new TreeNode(5);
        MergeBST treeB = new MergeBST();
        treeB.root = new TreeNode(2);
        treeB.root.left = new TreeNode(1);
        treeB.root.right = new TreeNode(3);
        treeB.root.left.right = new TreeNode(4);
        treeB.root.right.right = new TreeNode(7);
        TreeNode tr = mergeTrees(tree.root, treeB.root);
/*
                      3
                    /   \
                   4     5
                 /   \    \
                5     4    7         */

       preorder(tr);
    }

}
