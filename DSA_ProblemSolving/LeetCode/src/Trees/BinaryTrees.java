package Trees;

import java.util.*;

import static java.lang.Math.max;

//Preorder traversal:Root,Left,Right subtree
//Postorder traversal: Left,Right subtree,root
public class BinaryTrees {
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

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                if (q.isEmpty())
                    return;
                q.add(null);
                System.out.println();
                continue;
            }
            System.out.print(curr.data+" ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.left);
        int diam3 = height(root.left) + height(root.right) + 1;
        return Math.max(diam3, Math.max(diam1, diam2));
    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo right = diameter2(root.right);
        TreeInfo left = diameter2(root.left);
        int myHeight = Math.max(left.ht, right.ht) + 1;
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        int myDiam = Math.max(diam3, Math.max(diam1, diam2));
        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
        return myInfo;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BT tree = new BT();
        Node root = BT.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("\n Preorder Traversal");
        preorder(root);
        System.out.println("\n Inorder Traversal");
        inorder(root);
        System.out.println("\n Postorder Traversal");
        postorder(root);
        System.out.println("\n Level-order Traversal");
        levelOrder(root);
        System.out.println("The count of nodes in the Tree is " + countNodes(root));
        System.out.println("The height of the Tree is " + height(root));
        System.out.println("The diameter of the tree is " + diameter(root));
        System.out.println("The diameter of the tree :: " + diameter2(root).diam);
        printLevelOrder(root);
    }
}
