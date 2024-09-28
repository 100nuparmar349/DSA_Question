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


# Q.11  Sort linked list of 0s 1s 2s

Given a linked list of 'N' nodes, where each node has an integer value that can be 0, 1, or 2. You need to sort the linked list in non-decreasing order and the return the head of the sorted list.



Example:
Given linked list is 1 -> 0 -> 2 -> 1 -> 2. 
The sorted list for the given linked list will be 0 -> 1 -> 1 -> 2 -> 2.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7
1 0 2 1 0 2 1


Sample Output 1:
0 0 1 1 1 2 2

public class Solution
{
    public static Node sortList(Node head) {
        // Write your code here
        Node zero_head=new Node(-1);
        Node one_head=new Node(-1);
        Node two_head=new Node(-1);

        Node zero=zero_head;
        Node one=one_head;
        Node two=two_head;

        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=temp;

            }else if(temp.data==1){
                one.next=temp;
                one=temp;


            }else{
                two.next=temp;
                two=temp;
            }
            temp=temp.next;
        }
        zero.next=(one_head.next!=null)?one_head.next:two_head.next;
        one.next=two_head.next;
        two.next=null;
        return zero_head.next;
    }
}


# Q.12
160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        map<ListNode* ,int>mpp;
        ListNode* temp=headA;
        while(temp!=NULL){
            mpp[temp]++;
            temp=temp->next;


        }
        ListNode* temp1=headB;

        while(temp1!=NULL){
            if(mpp.find(temp1)!=mpp.end()){
                return temp1;
            }
            temp1=temp1->next;
            
        }
        return NULL;

        
    }
};

# Q.13 Add 1 to a Linked List Number
Difficulty: MediumAccuracy: 31.91%Submissions: 247K+Points: 4
You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.



Approach
with help of recursion we easily to solve this problem because at the end we add 1 .

class Solution {
    public int helper(Node temp){

#  Base Condition.

       if(temp==null){
           return 1;
       }
# One By one come after base condition are hit.

      int carry=helper(temp.next);
      
      temp.data=temp.data+carry;
      if(temp.data<10)return 0;
    temp.data=0;
    return 1;
    
    
    //   int sum=temp.data+carry;
    //   temp.data=sum%10;
    //     return sum/10;
    }
    public Node addOne(Node head) {
        
    
      int carry = helper(head);

      // if there carry are exist so this if condition are run.
      
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }
}



# Q.14

2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
# Solution.d
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
       ListNode dummyNode=new ListNode(-1);
        int carry=0;
        int sum=0;
        ListNode curr=dummyNode;

        while(t1!=null || t2!=null){
      
               if(t1!=null) sum=sum+t1.val;
            if(t2!=null) sum=t2.val+sum;
            ListNode newNode=new ListNode(sum%10);
            curr.next=newNode;
            curr=newNode;
           sum=sum/10;
            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;

        }
        if(sum==1){
            ListNode newNode=new ListNode(1);
            curr.next=newNode;
            curr=newNode;
        }
        return dummyNode.next;

    }



# Q.15
You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

Example1:

Input: 
2<->2<->10<->8<->4<->2<->5<->2
2

 static Node deleteAllOccurOfX(Node head, int x) {
        Node temp=head;
        Node front=null;
        Node prev=null;
      
        while(temp!=null){
        front=temp.next;
        if(temp.data==x){
            
        
        if(temp==head){
            head=head.next;
        }
       
        prev=temp.prev;
        if(front!=null){
            front.prev=prev;
        }
        if(prev!=null){
            prev.next=front;
        }
        temp=front;
    
        }else{
            temp=temp.next;
        }
        }
        return head;

    }


# Q.16 Find pairs with given sum in doubly linked list
Difficulty: EasyAccuracy: 66.01%Submissions: 50K+Points: 2
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
Example 1:
Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
  public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
         ArrayList<ArrayList<Integer>> list=new ArrayList<>();
      Node temp=head;
     while(temp!=null){
      
         Node move=temp.next;
         while(move!=null){
             if(temp.data+move.data==target){
                 ArrayList<Integer> l = new ArrayList<>();
                 l.add(temp.data);
                 l.add(move.data);
                  list.add(l);
             }
             move=move.next;
         }
         temp=temp.next;
        
     }
        
        return list;
    }


# Q.17 Remove duplicates from a sorted doubly linked list
Difficulty: EasyAccuracy: 50.36%Submissions: 31K+Points: 2
Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

