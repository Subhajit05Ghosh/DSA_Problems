
package Trees;
//Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree

/* Class containing left and right child of current
node and key value*/


public class DisbtNodes {

    static class LCANode {
        int data;
        LCANode left;
        LCANode right;

        public LCANode(int item) {
            data = item;
            left = right = null;
        }
    }

    //Root of the Binary Tree
    static LCANode root;

    static LCANode findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    static LCANode findLCA(LCANode node, int n1, int n2) {
        // Base case
        if (node == null)
            return null;

        if (node.data == n1 || node.data == n2)
            return node;
        LCANode left_lca = findLCA(node.left, n1, n2);
        LCANode right_lca = findLCA(node.right, n1, n2);
        if (left_lca != null && right_lca != null)
            return node;
        return (left_lca != null) ? left_lca : right_lca;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        LCANode root = new LCANode(2);
        root.left = new LCANode(7);
        root.right = new LCANode(9);
        root.right.right = new LCANode(3);
        root.left.left = new LCANode(10);
        root.left.right = new LCANode(6);
        root.left.right.left = new LCANode(5);
        root.left.right.right = new LCANode(11);
        System.out.println(distanceBetweenTwoNodes(root, 2, 3));
    }

    static public int distanceBetweenTwoNodes(LCANode node, int n1, int n2) {
        if (node == null) {
            return -1;
        }

        LCANode lca = findLCA(node, n1, n2);

        if (lca == null) {
            return -1;
        }

        int d1 = distanceFromParentToNode(lca, n1, 0);
        int d2 = distanceFromParentToNode(lca, n2, 0);

        return d1 + d2;
    }

    static public int distanceFromParentToNode(LCANode node, int val, int distance) {
        if (node == null) {
            return -1;
        }

        if (node.data == val) {
            return distance;
        }

        int d = distanceFromParentToNode(node.left, val, distance + 1);

        if (d != -1) {
            return d;
        }

        d = distanceFromParentToNode(node.right, val, distance + 1);

        return d;
    }
}
