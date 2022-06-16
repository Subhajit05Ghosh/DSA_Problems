package Trees;

import java.util.ArrayList;

public class LeftRightView {
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

    static void printLeftView(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);
        for (Node curr : list) {
            System.out.print(curr.data+" ");
        }
    }

    static void printLeftViewUtil(Node root, ArrayList list, int level) {
        if (root == null)
            return;

        if (level == list.size()) {
            list.add(root);
        }
        //printLeftViewUtil(root.right, list, level + 1);
        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);

    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BT tree = new BT();
        Node root = BT.buildTree(nodes);
        printLeftView(root);
    }
}
