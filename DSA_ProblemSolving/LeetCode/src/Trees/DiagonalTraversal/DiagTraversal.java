package Trees.DiagonalTraversal;

import java.util.*;

class DiagTraversal {

    // Tree node
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static ArrayList<ArrayList<Integer>> diagonalOrder(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        que.addLast(root);
        while (que.size() != 0) {
            //Diagonal
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) {
                // Helps to traverse each component of particular diagonal
                Node rn = que.removeFirst();
                while (rn != null) {
                    //Traverse a component
                    smallAns.add(rn.data);
                    if (rn.left != null)
                        que.addLast(rn.left);
                    System.out.print(rn.data + " ");
                    rn = rn.right;
                }
            }
            System.out.println();
            ans.add(smallAns);
        }
        return ans;
    }


    public static ArrayList<Integer> diagonalOrder2(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        ArrayList<Integer> smallAns = new ArrayList<>();
        que.addLast(root);
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node rn = que.removeFirst();
                while (rn != null) {
                    smallAns.add(rn.data);
                    if (rn.left != null)
                        que.addLast(rn.left);
                    System.out.print(rn.data + " ");
                    rn = rn.right;
                }
            }
            System.out.println();
        }
        return smallAns;
    }


    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        // ArrayList<ArrayList<Integer>> am = diagonalOrder(root);
        //System.out.println(am);

        ArrayList<Integer> am2 = diagonalOrder2(root);
        System.out.println(am2);
    }
}