# 01 
198. House Robber
Solved
Medium
Topics
Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
class Solution {
    int solve(int[] nums,int n,int [] dp){
    if(n<0)return 0;
    if(dp[n]!=-1)return dp[n];
    int pick=solve(nums,n-2,dp)+nums[n];
    int notpick=solve(nums,n-1,dp);
    dp[n]=Math.max(pick,notpick);
    return dp[n];
    }
    public int rob(int[] nums) {
      int[] dp=new int[nums.length];
      Arrays.fill(dp,-1);
       return solve(nums,nums.length-1,dp);
    }
}

# bottom up dp
 int n=nums.length;
        if(n==1)return nums[0];
      int[] dp=new int[n];
    //    return solve(nums,nums.length-1,dp);
   // bottom up dp
    dp[0]=nums[0];
    dp[1]=Math.max(nums[0],nums[1]);
    for(int i=2;i<n;i++){
        int pick=dp[i-2]+nums[i];
        int notpick=dp[i-1];
        dp[i]=Math.max(pick,notpick);
    }
    return dp[n-1];

# space optimization
  public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
      int[] dp=new int[n];
    //    return solve(nums,nums.length-1,dp);
   // bottom up dp
    int a=nums[0];
    int b=Math.max(nums[0],nums[1]);
    for(int i=2;i<n;i++){
        int pick=a+nums[i];
        int notpick=b;
        int c=Math.max(pick,notpick);
        a=b;
        b=c;
    }
    return b;

    }


# 02 
213. House Robber II
Solved
Medium
Topics
Companies
Hint
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
class Solution {
    public int rob(int[] nums) {
           int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
      int[] dp=new int[n];
    //    return solve(nums,nums.length-1,dp);
   // bottom up dp
    int a=nums[0];
    int b=Math.max(nums[0],nums[1]);
    for(int i=2;i<n-1;i++){
        
        int c=Math.max(a+nums[i],b);
        a=b;
        b=c;
    }
    int x=nums[1];
    int y=Math.max(nums[1],nums[2]);
    for(int i=3;i<n;i++){
        int z=Math.max(x+nums[i],y);
        x=y;
        y=z;
    }
    return Math.max(b,y);
        }
}

# 03 
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
    public int solve(int i,int j,int m,int n){
        if(i==m || j==n)return 0;
        if(i==m-1 && j==n-1)return 1;
        return solve(i+1,j,m,n)+solve(i,j+1,m,n);
    }
    public int uniquePaths(int m, int n) {
        return solve(0,0,m,n);
    }
}

// optimize  Bottom up
class Solution {
    public int solve(int i,int j,int m,int n,int[][] dp){
        if(i==m || j==n)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        dp[i][j]= solve(i+1,j,m,n,dp)+solve(i,j+1,m,n,dp);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,m,n,dp);
    }
}


# top to Down 
class Solution {
   
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1)return 1;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)dp[0][0]=1;
                else{
                    int a=0,b=0;
                    if(i>0)a=dp[i-1][j];
                    if(j>0)b=dp[i][j-1];
                    dp[i][j]=a+b;
                }

            }
        }
        return dp[m-1][n-1];
    }
}


# 
class Solution {
   // 2D to 1D DP.
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1)return 1;
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
           int[] curr=new int[n];
           for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[j]=1;
                else{
                    int a=0,b=0;
                    if(i>0)a=prev[j];
                    if(j>0)b=curr[j-1];
                    curr[j]=a+b;
                }
           }
           prev=curr;
        }
        return prev[n-1];
       }
}

# optimize 
class Solution {
   // 2D to 1D DP.
    public int uniquePaths(int m, int n) {
       if(m==1 && n==1)return 1;
       int[] dp=new int[n];
       dp[0]=1;
       for(int i=0;i<m;i++){
        for(int j=1;j<n;j++){
            dp[j]+=dp[j-1];
        }
       }
       return dp[n-1];
       }
}

previous state calculated in bottom up approach so dp is not initalize with -1;