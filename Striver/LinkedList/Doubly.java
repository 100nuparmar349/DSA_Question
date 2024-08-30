import java.util.*;

class Node {
    int data;
    Node next;
    Node back;

    // Constructor for initializing Node with next and back pointers
    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    // Constructor for initializing Node without next and back pointers
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class Doubly {
    public static Node convertArrToLL(List<Integer> arr) {
        if (arr.isEmpty()) return null; // Handle empty array case

        Node head = new Node(arr.get(0));
        Node prev = head;

        for (int i = 1; i < arr.size(); i++) {
            Node temp = new Node(arr.get(i), null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head; // Return the head of the linked list
    }



    // Delete The head of the linked list .
  
 public static Node  deleteHead(Node head){
        if( head.next==null || head==null){
            return null;
        }
      
       Node prev=head;
        head=head.next;
        head.back=null;
    
        prev.next=null;
       
        return head;
    }
  public static  Node deletetail(Node head){
        if(head==null || head.next==null) return null;
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
    
        }
        Node prev=tail.back;
        prev.next=null;
        tail.back=null;
     
        return head;
    }
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void 


    public static void  main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 1, 4, 5);
        Node head = convertArrToLL(arr);
        head=deleteHead(head);
        print(head);
        head=deletetail(head);
        print(head);

        System.out.println("Hello");
    }
}
