# 01 1331. Rank Transform of an Array


Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
 

Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.


class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        map<int,int>mpp;
        vector<int>v(arr);
        sort(v.begin(),v.end());
        int rank=1;
        for(int i=0;i<v.size();i++){
            if(mpp.find(v[i])!=mpp.end()){
                continue;
            }else{
                 mpp[v[i]]=rank;
                 rank++;
            }
           
        }
        for(int i=0;i<arr.size();i++){
            arr[i]=mpp[arr[i]];
        }
        return arr;
    }
};


# 02 2491. Divide Players Into Teams of Equal Skill

You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.

The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.
Example 1:
Input: skill = [3,2,5,1,3,4]
Output: 22
Explanation: 
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.

 public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum=0;
        int n=skill.length;
        int prev=(skill[0]+skill[n-1]);
        for(int i=0;i<n/2;i++){
            if(prev!=skill[i]+skill[n-1-i])return -1;
            sum+=(long)(skill[i]*skill[n-i-1]);
        }
        return sum;
    }

# 03 567. Permutation in String
Given two strings s1 and s2, return true if s2 contains a 
permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
class Solution {
public:

    bool checkInclusion(string s1, string s2) {
        int n = s1.size(), m = s2.size();
        
        if (n > m) return false;
        
        vector<int> s1_count(26, 0),s2_count(26, 0);
        
        for (int i = 0; i < n; i++) {
            s1_count[s1[i] - 'a']++;
            s2_count[s2[i] - 'a']++;
        }
        
        if (s1_count == s2_count) return true;
        
        for (int i = n; i < m; i++) {
            s2_count[s2[i] - 'a']++;
            s2_count[s2[i - n] - 'a']--;
            
            if (s1_count == s2_count) return true;
        }
        
        return false;
    }
};



# 04 1813. Sentence Similarity III

You are given two strings sentence1 and sentence2, each representing a sentence composed of words. A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of only uppercase and lowercase English characters.

Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be separated from existing words by spaces.

For example,

s1 = "Hello Jane" and s2 = "Hello my name is Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in s1.
s1 = "Frog cool" and s2 = "Frogs are cool" are not similar, since although there is a sentence "s are" inserted into s1, it is not separated from "Frog" by a space.
Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.


var areSentencesSimilar = function(sentence1, sentence2) {
    let words1=sentence1.split(' ');
    let words2=sentence2.split(' ');
    let n1=words1.length,n2=words2.length;
    let start=0,end=0;
    while(start<n2 && words1[start]===words2[start])start++;
     while (end < n2 && words1[n1 - end - 1] == words2[n2 - end - 1]) end++;
     return (start+end>=n2 || start+end>=n1);
    
};


# 05 2696. Minimum String Length After Removing Substrings
You are given a string s consisting only of uppercase English letters.

You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.

Return the minimum possible length of the resulting string that you can obtain.

Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.

 

Example 1:

Input: s = "ABFCACDB"
Output: 2
class Solution {
public:
    int minLength(string s) {
       int i=0;
       while(i<s.length()){
        if(s.substr(i,2)=="AB" || s.substr(i,2)=="CD"){
            s.erase(i,2);
            i=0;
        }else{
            i++;
        }  
       }
       return s.length();
        
    }
};


# 06 1963. Minimum Number of Swaps to Make the String Balanced

You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
A string is called balanced if and only if:
It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.

 

Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
class Solution {
public:
    int minSwaps(string s) {
        int  cnt=0;
        int n=s.length();
        for(int i=0;i<n;i++){
          if(s[i]=='['){
            cnt++;
          }else if(cnt>0){
            cnt--;
          }
        } 
        return( cnt+1)/2;
    }
};


# 07 962. Maximum Width Ramp
A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.

 
class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        stack<int>st;
        int result=0;
        for(int i=0;i<nums.size();i++){
            if(st.empty() || nums[st.top()]>nums[i]){
                st.push(i);
            }
        }
    for(int j=nums.size()-1;j>=0;j--){
        while(!st.empty() && nums[st.top()]<=nums[j]){
            result=max(result,j-st.top());
            st.pop();
        }
    }
    return result;
        
    }
};


# 08  2406. Divide Intervals Into Minimum Number of Groups

You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.

 

Example 1:

Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        vector<int>start,end;
        for(auto i:intervals){
            start.push_back(i[0]);
            end.push_back(i[1]);
        }
        sort(start.begin(),start.end());
         sort(end.begin(),end.end());
         int i=0,group=0;
         for(int s:start){
            if(s>end[i])
            i++;
            else group++;
         }
         return group;
    
    } 
};


# 09  2938. Separate Black and White Balls

There are n balls on a table, each ball has a color black or white.

You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.

In each step, you can choose two adjacent balls and swap them.

Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.

 

