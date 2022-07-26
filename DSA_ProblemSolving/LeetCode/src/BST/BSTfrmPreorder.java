package BST;

import Trees.BinaryTrees;

public class BSTfrmPreorder {

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode bstFromPreorder(int[] A, int bound, int[] i) {
        if (i[0] == A.length || A[i[0]] > bound) return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstFromPreorder(A, root.val, i);
        root.right = bstFromPreorder(A, bound, i);
        return root;
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        int[] arr = {40, 30, 35, 80, 100};
        BSTfrmPreorder bs = new BSTfrmPreorder();
        TreeNode root = bs.bstFromPreorder(arr);
        postorder(root);
    }
}

