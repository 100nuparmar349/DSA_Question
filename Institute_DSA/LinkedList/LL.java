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
public void removeFirst(){
    if(head==null){
        return;
    }
    Node temp=head;

    head=head.next;
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
        ll.addFirst(23);
      
        ll.print();
        // System.out.println(head.data);
        
    }
}
