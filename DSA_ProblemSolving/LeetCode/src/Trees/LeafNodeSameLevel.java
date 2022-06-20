package Trees;

public class LeafNodeSameLevel {
    static int levelOfLeaf;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
/*        Node root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);*/
        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(1);
        System.out.println(ifLeavesAtSameLevel(root, 1));
    }

    static public boolean ifLeavesAtSameLevel(Node node, int level) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            if (levelOfLeaf == 0) {
                levelOfLeaf = level;
                return true;
            }

            return levelOfLeaf == level;
        }

        return ifLeavesAtSameLevel(node.left, level + 1) && ifLeavesAtSameLevel(node.right, level + 1);
    }
}
