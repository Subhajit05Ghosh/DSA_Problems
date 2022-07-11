package LinkedList;

public class Palindrome {
    Node head; // head of list

    public class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
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

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
        }
        head.next = null;
        head = prev;
        return head;
    }

    public Node middleNode(Node head) {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node rereverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        return head == null || headSecond == null;
    }

    public static void main(String[] args) {
        Palindrome llist = new Palindrome();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(2);
        llist.push(1);
       boolean res= llist.isPalindrome(llist.head);
       System.out.println(res);
    }
}
