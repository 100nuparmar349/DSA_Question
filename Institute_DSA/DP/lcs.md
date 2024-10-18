# 01
class Solution {
    public int solve(String a,String b,int i,int j){
        if(i<0 || j<0)return 0;
        if(a.charAt(i) == b.charAt(j)){
             return solve(a,b,i-1,j-1)+1;
        }
       
        return Math.max(solve(a,b,i-1,j),solve(a,b,i,j-1));
    }
    public int longestCommonSubsequence(String a, String b) {
        return solve(a,b,a.length()-1,b.length()-1);
    }
}

# Bottom Up

import java.util.Arrays;

class Solution {
    public int solve(String a, String b, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            dp[i][j] = solve(a, b, i - 1, j - 1,dp) + 1;
        } else {
            dp[i][j] = Math.max(solve(a, b, i - 1, j,dp), solve(a, b, i, j - 1,dp));
        }
        return dp[i][j];
    }

    public int longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(a, b, a.length() - 1, b.length() - 1, dp);
    }
}


# space optimization 
 // space optimization
        int[] prev=new int[n+1];
        for(int i=1;i<=m;i++){
            int [] curr=new int[n+1];
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                curr[j]=prev[j-1]+1;
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }

            }
            prev=curr;
        }
        return prev[n];
     


# space optimization
  // space optimization
        int[] dp=new int[n+1];
        int ans=0;
        for(int i=1;i<=m;i++){
            int curr=0;
            for(int j=1;j<=n;j++){
                if(curr<dp[j])
                curr=dp[j];
                else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[j]=curr+1;
                    ans=Math.max(ans,dp[j]);
                }
            }
        }
     return ans;