Example 1:

Input: s = "101"
Output: 1
class Solution {
public:
    long long minimumSteps(string s) {
        // Brute Force
        //     long long ans=0; 
        // for(int i=1;i<s.length();i++){
        //     char x=s[i];
        //     int j=i-1;
        //     while(j>=0 && s[j]>x){
        //         s[j+1]=s[j];
        //         j--;
        //         ans++;
        //     }
        //     s[j+1]=x;
        // }
        // return ans;
        long long ans=0;
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='0'){
                ans+=one;
            }else{
                one++;
            }
        }
        return ans;
    }
};


# 10 1405. Longest Happy String

A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        vector<pair<int, char>> counts = {{a, 'a'}, {b, 'b'}, {c, 'c'}};
        string result = "";
        
        while (true) { 
            sort(counts.rbegin(), counts.rend());
            bool added = false;
            for (int i = 0; i < 3; ++i) {
                if (counts[i].first == 0) break;  
                
                int len = result.size();
                // Avoid adding more than two consecutive characters
                if (len >= 2 && result[len - 1] == counts[i].second && result[len - 2] == counts[i].second) {
                    continue;
                }
                
                // Add the character
                result += counts[i].second;
                counts[i].first--;
                added = true;
                break;
            }
            
            // If no character could be added, we're done
            if (!added) break;
        }
        
        return result;
    }
};


# 11

Code
Testcase
Testcase
Test Result
670. Maximum Swap
Solved
Medium
Topics
Companies
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

 

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.
class Solution {
public:
    int maximumSwap(int num) {
     string s=to_string(num);
     int cnt=1;
     for(int i=0;i<s.length();i++){
        int index=i;
        char ch=s[i];
        for(int j=i+1;j<s.length();j++){
            if(ch<=s[j] ){
               index=j;
               ch=s[j];
            }
        }
         if (s[i]<s[index]) {
                swap(s[i], s[index]);
                break;
            }
     }
 
   return stoi(s);


        
    }
};



# 12 2044. Count Number of Maximum Bitwise-OR Subsets
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).

 

Example 1:

Input: nums = [3,1]
Output: 2
Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]
class Solution
{
public:
    void backtrack(const vector<int> &nums, int index, int currentOR, int maxOR, int &count)
    {
        if (currentOR == maxOR)
        {
            count++;
        }

        for (int i = index; i < nums.size(); ++i)
        {
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }

    int countMaxOrSubsets(vector<int> &nums)
    {
        int maxOR = 0;

        // Step 1: Compute the maximum OR
        for (int num : nums)
        {
            maxOR |= num;
        }

        int count = 0;
        // Step 2: Backtrack to count the subsets
        backtrack(nums, 0, 0, maxOR, count);

        return count;
    }
};

# 13  2583. Kth Largest Sum in a Binary Tree

You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.

Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

Note that two nodes are on the same level if they have the same distance from the root.
Example 1:
Input: root = [5,8,9,2,1,3,7,4,6], k = 2
Output: 13
class Solution {
   
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long  sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            ans.add(sum);
        }
        if(k>ans.size())return -1;
    ans.sort(Collections.reverseOrder());
       return ans.get(k-1);
    }
}

# 14

Code
Testcase
Testcase
Test Result
2684. Maximum Number of Moves in a Grid
Medium
Topics
Companies
Hint
You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
Return the maximum number of moves that you can perform.

 

Example 1:


Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxMoves(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int maxMoves = 0;

        for (int col = n - 2; col >= 0; --col) {
            for (int row = 0; row < m; ++row) {
                if (row > 0 && grid[row][col] < grid[row - 1][col + 1]) {
                    dp[row][col] = max(dp[row][col], dp[row - 1][col + 1] + 1);
                }
                if (grid[row][col] < grid[row][col + 1]) {
                    dp[row][col] = max(dp[row][col], dp[row][col + 1] + 1);
                }
                if (row < m - 1 && grid[row][col] < grid[row + 1][col + 1]) {
                    dp[row][col] = max(dp[row][col], dp[row + 1][col + 1] + 1);
                }
            }
        }

        for (int row = 0; row < m; ++row) {
            maxMoves = max(maxMoves, dp[row][0]);
        }
        return maxMoves;
    }
};


# 15 
1957. Delete Characters to Make Fancy String
Solved
Easy
Topics
Companies
Hint
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.
Example 1:
Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
class Solution {
public:
    string makeFancyString(string s) {
      string ans="";
      ans.push_back(s[0]);
      int n=s.size(),cnt=1;
      for(int i=1;i<n;i++){
        if(s[i]==ans.back()){
            cnt++;
            if(cnt<3)ans.push_back(s[i]);
        }else{
            cnt=1;
            ans.push_back(s[i]);
        }
      }
      return ans;
    }
};