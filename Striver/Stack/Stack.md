# 01 Implement Queue using array

(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop an element from the queue and print the popped element)
We just have to implement the functions push and pop and the driver code will handle the output.
Examples:
Input: Q = 5, Queries = 1 2 1 3 2 1 4 2
Output: 2 3
Explanation:
In the first test case for query 
1 2 the queue will be {2}
1 3 the queue will be {2 3}
2   poped element will be 2 the 
    queue will be {3}
1 4 the queue will be {3 4}
2   poped element will be 3 


class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=-1;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    arr[rear+1]=x;
	    rear++;
	    
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		
		if(rear==-1){return -1;}
		if(front>rear)return -1;
		int n=arr[front];
		arr[front]=0;
		front++;
		return n;
	
	} 
}


# 02  Implement stack using array
class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        arr[top+1]=x;
        top++;
        
    }

    public int pop() {
        // Your Code
        if(top==-1)return -1;
        int n=arr[top];
        arr[top]=0;
        top--;
        return n;
    }


# 03 Implement Stack using Linked List
Difficulty: EasyAccuracy: 53.98%Submissions: 151K+Points: 2
Let's give it a try! You have a linked list and must implement the functionalities push and pop of stack using this given linked list. Your task is to use the class as shown in the comments in the code editor and complete the functions push() and pop() to implement a stack. 
The push() method takes one argument, an integer 'x' to be pushed into the stack and pop() which returns an integer present at the top and popped out from the stack. If the stack is empty then return -1 from the pop() method.
Note: The input is given in the form of queries. Since there are two operations push() and pop(), there is two types of queries as described below:
(i) 1   (a query of this type takes x as another parameter and pushes it into the stack)
(ii) 2  (a query of this type means to pop an element from the stack and return the popped element)
Input is separated by space and as described above. 

Examples :

Input: [[1,2], [1,3], [2], [1,4], [2]]
Output: [3, 4]
Explanation: 
push(2)  : the stack will be {2}
push(3)  : the stack will be {2 3}
pop()    : poped element will be 3,the stack will be {2}
push(4)  : the stack will be {2 4}
pop()    : poped element will be 4




// posttoinfix
 string postToInfix(string exp) {
     int n = exp.length();
        stack<string> st;
        for(int i=0;i<n;i++){
            char ch = exp[i];
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                st.push(string(1,ch));
            }
            else{
                string s2=st.top();
                st.pop();
                string s1=st.top();
                st.pop();
                st.push('(' + s1 + ch + s2 + ')');
            }
        }
        return st.top();