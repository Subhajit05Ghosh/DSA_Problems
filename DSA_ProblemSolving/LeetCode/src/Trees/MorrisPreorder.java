package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorder {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }


    public static void main(String[] args) {
        MorrisPreorder tree = new MorrisPreorder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.right = new TreeNode(6);
        tree.root.right = new TreeNode(3);
        List<Integer> ar = tree.preorderTraversal(tree.root);
        System.out.println(ar);
    }
}
