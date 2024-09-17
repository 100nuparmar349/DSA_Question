public class LL {
   public  static Node head;
   class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
   }
   public void addFirst(int data) {
      
    Node newNode = new Node(data);


  if(head==null){
    head=newNode;
    return ;
  }

    newNode.next = head;
    head = newNode;
}
public void addLast(int data) {
    Node newNode = new Node(data);
    Node temp=head;
    if(head==null){
        head=newNode;
        return;
    }
    while(temp.next!=null){
        temp=temp.next;
    }
    temp.next=newNode;
    temp=newNode;
    
}
public void removeFirst(){
    if(head==null){
        return;
    }
    Node temp=head;

    head=head.next;
    temp.next=null;

}


public void removelast(){
    Node temp=head;
    int cnt=0;
    // if(head==null){
    //     System.out.println("Linked List is empty");
    //     return;

    // }
    // if(head.next!=null){
    //     head=null;
    //     return;
  //  }
//   while(temp.next.next!=null){
//     temp=temp.next;
//   }
//   temp.next=null;

    while(temp!=null){
        temp=temp.next;
        cnt++;
    }
    temp=head;
    for(int i=0;i<cnt-2;i++){
        temp=temp.next;
    }
    System.out.println("Data");
   // System.out.println(temp.data);
    temp.next=null;
}
public void print(){
    Node temp=head;
    while(temp!=null){
        System.out.println(temp.data);
        temp=temp.next;

    }
}
    public static void main(String[] args) {

        // we cann't declare static because we don't known which node are delete in the static method.
        

        LL ll=new LL();
        ll.addFirst(2);
        
        ll.removeFirst();
        ll.addFirst(3);
      ll.addLast(5);
      System.out.println("Remove THe last");
     ll.removelast();
        ll.print();
        
        // System.out.println(head.data);
        
    }
}
