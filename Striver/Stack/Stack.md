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



# Postfix to infix

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
    }

# Postfix to prefix
 string postToPre(string s) {
        // Write your code here
        stack<string>st;
        int i=0;
        int n=s.length();
        while(i<n){
            if(isalnum(s[i])){
                st.push(string(1,s[i]));
            }else{
                string t1=st.top();
                st.pop();
                string t2=st.top();
                st.pop();
                st.push(s[i]+t2+t1);
            }
            i++;
        }
        return st.top();
        
}


# 203. Remove Linked List Elements
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:
Input: head = [], val = 1
Output: []


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val==val) {
        head=head.next;
         }

    ListNode temp=head;
    ListNode prev=null;

    while (temp != null) {
        if(temp.val==val) {
            prev.next = temp.next;
        }else{
            prev=temp;
        }
        temp=temp.next;
    }
    
    return head;
    }
}



# 03 496. Next Greater Element I

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer>st=new Stack<>();
        Map<Integer,Integer>mpp=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]) st.pop();
            if(st.isEmpty()){
                mpp.put(nums2[i],-1);

            }else{
                mpp.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=mpp.get(nums1[i]);
        }
        return  nums1;
    }
}

# 04  3174. Clear Digits

You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.
class Solution {
public:
    string clearDigits(string s) {
        stack<char>st;
        for(int i=0;i<s.length();i++){
            if(isalpha(s[i])){
                st.push(s[i]);
            }else{
                if(!st.empty())st.pop();
            }
        }
        string ans="";
        while(!st.empty()){
            ans+=st.top();
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};



# 05 503. Next Greater Element II

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
         Stack<Integer>st=new Stack<>();
            int n=nums.length;
    int[] NGE=new int[n];
        for(int i=2*nums.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]) st.pop();
           if(i<n){
          
            NGE[i]=st.isEmpty()?-1:st.peek();
           }
            st.push(nums[i%n]);
        }
        
        return  NGE;
    }
}


# 06  907. Sum of Subarray Minimums

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444


class Solution {
public:
vector<int>findnse(vector<int>arr){
    vector<int>nse(arr.size());
    stack<int>st;
    int n=arr.size();
    for(int i=n-1;i>=0;i--){
        while(!st.empty() && arr[st.top()]>=arr[i]) st.pop();
        nse[i]=st.empty()?n:st.top();
        st.push(i);
    }
    return nse;

}
vector<int>findpse(vector<int>arr){
     vector<int>pse(arr.size());
    stack<int>st;
    int n=arr.size();
    for(int i=0;i<n;i++){
        while(!st.empty() && arr[st.top()]>arr[i]) st.pop();
        pse[i]=st.empty()?-1:st.top();
        st.push(i);
    }
    return pse;


}
    int sumSubarrayMins(vector<int>& arr) {
        
        vector<int>nse=findnse(arr);
        vector<int>pse=findpse(arr);
       
        int mod=1e9+7;
        long long total=0;

        for(int i=0;i<arr.size();i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            total=(total+(long long )(left*right)*arr[i])%mod;

        }
        return total;   
    }
};

# 07 1021. Remove Outermost Parentheses

A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
Example 1:
Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character>st=new Stack<>();
         StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(st.size()>0){
                    sb.append(s.charAt(i));
                }
                st.push(s.charAt(i));
            }else{
                st.pop();
                if(st.size()>0){
                    sb.append(s.charAt(i));
                }
            }

        }
        return sb.toString();
        
    }
}


# 08   2104. Sum of Subarray Ranges

You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
Return the sum of all subarray ranges of nums.
A subarray is a contiguous non-empty sequence of elements within an array.
Example 1:
Input: nums = [1,2,3]
Output: 4
class Solution {
public:
vector<int> NSE(vector<int>&nums){
    stack<int>st;
    int n = nums.size();
    vector<int> nse(n,0);
    for(int i = n-1;i>=0;i--){
        while(!st.empty() && nums[st.top()] >= nums[i]){
            st.pop();
        }
        if(st.empty()){
            nse[i] = n;
        }
        else{
            nse[i] = st.top();
        }
        st.push(i);
    }
    return nse;
}
vector<int> PSE(vector<int>&nums){
    stack<int> st;
    int n = nums.size();
    vector<int> pse(n,0);
    for(int i=0 ;i<n;i++){
        while(!st.empty() && nums[st.top()] > nums[i]) st.pop();
        if(st.empty()) pse[i] =  -1;
        else pse[i] = st.top();
        st.push(i);
    }
    return pse;
}
vector<int> NGE(vector<int>&nums){
    stack<int> st;
    int n = nums.size();
    vector<int> nge(n,0);
    for(int i= n-1;i>=0;i--){
        while(!st.empty() && nums[st.top()] <= nums[i]) st.pop();
        if(st.empty()){
            nge[i] = n;
        }
        else{
            nge[i] = st.top();
        }
        st.push(i);
    }
    return nge;
}
vector<int> PGE(vector<int>&nums){
    stack<int>st;
    int n = nums.size();
    vector<int> pge(n,0);
    for(int i = 0;i<n;i++){
        while(!st.empty() && nums[st.top()] < nums[i]) st.pop();
        if(st.empty()) pge[i] = -1;
        else pge[i] = st.top();
        st.push(i);
    }
    return pge;
}
    long long subArrayRanges(vector<int>& nums) {
        long long sum = 0;
        int n = nums.size();
        vector<int> nse = NSE(nums);
        vector<int> pse = PSE(nums);
        vector<int> nge = NGE(nums);
        vector<int> pge = PGE(nums);
        long long largest =0, smallest =0;
        for(int i=0;i<n;i++){
            long long left = i - pse[i];
            long long right = nse[i] - i;
            long long left1 = i - pge[i];
            long long right1 = nge[i] - i;
            largest += (left*right*nums[i]);
            smallest += (left1*right1*nums[i]);
        }
        return abs(largest-smallest);
    }
};









