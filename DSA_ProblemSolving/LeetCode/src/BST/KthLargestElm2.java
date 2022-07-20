package BST;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElm2 {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }
    public TreeNode KthLargestUsingMorrisTraversal(TreeNode root,int k) {
        List<Integer> inorder = new ArrayList<Integer>();
        TreeNode kLargest=null;
        TreeNode cur = root;
        int count=0;
        int l=countNodes(root);
        while (cur != null) {
            if (cur.right == null) {
                inorder.add(cur.val);
                if (++count == k)
                    kLargest = cur;
                cur = cur.left;
            } else {
                TreeNode prev = cur.right;
                while (prev.left != null && prev.left != cur) {
                    prev = prev.left;
                }

                if (prev.left == null) {
                    prev.left = cur;
                    cur = cur.right;
                } else {
                    prev.left = null;
                    inorder.add(cur.val);
                    if (++count == k)
                        kLargest = cur;
                    cur = cur.left;
                }
            }
        }
        return kLargest;
    }

    public static void main(String[] args) {
        KthLargestElm2 tree=new KthLargestElm2();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(7);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(10);
        TreeNode ar=tree.KthLargestUsingMorrisTraversal(tree.root,2);
        System.out.println(ar.val);
    }
}
