package LinkedList;

public class EvenOddPos {
    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node oddEvenList1(Node head) {

        if (head == null || head.next == null)
            return head;
        Node temp2 = head.next;

        Node prev = head;
        Node present = head.next;
        Node next = present.next;
        int size = 2;

        while (next != null) {
            prev.next = next;
            prev = present;
            present = next;
            next = next.next;
            size++;
        }
        prev.next = next;

        if (size % 2 != 0)
            present.next = temp2;
        else
            prev.next = temp2;

        return head;
    }

    public Node oddEvenList(Node head) {
        if (head == null)
            return null;
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    void push(int new_data) {
    /* 1 & 2: Allocate the Node &
        Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    // Utility function to print a linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        EvenOddPos llist = new EvenOddPos();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);
        llist.push(4);
        llist.push(1);
        llist.push(0);
        System.out.println("Original Linked List");
        llist.printList();
        llist.oddEvenList(llist.head);

        System.out.println("Modified Linked List");
        llist.printList();
    }
}