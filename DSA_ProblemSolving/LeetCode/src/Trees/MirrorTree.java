package Trees;

class MTNode {
    MTNode left;
    MTNode right;
    int data;
}

class BinaryTree {

    public boolean ifMirrorTree(MTNode node1, MTNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node2.data
                && ifMirrorTree(node1.left, node2.right)
                && ifMirrorTree(node1.right, node2.left);
    }

    public MTNode createNewMTNode(int val) {
        MTNode newMTNode = new MTNode();
        newMTNode.data = val;
        newMTNode.left = null;
        newMTNode.right = null;
        return newMTNode;
    }
}

public class MirrorTree {


    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        MTNode root1 = a.createNewMTNode(2);
        root1.left = a.createNewMTNode(7);
        root1.right = a.createNewMTNode(8);
        root1.left.left = a.createNewMTNode(5);

        MTNode root2 = a.createNewMTNode(2);
        root2.left = a.createNewMTNode(8);
        root2.right = a.createNewMTNode(7);
        root2.right.right = a.createNewMTNode(5);

        System.out.println(a.ifMirrorTree(root1, root2));
    }

}