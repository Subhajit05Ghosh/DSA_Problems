package BST;

public class KthLargeGFG {


    // Root of BST
    Node root;

    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }


    // function to insert nodes

    // class that stores the value of count
    public class count {
        int c = 0;
    }

    // utility function to find kth largest no in
    // a given tree
    void kthLargestUtil(Node node, int k, count C) {
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (node == null || C.c >= k)
            return;

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        this.kthLargestUtil(node.right, k, C);

        // Increment count of visited nodes
        C.c++;

        // If c becomes k now, then this is the k'th largest
        if (C.c == k) {
            System.out.println(k + "th largest element is " +
                    node.data);
            return;
        }

        // Recur for left subtree
        this.kthLargestUtil(node.left, k, C);
    }
    void kthSmallesttUtil(Node node, int k, count C) {
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (node == null || C.c >= k)
            return;

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        this.kthSmallesttUtil(node.left, k, C);

        // Increment count of visited nodes
        C.c++;

        // If c becomes k now, then this is the k'th largest
        if (C.c == k) {
            System.out.println(k + "th smallest element is " +
                    node.data);
            return;
        }

        // Recur for left subtree
        this.kthSmallesttUtil(node.right, k, C);
    }

    // Method to find the kth largest no in given BST
    void kthLargest(int k) {
        count c = new count(); // object of class count
        this.kthLargestUtil(this.root, k, c);
    }
    void kthSmallest(int k) {
        count c = new count(); // object of class count
        this.kthSmallesttUtil(this.root, k, c);
    }

    // Driver function
    public static void main(String[] args) {
        KthLargeGFG tree = new KthLargeGFG();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(10);
        tree.kthLargest(2);
        tree.kthSmallest(2);

    }
}

