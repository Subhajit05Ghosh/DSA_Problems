package Trees.SumTree;

// Java program to check if Binary tree
// is sum tree or not
import java.io.*;

// A binary tree node has data,
// left child and right child
class TreeNode
{
    int data;
    TreeNode left, right, nextRight;

    // Helper function that allocates a new node
    // with the given data and NULL left and right
    // pointers.
    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}
class SumTree1 {
    public static TreeNode root;

    // A utility function to get the sum
    // of values in tree with root as root
    static int sum(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        return (sum(node.left) + node.data+sum(node.right));
    }

    // Returns 1 if sum property holds for
    // the given node and both of its children
    static int isSumTree(TreeNode node)
    {
        int ls,rs;

        // If node is NULL or it's a leaf
        // node then return true
        if(node == null || (node.left == null && node.right == null))
        {
            return 1;
        }

        // Get sum of nodes in left and
        // right subtrees
        ls = sum(node.left);
        rs = sum(node.right);

        // If the node and both of its
        // children satisfy the property
        // return 1 else 0
        if((node.data == ls + rs) && isSumTree(node.left) != 0 && isSumTree(node.right) != 0)
        {
            return 1;
        }
        return 0;
    }

    // Driver code
    public static void main (String[] args)
    {
        SumTree1 tree=new SumTree1();
        tree.root=new TreeNode(26);
        tree.root.left=new TreeNode(10);
        tree.root.right=new TreeNode(3);
        tree.root.left.left=new TreeNode(4);
        tree.root.left.right=new TreeNode(6);
        tree.root.right.right=new TreeNode(3);
        if(isSumTree(root) != 0)
        {
            System.out.println("The given tree is a SumTree");
        }
        else
        {
            System.out.println("The given tree is not a SumTree");
        }
    }
}

// This code is contributed by rag2127
