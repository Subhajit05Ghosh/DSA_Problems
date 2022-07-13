package LinkedList;

public class revLinListSizeK_II {
    ListNode head; // head of list

    /* Linked list Node*/
    class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String args[]) {
        revLinListSizeK_II llist = new revLinListSizeK_II();

		/* Constructed Linked List is 1->2->3->4->5->6->
		7->8->8->9->null */
       // llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverseKGroup(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length=lenOfLL(head);
        return reverseKGroup(head,k,length);
    }
    public int lenOfLL(ListNode head){
        int l=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            l++;
        }
        return l;
    }
    public ListNode reverseKGroup(ListNode head, int k,int l){
        int count=0;
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        if(l<k){
            return head;
        }
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null){
            head.next=reverseKGroup(next,k,l-k);
        }
        return prev;
    }
    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        ListNode new_node = new ListNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
