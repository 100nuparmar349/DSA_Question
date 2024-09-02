// Linked List is linear data structure 
// It's a dynamic data structure  
// we connect each data with a chain .
// I'ts chain is link to attached each data 
// It's store the data in a heap memory
// NUll is reperesent null.
// In java we store reference variable . Reference variable point to object. and object is node 
// First value to store in Node class  is data  
// Next variable ka type node hi hoga .kyu ki node point karta hai object ko 

// Every single data two parts
// 1. which type of data can be store
// 2. next is reference . it's a pointer to point the next node 

public class Linked {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
      
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public  void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void add(int idx, int data) {
        if (idx < 0) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);

        if (idx == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }

        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Index out of bounds");
                return;
            }
            temp = temp.next;
            
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
        size++;
    }
public int removeFirst(){
    if(size==0){
        System.out.println("Ll is empty");
        return Integer.MIN_VALUE;
    }else if(size==1){
        size=0;
        int val=head.data;
        head=tail=null;
        return val;
    }
    int val=head.data;
    head=head.next;
    size--;
    return val;

}
public int removelast(){
    if(size==0){
        return Integer.MIN_VALUE;
    }else if(size==1){
        int val=head.data;
        head=tail=null;
        size=0;
        return val;
    }
    Node prev=head;
    for(int i=0;i<size-2;i++){
        prev=prev.next;


    }
    int val=prev.next.data;
    prev.next=null;
    tail=prev;
   size--;
    return val;


}
public int search(int target){
    Node temp=head;
    int i=0;
    while(temp!=null){
      
        if(temp.data==target){
           
            return i;
        }
        temp=temp.next;
        i++;
    }



 return -1;

    }

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }

        int idx=helper(head.next, key);
        System.out.println(idx);
        if(idx==-1){
            return -1;
        }
        return idx+1;
       

    }

    public int recursion(int target){
       
       return helper(head, target);
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        head=prev;
        

    }
    public void removenth(int n){
      int sz=0;
      Node temp=head;
      while(temp!=null){
        temp=temp.next;
        sz++;
      }
      if(n==sz){
        head=head.next;
        return;
      }
      int i=1;
      int deleteindex=sz-n;
      Node prev=head;
      while(i<deleteindex){
        prev=prev.next;
        i++;
      }
      prev.next=prev.next.next;
      return;

        
    }
    public Node findmid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean checkpalindrome(){
       
        // step 2 - reverse 2nd half
        // step 3 - check left half and right half.
        if(head==null || head.next==null){
            return true;
        }

         // step 1 - find mid.
        Node midNode=findmid(head);

        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        Node right=prev;
        Node left=head;

        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;

        }

        return true;
      






    }
    public static void main(String[] args) {
        Linked ll = new Linked();
        ll.addFirst(2);
        ll.addFirst(1);
        add(2, 3);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        System.out.println(size);
       // ll.removeFirst();
      
       
      //  ll.removelast();
       
        ll.print();
        // System.out.println(ll.search(3));
        // System.out.println(ll.recursion(3));
      //  ll.reverse();
       // ll.addLast(6);
       ll.print();
       
        ll.removenth(3);
        ll.print();
       // ll.findmid();
        System.out.println(ll.checkpalindrome());


        // Search for a key in a linked List . Return the position where it is found. 
        // if not found , return -1 Use Recursion.

       
    }
}
