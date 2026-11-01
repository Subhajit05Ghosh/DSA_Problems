package Trees;

import java.util.ArrayList;
import java.util.List;

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class BoundaryTraverse {
    TreeNode root;

    // A simple function to print leaf nodes of a binary tree
    static void printLeaves(TreeNode node) {
        if (node == null)
            return;

        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    static void printBoundaryLeft(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    static void printBoundaryRight(TreeNode node) {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    static void printBoundary(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        // Print all leaf nodes
        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);
    }

   public static List<Integer> boundaryTraversal(TreeNode node) {
        List<Integer> al=new ArrayList<>();
        if (node == null)
            return al;

       al.add(node.data);

        // Print the left boundary in top-down manner.
        leftTraversal(node.left,al);

        // Print all leaf nodes
        leafNodes(node.left,al);
       leafNodes(node.right,al);

        // Print the right boundary in bottom-up manner
        rightTraversal(node.right,al);
        return al;
    }

    private static void leafNodes(TreeNode node, List<Integer> al) {
        if(node==null)
            return;

        leafNodes(node.left,al);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            al.add(node.data);
        leafNodes(node.right,al);
    }

    private static void rightTraversal(TreeNode node, List<Integer> al) {
        if(node==null)
            return;
        if(node.right!=null) {
            rightTraversal(node.right, al);
            al.add(node.data);
        } else if(node.left!=null) {
            rightTraversal(node.left, al);
            al.add(node.data);
        }

    }

    private static void leftTraversal(TreeNode node, List<Integer> al) {
        if(node==null)
            return;
        if(node.left!=null) {
            al.add(node.data);
            leftTraversal(node.left, al);
        } else if(node.right!=null) {
            al.add(node.data);
            leftTraversal(node.right, al);
        }
    }

    public static void main(String args[]) {
        BoundaryTraverse tree = new BoundaryTraverse();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        tree.root.right = new TreeNode(22);
        tree.root.right.right = new TreeNode(25);
        //printBoundary(tree.root);
        System.out.println(boundaryTraversal(tree.root));
    }
}
