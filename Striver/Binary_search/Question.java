/*
Q.01
 704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4

Approach

1.Intialize the two variable start=0 , end =n-1;
2. if(target>nums[mid]) low=mid+1, else high=mid-1.

Q.02 
Given a sorted array arr[] of size n without duplicates, and given a value x.
 Floor of x is defined as the largest element k in arr[] such that k is smaller than or equal to x. 
 Find the index of k(0-based indexing).

Examples

Input: n = 7, x = 0 arr[] = {1,2,8,10,11,12,19}
Output: -1

  int findFloor(vector<long long> &v, long long n, long long x) {

        // Your code here
        long long low=0,high=n-1;
        int ans=-1;
        while(low<=high){
           int mid=low+(high-low)/2;
           if(v[mid]==x){
               return mid;
           }else if(v[mid]>x){
               high=mid-1;
           }else{
               ans=max(ans,mid);
               low=mid+1;
           }
        }
        return ans;
    }

Approach
1. mid is less than or equal to k so ans will be intialize

Q.03

35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

1. check nums[mid]<target high=mid-1. else ans=mid, low=mid+1.


Q.04 
Problem statement
You're given a sorted array 'a' of 'n' integers and an integer 'x'.
Find the floor and ceiling of 'x' in 'a[0..n-1]'.
Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.
Example:
Input: 
n=6, x=5, a=[3, 4, 7, 8, 8, 10]   

Output:
4

Explanation:
The floor and ceiling of 'x' = 5 are 4 and 7, respectively

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 8
3 4 4 7 8 10
Sample Output 1 :
8 8
1. check if(arr[mid]>x) ceil=arr[mid] high=mid-1;
else floor=arr[mid] low=mid+1;

Q.05 

34. Find First and Last Position of Element in Sorted Array.
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int first=-1,last=-1;
       while(start<=end){
        int mid=start+(end-start)/2;
        if(target==nums[mid]){
            first=mid;
            end=mid-1;
        }
        if(target<=nums[mid]){
            end=mid-1;
        }else{
            start=mid+1;
        }

       }

       int low=0,high=nums.length-1;
       while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]==target){
            last=mid;
            low=mid+1;
        }
        if(target<nums[mid]){
            high=mid-1;
        }else{
            low=mid+1;
        }

       }

       int[] arr=new int[2];
       arr[0]=first;
       arr[1]=last;
        return arr;

    }
}


Q.06 
1539. Kth Missing Positive Number
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Return the kth positive integer that is missing from this array.
Example 1:
Input: arr = [2,3,4,7,11], k = 5
Output: 9

Approach
1. Define low=0, high=arr.size();
2. we play with the index in this question.
3. so check how many are missing simple to write formula if(arr[mid]-mid+1<k) low=mid+1.
else high=mid;

 */