Example 1:

Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4

    Node removeDuplicates(Node head){
        // Code Here.
        Node nextnode=null;
        Node temp=head;
        Node prev=null;
        while(temp!=null && temp.next!=null){
            nextnode=temp.next;
            while(nextnode!=null && nextnode.data==temp.data){
                nextnode=nextnode.next;
            }
           temp.next=nextnode;
           if(nextnode!=null){
               nextnode.prev=temp;
           }
         temp=temp.next;
         
        }
        return head;


# 18 Reverse LinkedList.
import java.io.*;
import java.util.* ;

/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		LinkedListNode prev=null;

		LinkedListNode temp=head;
		LinkedListNode front=null;
		while(temp!=null){
			front=temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		return prev;

    }
}


# 19
Problem statement
You are given a Singly Linked List of integers and a reference to the node to be deleted. Every node of the Linked List has a unique value written on it. Your task is to delete that node from the linked list.

A singly linked list is a linear data structure in which we can traverse only in one direction i.e. from Head to Tail. It consists of several nodes where each node contains some data and a reference to the next node.

Note:

• The reference to the head of the linked list is not given.
• The node to be deleted is not a tail node.
• The value of each node in the Linked List is unique.
• It is guaranteed that the node to be deleted is present in the linked list.

public static void deleteNode(LinkedListNode<Integer> node) {
		// Write your code here.
        node.data=node.next.data;
        node.next=node.next.next;
}


# 20  Detect a loop.
 if(head==null){
            return true;
        }
       Node curr=head;
       Node temp=head.next;
       while(temp!=null && temp!=head){
           curr.next=null;
           curr=temp;
           temp=temp.next;
       }
       if(temp==null) return false;
       return true;
    }

# 21  25. Reverse Nodes in k-Group
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
    public ListNode reverse(ListNode head,int k){
        ListNode prev=null;
        ListNode curr=head;
        ListNode nextnode=null;
        int cnt=0;
        while(curr!=null && cnt<k){
            nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
       cnt++;
        }
        return prev;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int count=0;
        ListNode start=head;
        ListNode temp=head;
     
        while(temp!=null){
         temp = temp.next;
            count++;
           if (count == k) {
         
            ListNode reversedHead = reverse(head, k);

           
            head.next = reverseKGroup(temp, k);

           
            return reversedHead;
        }

        }
        return head;
        
    }
}


# 22 Rotate List
61. Rotate List
Given the head of a linked list, rotate the list to the right by k places.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:
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
    public ListNode findNth(ListNode temp,int k){
        int cnt=1;
        while(temp!=null){
            if(cnt==k) return temp;
            cnt++;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        if(k%len==0)return head;
        k=k%len;
        tail.next=head;
        ListNode newNode=findNth(head,len-k);
        head=newNode.next;
        newNode.next=null;    
        return head;  
    }
}


# 23  Remove loop in Linked List
Difficulty: MediumAccuracy: 27.66%Submissions: 463K+Points: 4
Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list.  So if the next of the previous node is null. then there is no loop.  Remove the loop from the linked list, if it is present (we mainly need to make the next of the last node null). Otherwise, keep the linked list as it is.

Note: Given an integer, pos (1 based index)  Position of the node to which the last node links back if there is a loop. If the linked list does not have any loop, then pos = 0.

The generated output will be true if your submitted code is correct, otherwise, false.
Examples:
Input: Linked list: 1->3->4, pos = 2
Output: true
Explanation: The linked list looks like
   // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
      Node slow=head;
      Node fast=head;
      while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
          if(slow==fast) break;
      }
       if (slow != fast) return;

       
        slow=head;
        if (slow==fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
   
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Break the loop
        fast.next = null;
    }

# 24 Kth from End of Linked List
Difficulty: EasyAccuracy: 41.18%Submissions: 390K+Points: 2
Given the head of a linked list and the number k, Your task is to find the kth node from the end. If k is more than the number of nodes, then the output should be -1.
Input: LinkedList: 1->2->3->4->5->6->7->8->9, k = 2
Output: 8
 public:
    int getKthFromLast(Node *head, int k) {
        // Your code here
        Node* temp=head;
        int len=1;
        while(temp!=NULL){
            temp=temp->next;
            len++;
        }
        if(len<=k) return -1;
       len= len-k;
       
       int cnt=1;
   
       temp=head;
       while(cnt<len){
           temp=temp->next;
           cnt++;
       }
       return temp->data;
    }



# 25 

Flattening a Linked List
Difficulty: MediumAccuracy: 51.53%Submissions: 157K+Points: 4
Given a Linked List, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked lists is in sorted order.
Flatten the Link List so all the nodes appear in a single level while maintaining the sorted order.

