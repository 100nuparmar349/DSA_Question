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