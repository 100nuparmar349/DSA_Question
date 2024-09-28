/*
 Q.01   26. Remove Duplicates from Sorted Array

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.


 class Solution {
    public int removeDuplicates(int[] nums) {
       int j=1;
       for(int i=1;i<nums.length;i++){
        if(nums[i]!=nums[i-1]){
            nums[j]=nums[i];
            j++;

        }
       }
       return j;
    }
}



Q.02 - 27. Remove Element

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.

class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}

Approach
suppose element is match the value we cannot do anything.


Q.03  :- 
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& arr) {
      
        // set<vector<int>>st;
        int n=arr.size();
          // check all possible triplets:

     // Brute Force 
    // Time complexity :- O(n3);

    // for (int i = 0; i < n; i++) {
    //     for (int j = i + 1; j < n; j++) {
    //         for (int k = j + 1; k < n; k++) {
    //             if (arr[i] + arr[j] + arr[k] == 0) {
    //                 vector<int> temp = {arr[i], arr[j], arr[k]};
    //                 sort(temp.begin(), temp.end());
    //                 st.insert(temp);
    //             }
    //         }
    //     }
    // }


// Better Solution

// Time Complexity :- O(n2)*log(m);
//   for (int i = 0; i < n; i++) {
//     set<int>hashset;
//         for (int j = i + 1; j < n; j++) {
//             int third=-(arr[i]+arr[j]);
//             if(hashset.find(third)!=hashset.end()){
//                 vector<int>temp={arr[i],arr[j],third};
//                 sort(temp.begin(),temp.end());
//                 st.insert(temp);
//             }
//             hashset.insert(arr[j]);
           
//         }
//     }



// Optimal solution
vector<vector<int>>ans;
sort(arr.begin(),arr.end());
for(int i=0;i<n;i++){
    if(i !=0 && arr[i]==arr[i-1])continue;
   

    int j=i+1;
    int k=n-1;
    while(j<k){
        int sum=arr[i]+arr[j]+arr[k];
        if(sum<0){
            j++;

        }else if(sum>0){
            k--;
        }else{
           vector<int> temp = {arr[i], arr[j], arr[k]};
           ans.push_back(temp);
                j++;
                k--;
                //skip the duplicates:
                while (j < k && arr[j] == arr[j - 1]) j++;
                while (j < k && arr[k] == arr[k + 1]) k--;
            
        }

    }
}

   //store the set elements in the answer:
    // vector<vector<int>> ans(st.begin(), st.end());
    return ans;
     
        
    }
};




Q.04 
2441. Largest Positive Integer That Exists With Its Negative

Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.

 

Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array

Approach 
we use mpp.find method  to get maxium of the array. the maximum are also present in negative.
if(mpp.find(-nums[i])!=mpp.end()){
            maxi=max(maxi,nums[i]);
          }


Q.05 
905. Sort Array By Parity
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.
Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Approach

  if(nums[i]%2==0){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            j++;
        }


Q.06 
922. Sort Array By Parity II
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
Return any answer array that satisfies this condition.
Example 1:
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


Approach
Run for loop and differentate even or odd value . or push in the vector.




Q.07 
350. Intersection of Two Arrays II
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Approach

sort the array and run while loop for checking to present the array in the second array
suppose if(a[i]<b[j])i++ else if (b[j]<a[i]) j++; else ans.push_back(a[i]);


Q.08
3074. Apple Redistribution into Boxes

You are given an array apple of size n and an array capacity of size m.
There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.
Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
Note that, apples from the same pack can be distributed into different boxes.

Example 1:
Input: apple = [1,3,2], capacity = [4,3,1,5,2]
Output: 2
Explanation: We will use boxes with capacities 4 and 5.
It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.


Approach

sum of apples 
Run one more loop 
give if condition if(sum<=0) return boxes 
every time decrease the capacity with sum and i start with the end.
every time increase the count boxes.
sum-=capacity[i];
boxes++;


Q.09
2656. Maximum Sum With Exactly K Elements 
You are given a 0-indexed integer array nums and an integer k.
 Your task is to perform the following operation exactly k times in order to maximize your score:
Select an element m from nums.
Remove the selected element m from the array.
Add a new element with a value of m + 1 to the array.
Increase your score by m.
Return the maximum score you can achieve after performing the operation exactly k times.
Example 1:
Input: nums = [1,2,3,4,5], k = 3
Approach
Find the maximum first after that perform AP formula.
    return k*(2*mx+k-1)/2;


Q.10
2144. Minimum Cost of Buying Candies With Discount
A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.
For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3, they can take the candy with cost 1 for free, but not the candy with cost 4.
Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy, return the minimum cost of buying all the candies.
Example 1:
Input: cost = [1,2,3]
Output: 5

Approach
1. sort the array
2. Run while loop and give condition i>=1 and sum with cost[i]+cost[i-1] or i-=3as.
3. Run one more loop give condition i>=0 so sum+=cost[i] or i--;
4. Return sum.

Q.11

2037. Minimum Number of Moves to Seat Everyone
There are n availabe seats and n students standing in a room. You are given an array seats of length n, where seats[i] is the position of the ith seat. You are also given the array students of length n, where students[j] is the position of the jth student.
You may perform the following move any number of times:
Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1 or x - 1)
Return the minimum number of moves required to move each student to a seat such that no two students are in the same seat.
Note that there may be multiple seats or students in the same position at the beginning.

Approach
 sort both array.
 substract both array eachother and add this value with sum+=seats[i]-students[i];
 return sum.

 Q.12 
 
976. Largest Perimeter Triangle

Given an integer array nums,
 return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
  If it is impossible to form any triangle of a non-zero area, return 0.

  Example 1:

Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.

Approach
Key Concepts:
Triangle Inequality Theorem: For three sides to form a valid
 triangle, the sum of the lengths of any two sides must be greater than the length of the remaining side. 
a+b>c
If this condition is met, a triangle with a non-zero area can be formed.


Q.13 
605. Can Place Flowers
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 
Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Approach 

1. Run for loop 
2. three zero contineously come so one flower will be planted 
3. Give another condition also suppose p counted two zero in the last so give if condition if(p==2 && arr.size()-1==i) so
n--;
4. p starting initailize with zero because the first start with zero


Q.14 
2149. Rearrange Array Elements by Sign
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
You should return the array of nums such that the the array follows the given conditions:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

Example 1:
Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]

Approach
Define i=0,j=1
positive integer come so i+=2 else j+=2.
and v[i]=nums[k]; same as v[j]=nums[k];


Q.15
3075. Maximize Happiness of Selected Children
You are given an array happiness of length n, and a positive integer k.
There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.
In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.
Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.
Example 1:
Input: happiness = [1,2,3], k = 2
Output: 4

Approach
1. sort the array
2. define value variable to store the happiness value value=arr[i]-count.
3. our value is greater than 0 so add with sum variable sum+=value;
3. every iteration count will be increase.
4. suppose count is greater than or equal k so break the iteration.



Q.16 
2789. Largest Element in an Array after Merge Operations

You are given a 0-indexed array nums consisting of positive integers.

You can do the following operation on the array any number of times:

Choose an integer i such that 0 <= i < nums.length - 1 and nums[i] <= nums[i + 1]. Replace the element nums[i + 1] with nums[i] + nums[i + 1] and delete the element nums[i] from the array.
Return the value of the largest element that you can possibly obtain in the final array.

 

Example 1:

Input: nums = [2,3,7,9,3]
Output: 21

1. push in another vector type of long long .
2. iteration with end of the array and check arr[i]<=arr[i+1] it true so arr[i]=arr[i]+arr[i+1];
3. return arr[0];


Q.17 
2870. Minimum Number of Operations to Make Array Empty

You are given a 0-indexed array nums consisting of positive integers.

There are two types of operations that you can apply on the array any number of times:

Choose two elements with equal values and delete them from the array.
Choose three elements with equal values and delete them from the array.
Return the minimum number of operations required to make the array empty, or -1 if it is not possible.

 

Example 1:

Input: nums = [2,3,3,2,2,4,2,3,4]
Output: 4

Approach

1. sort the array
2. Run for loop
3. in if condition count the frequency with same element.
4. check in else condition ans+=cnt/3; and if(cnt%3!=0) ans++;
5. suppose cnt is 1 so return -1;



Q.18 
1833. Maximum Ice Cream Bars
It is a sweltering summer day, and a boy wants to buy some ice cream bars.
At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 

Note: The boy can buy the ice cream bars in any order.

Return the maximum number of ice cream bars the boy can buy with coins coins.

You must solve the problem by counting sort.

Example 1:
Input: costs = [1,3,2,4,1], coins = 7
Output: 4

Approach
1. sort the array.
2. give if conditon coins is greater than costs[i].
3. every time decrease the coins by costs
4. and increase the ans++


Q.19 
2824. Count Pairs Whose Sum is Less than Target

Given a 0-indexed integer array nums of length n and an integer target,
 return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
 

Example 1:

Input: nums = [-1,1,2,3,1], target = 2
Output: 3


Q.20 
2460. Apply Operations to an Array
Solved
Easy
Topics
Companies
Hint
You are given a 0-indexed array nums of size n consisting of non-negative integers.

You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:

If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
After performing all the operations, shift all the 0's to the end of the array.

For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
Return the resulting array.

Note that the operations are applied sequentially, not all at once.
Example 1:
Input: nums = [1,2,2,1,1,0]
Output: [1,4,2,0,0,0]


Q.21 
 Move Zeroes To End

Given an unsorted array of integers, you have to move the array elements in a way such that all the zeroes are transferred to the end, and all the non-zero elements are moved to the front. The non-zero elements must be ordered in their order of appearance.

For example, if the input array is: [0, 1, -2, 3, 4, 0, 5, -27, 9, 0], then the output array must be:

[1, -2, 3, 4, 5, -27, 9, 0, 0, 0].

Expected Complexity: Try doing it in O(n) time complexity and O(1) space complexity. Here, ‘n’ is the size of the array.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2
7
2 0 4 1 3 0 28
5
0 0 0 0 1
Sample Output 1:
2 4 1 3 28 0 0
1 0 0 0 0

Approach
int j=0;
check the element is not equal to zeros so put on the j position and j increase
if(i!=j) arr[i]=0;

Q.22
 vector<int> sortByFreq(vector<int>& arr) {
        // Your code here
        map<int ,int>mpp;
        for(int i=0;i<arr.size();i++){
            mpp[arr[i]]++;
        }
          vector<pair<int, int>> v;
        for (auto it : mpp) {
            v.push_back({it.second, it.first});  // {frequency, element}
        }
        
         sort(v.begin(), v.end(), [&](pair<int, int>& a, pair<int, int>& b) {
            if (a.first == b.first) {
                return a.second < b.second;
            }
            return a.first > b.first;
        });
        
        vector<int> ans;
        for (auto x : v) {
            int f = x.first, el = x.second;
            for (int i = 0; i < f; i++) {
                ans.push_back(el);
            }
        }
        return ans;
        
    }

# 23

16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
class Solution {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int closet=Integer.MAX_VALUE;
      for(int i=0;i<nums.length-2;i++){
        int j=i+1;
        int k=nums.length-1;
       while(j<k){
        int current_sum=nums[i]+nums[j]+nums[k];
        if(Math.abs(current_sum-target)<Math.abs(closet-target)){
            closet=current_sum;
        }
        if(current_sum<target){
            j++;

            
        }else if(current_sum>target){
            k--;
        }else{
            return current_sum;
        }
       }
      }
      return closet;
    }
}

# 24 
1122. Relative Sort Array
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

Approach
 
 First array will be sorted according to the second array .
 Or remaining element sorted according to the sorting element.
 public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index=0;
        for(int j:arr2){
            for(int i=0;i<arr1.length;i++){
                if(j==arr1[i]){
                    int temp=arr1[index];
                    arr1[index]=arr1[i];
                    arr1[i]=temp;
                    index++;

                }
            }
        }
        for(int i=index;i<arr1.length;i++){
            for(int j=index;j<arr1.length-1;j++){
                if(arr1[j]>arr1[j+1]){
                    int temp=arr1[j];
                    arr1[j]=arr1[j+1];
                    arr1[j+1]=temp;
                }
            }

        }
        return arr1;
        
    }

# 25 

Third Largest.

class Solution {
    int thirdLargest(int arr[]) {
        // Your code here
        int largest=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
           if(arr[i]>largest){
               third=second;
               second=largest;
               largest=arr[i];
           }else if(arr[i]>=second && arr[i]<=largest){
               third=second;
               second=arr[i];
           }else if(arr[i]>=third && arr[i]<=second){
               third=arr[i];
           }
        }
        return third;
    }
}

*/


