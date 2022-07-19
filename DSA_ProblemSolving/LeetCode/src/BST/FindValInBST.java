package BST;

public class FindValInBST {
    TreeNode root;
    static boolean flag = false;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public void searchNode(TreeNode temp, int value) {
        //Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            //If value is found in the given binary tree then, set the flag to true
            if (temp.val == value) {
                flag = true;
                return;
            }
            //Search in left subtree
            if (flag == false && temp.left != null) {
                searchNode(temp.left, value);
            }
            //Search in right subtree
            if (flag == false && temp.right != null) {
                searchNode(temp.right, value);
            }
        }
    }

    public static void main(String[] args) {
        FindValInBST tree = new FindValInBST();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);

        tree.searchNode(tree.root, 5);

        if (flag)
            System.out.println("Element is present in the binary tree");
        else
            System.out.println("Element is not present in the binary tree");

    }
}

