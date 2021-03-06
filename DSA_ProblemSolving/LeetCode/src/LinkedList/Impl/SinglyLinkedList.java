package LinkedList.Impl;

public class SinglyLinkedList {
    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size += 1;
    }

    public void addLast(int data) {
        Node curr = head;
        size++;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node newNode = new Node(data);
        curr.next = newNode;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            addFirst(val);
            return;
        } else if (index == size) {
            addLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        size++;
    }

    public int deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return -1;
        }
        int value = head.val;
        head = head.next;
        size--;
        return value;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int deleteLast() {
        if (size <= 1)
            deleteFirst();
        Node secondLast = get(size - 2);
        int val = secondLast.next.val;
        secondLast.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public Node reverseListRecursive(Node head) {
        // empty node || last node or only one node
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public Node reverseBetween(Node head, int left, int right) {
        Node curr = head;
        Node prev = null;
        for (int i = 0; curr != null && i < left - 1; i++) {
            prev = curr;
            curr = curr.next;
        }
        Node last = prev;
        Node newEnd = curr;
        for (int i = 0; curr != null & i < right - left + 1; i++) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = curr;
        return head;
    }


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

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.addFirst(3);
        sl.addFirst(2);
        sl.addFirst(8);
        sl.addFirst(17);
        sl.addLast(99);
        sl.insert(100, 3);
        sl.display();
        System.out.println("Reverse Between");
        sl.reverseBetween(sl.head, 2, 5);
        sl.display();
        System.out.println(sl.deleteFirst());
        sl.display();
        System.out.println(sl.deleteLast());
        sl.display();
        System.out.println(sl.delete(3));
        sl.display();
        System.out.println("Size-> " + sl.getSize());
        //System.out.println(sl.find(2));
        sl.head = sl.reverseListRecursive(sl.head);
        sl.display();
    }
}
