package Trees.TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

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
        System.out.println("Inorder Traversal using Recursion");
        InorderRecursive(root);
        System.out.println("\nInorder Traversal using Iteration");
        InorderIterative(root);
    }

    private static void InorderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.data);
            curr = curr.right;
        }
/*        while(true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                curr = stack.pop();
                result.add(curr.data);
                curr = curr.right;
            }
        }*/
        result.stream().forEach(data -> System.out.print(data + " "));
    }

    private static void InorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        InorderRecursive(root.left);
        System.out.print(root.data+" ");
        InorderRecursive(root.right);
    }
}


/**
 * If current is not null push current element into a stack.
 * Start moving left until you reach the leftmost node (curr=null).
 * Pop the current element from the stack and add it in result.
 * Move to the right side.
 */