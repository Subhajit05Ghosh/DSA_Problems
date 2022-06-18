package Trees;

class TreNode {
    int data;
    TreNode left, right;

    public TreNode(int item) {
        data = item;
        left = right = null;
    }
}

class MirrorTreeConversion {
    TreNode root;

    void mirror() {
        root = mirror(root);
    }

    TreNode mirror(TreNode node) {
        if (node == null)
            return node;

        /* do the subtrees */
        TreNode left = mirror(node.left);
        TreNode right = mirror(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }

    void inOrder() {
        inOrder(root);
    }

    /* Helper function to test mirror(). Given a binary
    search tree, print out its data elements in
    increasing sorted order.*/
    void inOrder(TreNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    /* testing for example nodes */
    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        MirrorTreeConversion tree = new MirrorTreeConversion();
        tree.root = new TreNode(1);
        tree.root.left = new TreNode(2);
        tree.root.right = new TreNode(3);
        tree.root.left.left = new TreNode(4);
        tree.root.left.right = new TreNode(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror();

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();

    }
}
