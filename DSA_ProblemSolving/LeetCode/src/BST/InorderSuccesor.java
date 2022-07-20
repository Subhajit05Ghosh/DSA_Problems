package BST;

public class InorderSuccesor {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode inorderSr(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while (root != null) {

            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        InorderSuccesor tree = new InorderSuccesor();
/*        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);*/
        tree.root=new TreeNode(5);
        tree.root.left=new TreeNode(3);
        tree.root.right=new TreeNode(7);
        tree.root.left.left=new TreeNode(2);
        tree.root.left.right=new TreeNode(4);
        tree.root.left.left.left=new TreeNode(1);
        tree.root.right.left=new TreeNode(6);
        tree.root.right.right=new TreeNode(9);
        tree.root.right.right.left=new TreeNode(8);
        tree.root.right.right.right=new TreeNode(10);
        TreeNode ins=inorderSr(tree.root, new TreeNode(8));
        System.out.println(ins.val);

    }
}

