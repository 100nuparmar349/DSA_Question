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