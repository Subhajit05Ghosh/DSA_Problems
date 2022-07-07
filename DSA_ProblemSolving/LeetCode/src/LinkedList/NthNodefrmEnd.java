package LinkedList;

public class NthNodefrmEnd {
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

    // Utility function to print a linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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

    private void printNthFromLast(Node head,int n) {
        Node p=head;
        Node f=head;
        int cnt=1;
        while(cnt<=n-1){
            f=f.next;
            cnt++;
        }
        while (f.next!=null){
         f=f.next;
         p=p.next;
        }
        System.out.println(p.data);
    }


    public static void main(String[] args)
    {
        NthNodefrmEnd llist = new NthNodefrmEnd();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        llist.printNthFromLast(llist.head,4);
    }


}
