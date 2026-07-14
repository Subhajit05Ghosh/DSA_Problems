package LinkedList.segregation;

public class SegregateEvenOdd2 {
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

    public Node segregateEvenOdd(Node head) {
        Node curr = head, temp;
        Node evenTrail = new Node(-1);
        Node oddTrail = new Node(-1);
        Node evenHead = evenTrail, oddHead = oddTrail;
        while (curr != null) {
            temp = curr;
            curr = curr.next;
            temp.next = null;
            if(temp.data %2==0){
                evenTrail.next=temp;
                evenTrail=temp;
            } else {
                oddTrail.next=temp;
                oddTrail=temp;
            }
        }
        evenTrail.next=oddHead.next;
        return evenHead.next;
    }

    /* Given a reference (pointer to pointer) to the head
      of a list and an int, push a new node on the front
      of the list. */
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
    private  Node segEvnOdd(Node head){
     if(head==null || head.next==null )
         return null;
     Node dummyEven=new Node(-1);
     Node dummyOdd=new Node(-1);
     Node evenTail=dummyEven,oddTail=dummyOdd,curr=head;
     while (curr!=null){
         if(curr.data % 2!=0){ //add
          oddTail.next=curr;
          oddTail=oddTail.next;
         }
         else{
             evenTail.next=curr;
             evenTail=evenTail.next;
         }
         curr=curr.next;
     }
     evenTail.next=dummyOdd.next;
     oddTail.next=null;
     return dummyEven.next;
    }
    public static void main(String args[]) {
        SegregateEvenOdd2 llist = new SegregateEvenOdd2();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);
        llist.push(4);
        llist.push(1);
        llist.push(0);
        System.out.println("Original Linked List");
        llist.printList();

        llist.segregateEvenOdd(llist.head);

        System.out.println("Modified Linked List");
        llist.printList();
    }
}