# 26 Rearrange Array Alternately
Difficulty: MediumAccuracy: 35.15%Submissions: 242K+Points: 4
Given a sorted array of positive integers. Your task is to rearrange the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.
Note: Modify the original array itself. Do it without using any extra space. You do not have to return anything.

Example 1:

Input:
n = 6
arr[] = {1,2,3,4,5,6}
Output: 6 1 5 2 4 3
  public static void rearrange(long arr[], int n){
        
        // Your code here
        long[] v=new long[n];
        int index=0;
        if(n==1)return;
        int n1=n;
       
       
        for(int i=0;i<n/2;i++){
            v[index]=arr[n-1-i];
            v[index+1]=arr[i];
            index+=2;
        }
        if(n%2!=0)v[n-1]=arr[n/2];
      for(int i=0;i<n1;i++){
          arr[i]=v[i];
      }
        
    }


# 27  Maximum Index
Difficulty: MediumAccuracy: 24.5%Submissions: 252K+Points: 4
Given an array arr of positive integers. The task is to return the maximum of j - i subjected to the constraint of arr[i] < arr[j] and i < j.

Examples:

Input: arr[] = [1, 10]
Output: 1
int maxIndexDiff(int[] a) {
        // Your code here
        int n=a.length;
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty() || a[st.peek()]<a[i]){
                st.push(i);
            }
        }
        int i=0;
        int mx=0;
        while(i<n && st.size()>0){
            if(a[i]>a[st.peek()]){
                i++;
            }else{
                mx=Math.max(st.peek()-i,mx);
                st.pop();
            }
            
        }
        return mx;
        
    }