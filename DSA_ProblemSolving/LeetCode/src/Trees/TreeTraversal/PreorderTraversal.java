package Trees.TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

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
    static class BT {
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

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BT tree = new BT();
        Node root = tree.buildTree(nodes);
        System.out.println("Preorder Traversal using Recursion");
        preorderRecursive(root);
        System.out.println("\nPreorder Traversal using Iteration");
        preorderIterative(root);
    }

    private static void preorderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            //System.out.print(curr.data + " ");
            result.add(curr.data);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        result.stream().forEach(data -> System.out.print(data + " "));
    }

    private static void preorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }
}
