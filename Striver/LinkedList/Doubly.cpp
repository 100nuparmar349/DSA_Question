#include<iostream>
#include<vector>

using namespace std;


class Node {
public:
    int data;
    Node* next;
    Node* back;
    
    Node(int data1, Node* next1, Node* back1) {
        data = data1;
        next = next1;
        back = back1;
    }

    Node(int data1) {
        data = data1;
        next = NULL;
        back = NULL;
    }
};

Node* ConvertArr2LL(vector<int>arr){
    Node* head=new Node(arr[0]);
    Node* prev=head;
    for(int i=1;i<arr.size();i++){
        Node* temp=new Node(arr[i],NULL,prev);
        prev->next=temp;
        prev=temp;



    }
    return head;
}

Node* deleteHead(Node* head){
    if( head->next==NULL || head==NULL){
        return NULL;
    }
  
   Node* prev=head;
    head=head->next;
    head->back=NULL;

    prev->next=NULL;
    delete prev;
    return head;
}

Node* deletetail(Node* head){
    if(head==NULL || head->next==NULL) return NULL;
    Node* tail=head;
    while(tail->next!=NULL){
        tail=tail->next;

    }
    Node* prev=tail->back;
    prev->next=NULL;
    tail->back=NULL;
    delete tail;
    return head;
}

// Delete The Kth element.

Node *deleteKth(Node* head,int k){
    Node* temp=head;
    int cnt=0;
    if(head==NULL){
        return NULL;
    }
    while(temp!=NULL){
        cnt++;
        if(cnt==k){
            break;
        }
        temp=temp->next;

    }
    Node* front=temp->next;
    Node* prev=temp->back;

    if(front==NULL && prev==NULL ){
      return NULL;
        
    }else if(prev==NULL){
    return deleteHead(head);
    }else if(front==NULL){
        return deletetail(head);
    }

    prev->next=front;
    front->back=prev;
    temp->next=nullptr;
    temp->back=nullptr;
    delete temp;
return head;
}


// Delete the Given Node.
void deleteNode(Node* temp){
    Node* prev=temp->back;
    Node* front=temp->next;
    if(front==NULL){
    prev->next=nullptr;
    free(temp);
    return;
    }
   prev->next=front;
   front->back=prev;

   temp->next=temp->back=nullptr;
   free(temp);



}

// Insert Node before the head.
Node* insertbeforHead(Node* head,int val){
    Node* newNode=new Node(val,head,nullptr);
    head->back=newNode;
   
    return newNode;
}

// Insert Node after the tail;

Node* insertbefortail(Node* head,int val){
    Node* tail=head;
    if(head->next==NULL){
        return insertbefortail(head,val);
    }

    while(tail->next!=NULL){
        tail=tail->next;
    }
    Node* prev=tail->back;                                                                                                                                                                                                                                                                       
    Node* newNode=new Node(val,tail,prev);
    prev->next=newNode;
    tail->back=newNode;
    Node* x=newNode->next;
    cout<<x->data<<" New Node :- ";
    return head;


}

// Insert The befor Kth Element.
Node* InsertKth_Element(Node* head, int val, int k) {
    // Handle insertion at the head separately
    if (k == 1) return insertbeforHead(head, val);

    Node* temp = head;
    int cnt = 1; // Start count from 1 since we're starting from the head

    // Traverse the list to find the kth position
    while (temp != NULL && cnt < k) {
        temp = temp->next;
        cnt++;
    }

    // If k is greater than the number of nodes, insertion is not possible
    if (temp == NULL) {
        // You could either return head as is or handle this case differently
        return head;
    }

    // Now temp is at the kth node; find the node before it
    Node* prev = temp->back;
    Node* newNode = new Node(val, temp, prev);

    // Link the new node with its neighbors
    prev->next = newNode;
    temp->back = newNode;

    return head;
}

// Insert Before Given Node.

void InsertBefor_Node(Node* node,int val){
    Node* prev=node->back;
    Node* newNode=new Node(val,node,prev);
    prev->next=newNode;
    node->back=newNode;
}
void print(Node* head){
    while(head!=NULL){
        cout<<head->data<<' ';
        head=head->next;

    }
}

