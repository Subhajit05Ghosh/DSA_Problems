package Trees;

public class LCAFind {
    static boolean v1 = false, v2 = false;

    static class LCANode {
        int data;
        LCANode left, right;

        public LCANode(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        LCANode root = new LCANode(1);
        root.left = new LCANode(2);
        root.right = new LCANode(3);
        root.left.left = new LCANode(4);
        root.left.right = new LCANode(5);
        root.right.left = new LCANode(6);
        root.right.right = new LCANode(7);
        LCANode nd = findLCA(root, 4, 5);
        if (nd != null)
            System.out.println("LCA(4, 5) = " + nd.data);
        else
            System.out.println("Keys are not present");

        nd = findLCA(root, 4, 10);
        if (nd != null)
            System.out.println("LCA(4, 10) = " + nd.data);
        else
            System.out.println("Keys are not present");

    }

    static LCANode findLCA(LCANode root, int n1, int n2) {
        // Initialize n1 and n2 as not visited
        v1 = false;
        v2 = false;

        // Find lca of n1 and n2 using the technique discussed above
        LCANode lca = lca(root, n1, n2);

        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca;

        // Else return NULL
        return null;
    }

    static LCANode lca(LCANode root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1) {
            v1 = true;
            return root;
        }
        if (root.data == n2) {
            v2 = true;
            return root;
        }
        LCANode left = lca(root.left, n1, n2);
        LCANode right = lca(root.right, n1, n2);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
