package Trees.TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

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
        System.out.println("Postorder Traversal using Recursion");
        postorderRecursive(root);
        System.out.println("\nPostorder Traversal using Iteration");
        postorderIterative(root);
    }

    private static void postorderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            //System.out.print(curr.data + " ");
            if (curr.left != null) {
                stack.push(curr.left);
            }
            result.add(curr.data);
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }

    private static void postorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.data+" ");
    }
}
