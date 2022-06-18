package Trees;

import java.util.*;

public class BalancedTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.node = node;
            this.hd = hd;
        }
    }

    static class BT {
        Node1 root;
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    static public boolean isBalanced(Node root) {
        return treeHeight(root) != -1;
    }

    static int treeHeight(Node root) {
        if (root == null)
            return 0;
        int leftHeight = treeHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = treeHeight(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(rightHeight - leftHeight) > 1)
            return -1;
        return Math.max(rightHeight, leftHeight) + 1;
    }

    static public boolean isBalanced1(Node1 root) {
        return treeHeight1(root) != -1;
    }

    static int treeHeight1(Node1 root) {
        if (root == null)
            return 0;
        int leftHeight = treeHeight1(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = treeHeight1(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(rightHeight - leftHeight) > 1)
            return -1;
        return Math.max(rightHeight, leftHeight) + 1;
    }

    static class Node1 {
        int data;
        Node1 left, right;
        Node1(int d)
        {
            data = d;
            left = right = null;
        }
    }
    public static void main(String args[]) {
        //int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BT tree = new BT();
        Node root = BT.buildTree(nodes);
        boolean rs = isBalanced(root);
        if (rs == true) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);
        tree.root.left.left.left = new Node1(8);
        boolean rs1 = isBalanced1(tree.root);
        if (rs1 == true) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }

    }
}