int main(){
    vector<int>arr={3,1,4,5};
   Node* head= ConvertArr2LL(arr);
//   print(head);
  // head=deleteHead(head);
   // print(head);
   head=deletetail(head);
    cout<<endl<<" Delete Tail ";
    print(head);
    cout<<endl;

    // Delete The kth element
    deleteKth(head,2);

    print(head);
    cout<<endl;

    // Delete the Node 
    deleteNode(head->next);
    print(head);
    cout<<endl;

    // Insertion of the Node
   head=insertbeforHead(head,2);
    print(head);
    cout<<endl;


    // Insert Before tail.
    head=insertbefortail(head,15);
    print(head);
    cout<<endl;


    head=InsertKth_Element(head,4,2);
    print(head);
    cout<<endl;

    // Insert Befor the Node. 
    InsertBefor_Node(head->next,10);
    print(head);
    cout<<"Doubly Linked List";
return 0;


}

/*
Introduction to Doubly Linked List
Difficulty: EasyAccuracy: 76.51%Submissions: 29K+Points: 2
Geek is learning data structures and is familiar with linked lists, but he's curious about how to access the previous element in a linked list in the same way that we access the next element. His teacher explains doubly linked lists to him.

Given an integer array arr of size n. Construct the doubly linked list from arr and return the head of it.

Example 1:

Input:
n = 5
arr = [1,2,3,4,5]
class Node{
public:
    Node* prev;
    int data;
    Node* next;

    Node()
    {
        prev = NULL;
        data = 0;
        next = NULL;
    }

    Node(int value)
    {
        prev = NULL;
        data = value;
        next = NULL;
    }
};

class Solution {
  public:
    Node* constructDLL(vector<int>& arr) {
        // code here
        Node* head=new Node(arr[0]);
        Node* prev=head;
        
        for(int i=1;i<arr.size();i++){
            Node* newNode=new Node(arr[i]);
            prev->next=newNode;
            newNode->prev=prev;
            prev=newNode;
            
        }
        return head;
    }
};




Doubly linked list Insertion at given position
Difficulty: BasicAccuracy: 47.13%Submissions: 108K+Points: 1
Given a doubly-linked list, a position p, and an integer x. The task is to add a new node with value x at the position just after pth node in the doubly linked list.

Example 1:

Input:
LinkedList: 2<->4<->5
p = 2, x = 6 
Output: 2 4 5 6
Explanation: p = 2, and x = 6. So, 6 is
inserted after p, i.e, at position 3
(0-based indexing).
void addNode(Node *head, int pos, int data)
{
   // Your code here
   int cnt=0;
   Node* temp=head;
  
  while(cnt<pos){
      temp=temp->next;
      cnt++;
  }
   
   
   Node* newNode=new Node(data);
 
   newNode->next=temp->next;
   newNode->prev=temp;
   temp->next=newNode;
   

Reverse a Doubly Linked List
Difficulty: EasyAccuracy: 70.38%Submissions: 134K+Points: 2
Given a doubly linked list. Your task is to reverse the doubly linked list and return its head.

Examples:

Input: LinkedList: 3 <-> 4 <-> 5
Output: 5 <-> 4 <-> 3

class Solution {
  public:
    // Function to reverse a doubly linked list
    DLLNode* reverseDLL(DLLNode* head) {
        // Your code here
      
      // Brute Force.
      
        // stack<int>st;
        
        // DLLNode* temp=head;
        // while(temp!=NULL){
        //     st.push(temp->data);
        //     temp=temp->next;
        // }
        // temp=head;
        // while(temp!=NULL){
        //     temp->data=st.top();
        //     st.pop();
        //     temp=temp->next;
        // }
        // return head;
        
        // Optimal Approach
        if(head==NULL || head->next==NULL)return head;
        
        DLLNode* curr=head;
         DLLNode* last=NULL;
        while(curr!=NULL){
            last=curr->prev;
            curr->prev=curr->next;
            curr->next=last;
            curr=curr->prev;
        }
        head=last->prev;
        return head;
        
        
    }
};



    
   
}
*/