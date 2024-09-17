/*
# Q.01
 704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4

Approach

1.Intialize the two variable start=0 , end =n-1;
2. if(target>nums[mid]) low=mid+1, else high=mid-1.

# Q.02 
Given a sorted array arr[] of size n without duplicates, and given a value x.
 Floor of x is defined as the largest element k in arr[] such that k is smaller than or e# Qual to x. 
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
1. mid is less than or e# Qual to k so ans will be intialize

# Q.03

35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

1. check nums[mid]<target high=mid-1. else ans=mid, low=mid+1.


# Q.04 
Problem statement
You're given a sorted array 'a' of 'n' integers and an integer 'x'.
Find the floor and ceiling of 'x' in 'a[0..n-1]'.
Note:
Floor of 'x' is the largest element in the array which is smaller than or e# Qual to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or e# Qual to 'x'.
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

# Q.05 

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


# Q.06 
1539. Kth Missing Positive Number
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Return the kth positive integer that is missing from this array.
Example 1:
Input: arr = [2,3,4,7,11], k = 5
Output: 9

Approach
1. Define low=0, high=arr.size();
2. we play with the index in this # Question.
3. so check how many are missing simple to write formula if(arr[mid]-mid+1<k) low=mid+1.
else high=mid;


# Q.07
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int low=1,n=nums.size(), high=n-2;
             if (n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            if(mid%2==1 && nums[mid]==nums[mid-1]  || mid%2==0 && nums[mid]==nums[mid+1]  ){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
};


# # Q.08

374. Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is e# Qual to the number I picked (i.e. num == pick).
Return the number that I picked.

 

Example 1:

Input: n = 10, pick = 6
Output: 6


 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);


 class Solution {
    public:
        int guessNumber(int n) {
             int start = 1;
            int end = n;
           
            int answer = 0;
            while(start <= end)
            {
               int mid = start + (end - start) / 2;
                if(guess(mid) == -1)
                {
                    end = mid - 1;
                }
                else if(guess(mid) == 1)
                {
                    start = mid + 1;
                }
                else if(guess(mid) == 0)
                {
                    answer = mid;
                    break;
                }
    
            }
            return answer;
            
        }
    };
 */


# Q.09 Allocate Minimum Pages
You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Input: n = 4, arr[] = [12, 34, 67, 90], m = 2
Output: 113



import java.util.*;

public class Main {
    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);
    }
}