Note: The flattened list will be printed using the bottom pointer instead of the next pointer. Look at the printList() function in the driver code for more clarity.

Examples:

Input:

Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: The resultant linked lists has every node in a single level.(Note: | represents the bottom pointer.
)
   public static Node merge(Node list1, Node list2) {
        // Create a dummy node as a
        // placeholder for the result
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        // Connect the remaining
        // elements if any
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        // Break the last node's
        // link to prevent cycles
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    
   }

# 25  138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.
The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node deepcopy(Node head){
        Node dummynode=new Node(-1);
        Node temp=head;
        Node res=dummynode;
        while(temp!=null){
           res.next=temp.next;
           temp.next=temp.next.next;
           res=res.next;
           temp=temp.next;

        }
        return dummynode.next;
    }
  public void randomPointer(Node head){
    Node temp=head;
    while(temp!=null){
       Node copyNode=temp.next;
       if(temp.random!=null){
           copyNode.random=temp.random.next;
       }else{
        copyNode.random=null;
       }   
      temp=temp.next.next;     
    }
  }
  public void insertBetween(Node head){
    Node temp=head;
        while(temp!=null){
           Node copyNode=new Node(temp.val);
           copyNode.next=temp.next;
           temp.next=copyNode;
           temp=temp.next.next;

        }
  }
    public Node copyRandomList(Node head) {
        if(head==null)return head;
        insertBetween(head);
        randomPointer(head);
        return deepcopy(head);     
    }
}



# 26 Remove duplicates from a sorted Doubly Linked List

A doubly-linked list is a data structure that consists of sequentially linked nodes, and the nodes have reference to both the previous and the next nodes in the sequence of nodes.
You are given a sorted doubly linked list of size 'n'.
Remove all the duplicate nodes present in the linked list.
Example :
Input: Linked List: 1 <-> 2 <-> 2 <-> 2 <-> 3
Output: Modified Linked List: 1 <-> 2 <-> 3
Explanation: We will delete the duplicate values ‘2’ present in the linked list.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
5
1 2 2 2 3
Sample Output 1 :
1 2 3
Explanation For Sample Input 1 :
We will delete the duplicate values ‘2’ present in the linked list.
public class Solution {
    public static Node uniqueSortedList(Node head) {
        // Write your code here.
       if(head==null || head.next==null)return head;
       Node curr=head;
       while(curr!=null){
           Node next=curr.next;
           while(next!=null && next.data==curr.data){
               next=next.next;
           }
           curr.next=next;
           curr=curr.next;
       }
       return head;
    }

}

# 27  92. Reverse Linked List II
Solved
Medium
Topics
Companies
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
class Solution {
    public ListNode reverse(ListNode lefthead,int end){
        ListNode next;
        ListNode curr = lefthead;
        ListNode prev = null;
        int start = 0;

        while (curr != null && start <= end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            start++;
        }
    after reverse connect again our linkedlist.
        lefthead.next = curr; 
        return prev;
       
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null)return head;
      
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        prev.next=head;

     
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

      
        ListNode lefthead = prev.next;
        ListNode reverseHead = reverse(lefthead, right - left);

       
        prev.next = reverseHead;

        return dummy.next;
        
    }
}


# 28 143. Reorder List
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]
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
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
       
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
       mid=reverse(mid);
       while(mid!=null){
        ListNode node1=head.next;
        ListNode node2=mid.next;
        head.next=mid;
        mid.next=node1;
        head=node1;
        mid=node2;
       }

     
        
    }
}

# 29  3217. Delete Nodes From Linked List Present in Array

You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
Example 1:
Input: nums = [1,2,3], head = [1,2,3,4,5]
Output: [4,5]
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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        map<int,int>mpp;
        ListNode* curr=head;
        ListNode* dummy=new ListNode(-1);
        ListNode* prev=dummy;
        for(int i=0;i<nums.size();i++){
            mpp[nums[i]]++;
        }
        while(curr!=NULL){
            if(mpp.find(curr->val) != mpp.end()){
     
        curr = curr->next;
    } else {
        prev->next = curr;
        prev = prev->next;
        curr = curr->next;
    }

        }
        prev->next=NULL;
        return dummy->next;
        
    }
};

# 30 2807. Insert Greatest Common Divisors in Linked List

Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
Example 1:
Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]

class Solution {
public:
int gcd(int x,int y){
    if(y==0)return x;
    return gcd(y,x%y);
}
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        ListNode* curr=head;
        while(curr!=NULL && curr->next!=NULL){
                int data=gcd(curr->val,curr->next->val);
                ListNode* newnode=new ListNode(data);
                newnode->next=curr->next;
                curr->next=newnode;
                curr=newnode->next; 
        }
        return head;
        
    }
};

