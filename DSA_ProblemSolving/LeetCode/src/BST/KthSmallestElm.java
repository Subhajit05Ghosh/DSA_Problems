package BST;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElm {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode KthSmallestUsingMorrisTraversal(TreeNode root,int k) {
        List<Integer> inorder = new ArrayList<Integer>();
        TreeNode kLargest=null;
        TreeNode cur = root;
        int count=0;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                if (++count == k)
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
                    if (++count == k)
                        kLargest = cur;
                    cur = cur.right;
                }
            }
        }
        return kLargest;
    }

    public static void main(String[] args) {
        KthSmallestElm tree=new KthSmallestElm();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(7);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(10);
        TreeNode ar=tree.KthSmallestUsingMorrisTraversal(tree.root,2);
        System.out.println(ar.val);
    }
}
