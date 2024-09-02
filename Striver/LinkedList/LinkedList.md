# Doubly Linked List

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




# Single Linked List.

Q.01
Given an array of integer arr. Your task is to construct the linked list from arr & return the head of the linked list.

 class Solution {
  public:
    Node* constructLL(vector<int>& arr) {
        // code here
        Node* head=new Node(arr[0]);
        Node* temp=head;
        for(int i=1;i<arr.size();i++){
            Node* newnode=new Node(arr[i]);
            temp->next=newnode;
            temp=newnode;
        }
        return head;
    }
};


# Q.02

Given the head of a Singly Linked List and a value x, insert that value x at the end of the LinkedList and return the modified Linked List.

Examples :

Input: LinkedList: 1->2->3->4->5 , x = 6
Output: 1->2->3->4->5->6

class Solution {
  public:
    Node *insertAtEnd(Node *head, int x) {
        // Code here
       
            Node* newNode=new Node(x);
            Node* temp=head;
       if(head==NULL){
           head=newNode;
           return head;
       }
     
        while(temp->next!=NULL){
            temp=temp->next;
            
        }
       
        temp->next=newNode;
        return head;
    }
};


# Q.03 19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* temp=head;
        int count=0;
        while(temp!=NULL)   {
            temp=temp->next;
            count++; 
        }
        int size=count-n;
        temp=head;

     
       if(count==1) return NULL;
       
       if(count==n){
        head=head->next;
        return head;
       }
        for(int i=1;i<size;i++){
            temp=temp->next;
        }
        if (temp != nullptr && temp->next != nullptr) {
    temp->next = temp->next->next;
} 

        return head;

    }
};


# Q.04 Middle of the Linked List


876. Middle of the Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]


# Brute  Force
ListNode* middleNode(ListNode* head) {
        ListNode* temp=head;
        int cnt=0;
        while(temp!=NULL){
            temp=temp->next;
            cnt++;
        }
        if(cnt==1){
            return head;
        }
        int cnt1=0;
        temp=head;
        while(temp!=NULL){
            cnt1++;
            if(cnt1==cnt/2)break;
            temp=temp->next;
           
        }
        head=temp->next;
        return head;
        
    }

# Optimal solution.

        ListNode* slow=head;
        ListNode* fast=head;

        while(fast!=NULL && fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;


# Q.05
# 206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

 ListNode* reverseList(ListNode* head) {

        if(head==NULL || head->next==NULL) return head;

        ListNode* prev=NULL;
        ListNode* curr=head;
         ListNode* front=NULL;
        while(curr!=NULL){
            front=curr->next;
            curr->next=prev;
            prev=curr;
            curr=front;
        }
    return prev;
        
    }


# Q.06
 bool hasCycle(ListNode *head) {
# We use hashing so store the entire node because the value is repeated . Node is again pointing to the same location  that is my answer

    map<ListNode*, int>mpp;
        ListNode* temp=head;
        while(temp!=NULL){
           if(mpp.find(temp)!=mpp.end()){
            return true;
            
           }
            mpp[temp]=1;

            temp=temp->next;
        }
    return false;
        
    }

# Optimal Approach.
# Tortise and horse 
Node* slow=head;
Node* fast=head;
slow increase by one .
fast increase by two.


  ListNode* slow=head;
    ListNode* fast=head;
    while(fast!=NULL && fast->next!=NULL && slow!=NULL ){

          
            fast=fast->next->next;
            slow=slow->next;
              if(slow==fast) return true;


    }
    return false;
    

# Q.07 Find the length of the Linkedlist
class Solution {
  public:
  
  // Find the Length of the Linked List.
  

 // Function to find the length of a loop in the linked list.
    int countNodesinLoop(Node *head) {
//         // Code here
//       map<Node*, int> mpp;
// Node* temp = head;
// int length = 0;

// Node* start=head;
// bool flag=false;
// while (temp != NULL) {
//     if (mpp.find(temp) != mpp.end()) {
//         while(start!=temp){
//             start=start->next;
//             length--;
//         }
//         flag=true;
//         break;  // Cycle detected
//     }
//     mpp[temp]++;  // Mark this node as visited
//     temp = temp->next;
//     length++;
// }

// if(!flag){
//     length=0;
// }
// return length;

// Optimal solution


int findLength(Node* slow,Node* fast){
      int cnt=1;
      fast=fast->next;
      while(slow!=fast){
          cnt++;
          fast=fast->next;
      }
      return cnt;
  }


    Node* slow=head;
    Node* fast=head;
    while(fast!=NULL && fast->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
        
        if(slow==fast){
            return findLength(slow,fast);
        }
    }
    return 0;
    }

# Q.08 Check The Palindrome

 public boolean isPalindrome(ListNode head) {
      ArrayList<Integer>v=new ArrayList<>();
      
        ListNode temp=head;

        while(temp!=null){
            v.add(temp.val);
            temp=temp.next;
        }
        int n=v.size();
        for(int i=0;i<n/2;i++){
            if(v.get(i)==v.get(n-i-1)){
                continue;
            }else{
                return false;
            }
        }
    return true;
        
    }
}

# Optimal Solution.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
 public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;  // Return the new head of the reversed list.
}

    public boolean isPalindrome(ListNode head) {
    //   ArrayList<Integer>v=new ArrayList<>();
      
    //     ListNode temp=head;

    //     while(temp!=null){
    //         v.add(temp.val);
    //         temp=temp.next;
    //     }
    //     int n=v.size();
    //     for(int i=0;i<n/2;i++){
    //         if(v.get(i)==v.get(n-i-1)){
    //             continue;
    //         }else{
    //             return false;
    //         }
    //     }
    // return true;

    // Optimal Approach.

        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        // Compare both halves
        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead);  // Restore the list before returning
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // Restore the original list
        reverse(newHead);
        return true;
    }
}

// 1,2,2,1 and 1,2,2,2,1.


# Q.09 328. Odd Even Linked List

class Solution {
    public ListNode oddEvenList(ListNode head) {
     if (head == null || head.next == null) {
        return head; 
    }

    ListNode even = head;
    ListNode odd = head.next;
    ListNode oddHead = odd;

    while (even != null && even.next != null && odd != null && odd.next != null) {
        even.next = even.next.next;
        odd.next = odd.next.next;    
        even = even.next;          
        odd = odd.next;            
    }

    even.next = oddHead;
    return head;
        
    }
}

Approach 
We implement two pointer first is even and odd

odd pointing to the odd index and even pointing to even index node .

After exit the loop . the even node point to the odd node.




# Q.10 148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.
Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        
        return dummy.next;
    }
    
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null; // Correct the splitting of the list
        
        ListNode left = sortList(head); // Sort the left half
        right = sortList(right); // Sort the right half
        
        return merge(left, right); // Merge the sorted halves
    }
}
