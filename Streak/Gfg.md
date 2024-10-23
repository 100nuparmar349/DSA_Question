# 01 Largest Pair Sum
Difficulty: EasyAccuracy: 69.64%Submissions: 8K+Points: 2
Find the largest pair sum in an array of distinct integers.

Examples :

Input: arr[] = [12, 34, 10, 6, 40]
Output: 74
Explanation: Sum of 34 and 40 is the largest, i.e, 34 + 40 = 74.
  public static int pairsum(int[] arr) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        return arr[n-1]+arr[n-2];
    }

# 2 

# 03 Subarray range with given sum
Difficulty: MediumAccuracy: 42.21%Submissions: 42K+Points: 4
Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value.

Examples:

Input: arr[] = [10, 2, -2, -20, 10] , tar = -10
Output: 3
Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
  int ans  =0;int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int ele:arr){
            sum += ele;
            if(map.containsKey(sum - tar)) ans += map.get(sum -tar);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;



#  04 Split Linked List Alternatingly
Difficulty: EasyAccuracy: 42.46%Submissions: 18K+Points: 2
Given a singly linked list's head. Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller lists. The sublists should be made from alternating elements from the original list.
Note: 

The sublist should be in the order with respect to the original list.
Your have to return an array containing the both sub-linked lists.
  Node h1 = head;
        Node temp = head;
        Node [] ans = new Node[2];
        if(head.next  == null){
            ans[0] = head;
            return ans;
        }
        Node h2 = head.next;
        ans[0] = h1;
        ans[1] = h2;
        while(h1.next != null && h1.next.next != null){
            h1.next = h1.next.next;
            h2.next = h2.next.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        h1.next = null;
        return ans;


# 05 Single Number
Difficulty: EasyAccuracy: 41.64%Submissions: 30K+Points: 2
Given an array arr[] of positive integers where every element appears even times except for one. Find that number occurring an odd number of times.

Examples:

Input: arr[] = [1, 1, 2, 2, 2]
Output: 2
Explanation: In the given array all element appear two times except 2 which appears thrice.
class Solution {
    int getSingle(int arr[]) {
        // code here
        int cnt=1;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                cnt++;
            }else{
                if(cnt%2!=0)return arr[i];
                cnt=1;
            }
        }
     return cnt%2!=0?arr[arr.length-1]:-1;
    }
}


# 06
A string str is given to represent a positive number. The task is to round str to the nearest multiple of 10.  If you have two multiples equally apart from str, choose the smallest element among them.

Examples:

Input: str = 29 
Output: 30
Explanation: Close multiples are 20 and 30, and 30 is the nearest to 29. 
  public:
    string roundToNearest(string str) {
       int last=str.back()-'0';
       int n=str.length();
       if(last<=5){
           str.back()='0';
       }else{
           str.back()='0';
           for(int i=n-2;i>=0;i--){
               if(str[i]=='9'){
                   str[i]='0';
               }else{
                   str[i]++;
                   return str;
               }
           }
           str='1'+str;
       }
       return str;
    }
};



# 07 Split the Array
Difficulty: EasyAccuracy: 54.99%Submissions: 14K+Points: 2
Given an array arr[] of integers, the task is to count the number of ways to split given array elements into two non-empty subsets such that the XOR of elements of each group is equal. Each element should belong to exactly one subset.
Note:

The answer could be very large so print it by doing modulo with 109 + 7. 
Subsets with the same elements but derived from different indices are different.
Examples:

Input : arr[] = [1, 2, 3]
Output : 3
Explanation: {(1),(2, 3)}, {(2),(1, 3)}, {(3),(1, 2)} are three ways with equal XOR value of two groups.
 int countgroup(vector<int>& arr) {
        // Complete the function
         int x=0;
        for(auto it:arr)
            x^=it;
        
        return x==0?(1<<(arr.size()-1))-1:0;
    }


# 08  Sub-arrays with equal number of occurences
Given an array arr[] and two integers say, x and y, find the number of sub-arrays in which the number of occurrences of x is equal to the number of occurrences of y.

Examples:

Input: arr[] = [1, 2, 1] , x= 1 , y = 2
Output: 2
Explanation: The possible sub-arrays have same equal number of occurrences of x and y are:
1) [1, 2], x and y have same occurrence(1).
2) [2, 1], x and y have same occurrence(1).
 int sameOccurrence(vector<int>& arr, int x, int y) {
        // code here
         unordered_map<int,int>mp;
        int one =0;
        int two = 0;
        mp[0]=1;
        int cnt =0;
        for(auto ele:arr){
            if(ele == x)one++;
            if(ele == y)two++;
            cnt+=mp[one-two];
            mp[one-two]++;
        }
        return cnt;
    }


# 09 Find the Sum of Last N nodes of the Linked List
Difficulty: EasyAccuracy: 61.47%Submissions: 45K+Points: 2
Given a single linked list, calculate the sum of the last n nodes.

Note: It is guaranteed that n <= number of nodes.

Examples:

Input: Linked List: 5->9->6->3->4->10, n = 3

Output: 17
Explanation: The sum of the last three nodes in the linked list is 3 + 4 + 10 = 17.
    public int sumOfLastN_Nodes(Node head, int n) {
        // write code here
        Node slow=head;
        Node fast=head;
        int sum=0;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        while(slow!=null){
            sum+=slow.data;
            slow=slow.next;
        }
        return sum;
    
    }