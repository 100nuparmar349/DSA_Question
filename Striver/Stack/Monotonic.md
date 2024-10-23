# 01  402. Remove K Digits
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
Example 1:
Input: num = "1432219", k = 3
Output: "1219"
class Solution {
public:
    string removeKdigits(string num, int k) {
        stack<char>st;
      //  if(num.length()==1 || num.length()<k)return "0";
        int n=num.length();
        for(int i=0;i<n;i++){
            while(!st.empty() && st.top()>num[i] && k>0){
                st.pop();
                k--;
            }
            st.push(num[i]);
        }
        string ans="";
      
      while(k>0 && !st.empty()){
        st.pop();
        k--;
      }
        while(!st.empty()){
                ans+=st.top();
                st.pop();   
        }
        reverse(ans.begin(),ans.end());
     while (ans.length() > 1 && ans[0] == '0') {
            ans.erase(ans.begin());
        }
        
        // If the resulting string is empty, return "0"
        return ans.empty() ? "0" : ans;

  
    }
};
create a stack
Run a loop
pop the  stack element when st element greater than my current element 

After compeletion the loop check the k==0 suppose k!=0 so run one more while loop and pop the element


# 02 
class Solution {
 
    public int largestRectangleArea(int[] heights) {
       Stack<Integer>st=new Stack<>();
       int n=heights.length;
       int[] pse=new int[n];
       int[] nse=new int[n];
       for(int i=0;i<n;i++){
        while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
       if(st.isEmpty())pse[i]=0;
       else pse[i]=st.peek()+1;
       st.push(i);
       }
       while(!st.isEmpty())st.pop();
        for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
       if(st.isEmpty())nse[i]=n-1;
       else nse[i]=st.peek()-1;
       st.push(i);
       }

       int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (nse[i] -pse[i] + 1));
        }
        return maxA;

    }
}

# 03 Next Greater element
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer>st=new Stack<>();
            int n=nums2.length;
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

# 04 503. Next Greater Element II

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
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


# 05 
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Input Format

The only argument given is integer array A.
Output Format

Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
For Example

Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer>st=new Stack<>();
        int[] NGE=new int[A.length];
        for(int i=0;i<A.length;i++){
            while(!st.isEmpty() && st.peek()>=A[i])st.pop();
            if(st.isEmpty()){
                NGE[i]=-1;
            }else{
                NGE[i]=st.peek();
            }
            st.push(A[i]);
        }
        return  NGE;
    }
}


# 06 735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
class Solution {
public:
    vector<int> asteroidCollision(vector<int>& arr) {
        vector<int> st;  // Stack to store the result
        
        for(int i = 0; i < arr.size(); i++) {
            if(arr[i] > 0) {  // Push positive asteroids to the stack
                st.push_back(arr[i]);
            } else {  // For negative asteroids
                while(!st.empty() && st.back() > 0 && st.back() < abs(arr[i])) {
                    st.pop_back();  // Pop smaller positive asteroids
                }
                
                if(!st.empty() && st.back() == abs(arr[i])) {
                    st.pop_back();  // Both asteroids explode
                } else if(st.empty() || st.back() < 0) {
                    st.push_back(arr[i]);  // Push negative asteroid if no conflict
                }
            }
        }
        return st;  // Return the resulting state of asteroids
    }
};
