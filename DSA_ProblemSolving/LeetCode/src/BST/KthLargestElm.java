package BST;

import Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElm {
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
            if (cur.left == null) {
                inorder.add(cur.val);
                if (++count == l-k+1)
                    kLargest = cur;
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
                    if (++count == l-k+1)
                        kLargest = cur;
                    cur = cur.right;
                }
            }
        }
        return kLargest;
    }

    public static void main(String[] args) {
        KthLargestElm tree=new KthLargestElm();
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
