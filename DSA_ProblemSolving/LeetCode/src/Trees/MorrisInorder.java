package Trees;

import BST.MaxOrMin;

import java.util.*;

public class MorrisInorder {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }

    public static void main(String[] args) {
        MorrisInorder tree=new MorrisInorder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.right = new TreeNode(6);
        tree.root.right = new TreeNode(3);
        List<Integer> ar=tree.inorderTraversal(tree.root);
        System.out.println(ar);
    }
}
