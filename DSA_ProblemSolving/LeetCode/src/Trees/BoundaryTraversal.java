package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BoundaryTraversal {


    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public static List<Integer> boundaryTraversal(Node node) {
        List<Integer> al = new ArrayList<>();
        if (node == null)
            return al;
        if(!isLeaf(node))
        al.add(node.data);

        // Print the left boundary in top-down manner.
        leftTraversal(node.left, al);

        // Print all leaf nodes
        leafNodes(node, al);

        // Print the right boundary in bottom-up manner
        rightTraversal(node.right, al);
        return al;
    }

    private static void leafNodes(Node node, List<Integer> al) {
        if (node == null)
            return;
        if (isLeaf(node)) {
            al.add(node.data);
            return;
        }
        leafNodes(node.left, al);
        leafNodes(node.right, al);
    }

    private static void rightTraversal(Node node, List<Integer> al) {
        Stack<Integer> stack = new Stack<Integer>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.data);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        while (!stack.isEmpty()) {
            al.add(stack.pop());
        }
    }

    private static void leftTraversal(Node node, List<Integer> al) {
        while (node != null) {
            if(!isLeaf(node))
                al.add(node.data);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void main(String args[]) {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        System.out.println(boundaryTraversal(tree.root));
    }
}

