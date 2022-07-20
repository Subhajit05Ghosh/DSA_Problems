package BST;

public class KthLargestSmlst {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode kthlargest(TreeNode root,int k) {
        if(root==null)
            return null;

        TreeNode right=kthlargest(root.right,k);
        if(right!=null)
            return right;
        k--;

        if(k==0)
            return root;

        return kthlargest(root.left,k);
    }

    static TreeNode kthsmallest(TreeNode root,int k)
    {
        if(root==null)
            return null;

        TreeNode left=kthsmallest(root.left,k);
        if(left!=null)
            return left;
        k--;
        if(k==0)
            return root;

        return kthsmallest(root.right,k);
    }

    public static void main(String[] args) {
        KthLargestSmlst tree=new KthLargestSmlst();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(7);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(10);
        TreeNode ar=tree.kthlargest(tree.root,2);
        System.out.println("Largest-> "+ar.val);
        TreeNode al=tree.kthsmallest(tree.root,2);
        System.out.println("Smallest-> "+al.val);
    }
}
