/*
 Q.01   26. Remove Duplicates from Sorted Array

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

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

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

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
You are given a 0-indexed integer array nums and an integer k. Your task is to perform the following operation exactly k times in order to maximize your score:
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
 substract both array eachother and add this value with sum+=seats[i]+students[i];
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
*/