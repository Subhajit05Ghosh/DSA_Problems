package LinkedList.Loop;


public class LoopRemoval {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
        }
    }

    Node head;

    // Detect and remove loop using Floyd’s algorithm
    public void detectAndRemoveLoop() {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;

        // Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                removeLoop(slow);
                return;
            }
        }
    }

    // Helper method to remove loop
    private void removeLoop(Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;

        // If loop starts at head
        if (ptr1 == ptr2) {
            while (ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            ptr2.next = null;
            return;
        }

        // Find the node before the start of the loop
        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Break the loop
        ptr2.next = null;
    }

    // Utility method to print the list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Utility method to create a loop for testing
    public void createLoop(int pos) {
        if (pos <= 0) return;

        Node loopStart = head;
        for (int i = 1; i < pos && loopStart != null; i++) {
            loopStart = loopStart.next;
        }

        if (loopStart == null) return;

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = loopStart;
    }

    // Driver code
    public static void main(String[] args) {
        LoopRemoval list = new LoopRemoval();

        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        list.createLoop(3);  // Creates loop at node with value 15

        list.detectAndRemoveLoop();

        System.out.println("Linked List after removing loop:");
        list.printList();
    }
}
