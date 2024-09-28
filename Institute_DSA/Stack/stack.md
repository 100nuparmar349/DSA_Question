# 01 


Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves++ the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



class MinStack {
     Stack<Integer>s=new Stack<>();
   Stack<Integer>mini=new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
         s.push(val);
       if(mini.isEmpty() || val<=mini.peek()){
        mini.push(val);
       }
        
    }
    
    public void pop() {
        int x=s.pop();
        if(x==mini.peek()){
            mini.pop();
        }
        
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        
        return mini.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


 # 02 735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>s=new Stack<>();
     

        // Approach
        // 1. +ve -> push.
        // 2. -ve -> stack khali -> push
        //         -> -ve -> push
        //         -> +ve -> compare -> pop
        // 3. -ve === +ve(top)-> pop.
     
        for(int i:asteroids){
         if(i>0){
            s.push(i);
         }else {
          while(!s.isEmpty() && s.peek()<(-i) && s.peek()>0){
                s.pop();
            }
            if(s.isEmpty() || s.peek()<0){
                s.push(i);
            }
          
            if(s.peek()==-i) s.pop();
         }


        }
        int[] ans=new int[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            ans[i]=s.pop();
        }
return ans;

        
    }
}


# 03 895. Maximum Frequency Stack

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]
class FreqStack {

 HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Stack<Integer>> st = new HashMap<>();
        int mx = 0;
    // public FreqStack() {
       
    // }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;

        freq.put(val, f);
        mx = Math.max(mx, f);
        if (!st.containsKey(f))
            st.put(f, new Stack<Integer>());
        st.get(f).push(val);

    }

    public int pop() {
        int x = st.get(mx).pop();
        freq.put(x,mx-1);
        if(st.get(mx).isEmpty())mx--;
        return x;

    }
}

/**
 * 
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */


 # 04 20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 class Solution {
    public boolean isValid(String s) {
         Stack<Character>st=new Stack<>();
         for(char c:s.toCharArray()){
            if(st.empty()) st.push(c);
            else if(c==')' && st.peek()=='(' || c=='}' && st.peek()=='{' || c==']' && st.peek()=='['){
                st.pop();
            }else{
                st.push(c);
            }
         }
        return st.isEmpty();
    }
}


-- DDl (data definition language)
CREATE DATABASE DDL;
USE DDL;
CREATE TABLE DDL_TABLE(
Id int,
Name varchar(20),
Age int
);
select * from DDL_TABLE;
select Name from DDL_TABLE;
select Age from DDL_TABLE;

select * from DDL_TABLE;
insert into DDL_TABLE
values(1,'sonu',20),
(2,'Govind',19);

select * from DDL_TABLE;
alter table DDL_TABLE
modify column name varchar(50),

add column email varchar(50);

insert into DDL_TABLE
values(10,'parmar',20,'sonu757575');

alter table DDL_TABLE;
drop column email