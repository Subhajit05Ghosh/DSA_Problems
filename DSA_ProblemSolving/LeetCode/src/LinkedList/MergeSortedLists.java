package LinkedList;


import LinkedList.Impl.SinglyLinkedList;

public class MergeSortedLists {
    private Node head;
    private int size;

    public class Node {
        private int val;
        private Node next;

        public Node(){

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node mergeLinkedList(Node listA, Node listB) {

        //create dummy Node
        Node dummyNode = new Node();

        Node tail = dummyNode;

        //will break out of Loop
        while (true) {
            //check if listA is empty of traversed
            if (listA == null) {
                tail.next = listB;
                break;
            }
            //check if listB is empty of traversed
            if (listB == null) {
                tail.next = listA;
                break;
            }

      /*
		check which listdata is lesser will be appended to
		 tail.next
        */
            if (listA.val <= listB.val) {
                tail.next = listA;
                listA = listA.next;
            } else {
                tail.next = listB;
                listB = listB.next;
            }

            //update tail
            tail = tail.next;
        }
        //returning the Result List
        return dummyNode.next;
    } //method Ends

        public Node mergeTwoLists(Node list1, Node list2) {
            if (list1 == null)
                return list2;
            if(list2 == null)
                return list1;
            if(list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }


    public static MergeSortedLists merge(MergeSortedLists first, MergeSortedLists second) {
        Node f = first.head;
        Node s = second.head;

        MergeSortedLists ans = new MergeSortedLists();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f = f.next;
            } else {
                ans.insertLast(s.val);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.val);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.val);
            s = s.next;
        }

        return ans;
    }


    public void insertLast(int data) {
        if (head == null)
            addFirst(data);
        else {
            Node curr = head;
            size++;
            while (curr.next != null) {
                curr = curr.next;
            }
            Node newNode = new Node(data);
            curr.next = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size += 1;
    }


    public static void main(String[] args) {
        MergeSortedLists first = new MergeSortedLists();
        MergeSortedLists second = new MergeSortedLists();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);
        first.display();

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);
        second.display();

        MergeSortedLists ans = MergeSortedLists.merge(first, second);
        ans.display();
    }
}
