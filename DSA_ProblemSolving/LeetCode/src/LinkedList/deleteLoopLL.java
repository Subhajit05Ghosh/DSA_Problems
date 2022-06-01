package LinkedList;

// A Linked List Node
class Node
{
    int data;
    Node next;
}

public class deleteLoopLL
{
    // Utility function to create a new node with the given data and
    // pushes it onto the list's front
    public static Node push(Node head, int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = head;
        return node;
    }

    // Utility function to print a linked list
    public static void printList(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.data + " —> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Function to remove a cycle from a linked list pointed by `head` pointer.
    // The `slow` pointer points to one of the nodes involved in the cycle
    public static void removeCycle(Node slow, Node head)
    {
        // Find the count of nodes involved in the loop
        int k = 1;
        for (Node ptr = slow; ptr.next != slow; ptr = ptr.next) {
            k++;
        }

        // Get a pointer to k'th node from the head
        Node curr = head;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }

        // Simultaneously move the `head` and `curr` pointers at the same speed
        // until they meet.
        while (curr != head)
        {
            curr = curr.next;
            head = head.next;
        }

        // `curr` points to the last node of the loop
        while (curr.next != head) {
            curr = curr.next;
        }

        // set the next pointer of `curr` to `null` to break the chain
        curr.next = null;
    }

    // Function to identify a cycle in a linked list using
    // Floyd’s cycle detection algorithm
    public static Node identifyCycle(Node head)
    {
        // take two pointers – `slow` and `fast`
        Node slow = head, fast = head;

        while (fast != null && fast.next != null)
        {
            // move slow by one pointer
            slow = slow.next;

            // move fast by two pointers
            fast = fast.next.next;

            // if they meet any node, the linked list contains a cycle
            if (slow == fast) {
                return slow;
            }
        }

        // we reach here if the slow and fast pointer does not meet
        return null;
    }

    public static void main(String[] args)
    {
        // total number of nodes in the linked list
        int n = 5;

        // construct a linked list
        Node head = null;
        for (int i = n; i > 0; i--) {
            head = push(head, i);
        }

        // insert cycle
        head.next.next.next.next.next = head.next;

        // first check if a cycle is present in a linked list
        Node slow = identifyCycle(head);

        // if a cycle is found, remove it
        if (slow != null)
        {
            removeCycle(slow, head);
            printList(head);
        }
        else {
            System.out.println("No Cycle Found");
        }
    }
}