# 31 2487. Remove Nodes From Linked List

You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
class Solution {
public:
ListNode* reverse(ListNode* head){
    ListNode* prev=NULL;
    ListNode* curr=head;
    ListNode* next;
    while(curr!=nullptr){
        next=curr->next;
        curr->next=prev;
        prev=curr;
        curr=next;
    }
    return prev;


}
    ListNode* removeNodes(ListNode* head) {
        head=reverse(head);
       ListNode* newhead=new ListNode();
       ListNode* temp=newhead;
       int maxval=INT_MIN;
       while(head){
        if(head->val>=maxval){
            maxval=max(maxval,head->val);
            ListNode* newNode=new ListNode(maxval);
            temp->next=newNode;
            temp=temp->next;
        }
        head=head->next;
       }
    return reverse(newhead->next);

      
    }
};

# 32 1721. Swapping Nodes in a Linked List
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

class Solution {
    public int lengths(ListNode head){
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int len=lengths(head);
          int size = len - k + 1; 
    
        ListNode left=null,last=null,temp=head;
        int cnt=1;
        while(temp!=null ){
             if (cnt == k) {
                left = temp;  // The k-th node from the start
            }
            if (cnt == size) {
                last = temp;  // The k-th node from the end
            }
            cnt++;
            temp = temp.next; 
        }
          if (left != null && last != null) {
            int t = left.val;
            left.val = last.val;
            last.val = t;
        }
        
        return head;
        
    }
}

# 33 
1669. Merge In Between Linked Lists
Solved
Medium
Topics
Companies
Hint
You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

The blue edges and nodes in the following figure indicate the result:


Build the result list and return its head.

 

Example 1:


Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [10,1,13,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
      ListNode a1=list1;
      ListNode b1=list1;
      ListNode temp=list2;
      for(int i=1;i<a;i++){
            a1=a1.next;
      }

       for(int i=0;i<b;i++){
            b1=b1.next;
      }
      a1.next=list2;
      while(a1.next!=null){
        a1=a1.next;
      }
      a1.next=b1.next;
      return list1;
     

    }

}


# 34 23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        vector<int>v;
        for(int i=0;i<lists.size();i++){
            ListNode* temp=lists[i];
            while(temp!=nullptr){
                v.push_back(temp->val);
                temp=temp->next;
            }

        }
        // sort the vector
        sort(v.begin(),v.end());

        // check the vector is empty or not
        if (v.empty()) return nullptr;
        ListNode* head=new ListNode(v[0]);
        ListNode*  temp=head;
        for(int i=1;i<v.size();i++){
          ListNode* newNode=new ListNode(v[i]);
          temp->next=newNode;
          temp=newNode;
        }
        return head;


    }
};


# 35 Implement Queue using Linked List
Difficulty: BasicAccuracy: 45.6%Submissions: 121K+Points: 1
Implement a Queue using Linked List. 
A Query Q is of 2 Types
(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop an element from the queue and print the poped element)

Example 1:

Input:
Q = 5
Queries = 1 2 1 3 2 1 4 2
Output: 2 3
Explanation: n the first testcase
1 2 the queue will be {2}
1 3 the queue will be {2 3}
2   poped element will be 2 the
    queue will be {3}
1 4 the queue will be {3 4}
2   poped element will be 3.
class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode newNode=new QueueNode(a);
        if(rear==null || front==null){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
       
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if(front==null)return -1;
        
        int n=front.data;
        front=front.next;
       
        return n;
	}
}


# 36 705. Design HashSet
Design a HashSet without using any built-in hash table libraries.
Implement MyHashSet class:
void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
Example 1:
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]
class MyHashSet {

    private  boolean[] set;

    public MyHashSet() {
        set=new boolean[10000001];
    }
    
    public void add(int key) {
        set[key]=true;
    }
    
    public void remove(int key) {
        set[key]=false;
    }
    
    public boolean contains(int key) {
      return  set[key];
    }
}




# 37 147. Insertion Sort List

Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode sorted = new ListNode(0); // dummy node
        ListNode current = head;

        while (current != null) {
            ListNode prev = sorted;
            ListNode next = sorted.next;
            while (next != null && next.val < current.val) {
                prev = next;
                next = next.next;
            }
            ListNode temp = current.next;
            current.next = next;
            prev.next = current;
            
          
            current = temp;
        }

        return sorted.next;
    }
}

