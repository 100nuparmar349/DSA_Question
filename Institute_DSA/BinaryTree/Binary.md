# 01 

144. Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.

ample 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

class Solution {
    public void solve(TreeNode root,List<Integer>ans){
        if(root==null)return; 
        ans.add(root.val);
        solve(root.left,ans);
        solve(root.right,ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        solve(root,ans);
        return ans;
        
    }
}


# 02 

Code
Testcase
Testcase
Test Result
94. Binary Tree Inorder Traversal
Solved
Easy
Topics
Companies
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]
class Solution {
     public void solve(TreeNode root,List<Integer>ans){
        if(root==null)return; 
       
        solve(root.left,ans);
         ans.add(root.val);
        solve(root.right,ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        solve(root,ans);
        return ans;
    
    }
}



# 03 
145. Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]
class Solution {
     public void solve(TreeNode root,List<Integer>ans){
        if(root==null)return; 
      
        solve(root.left,ans);
        solve(root.right,ans);
          ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer>ans=new ArrayList<>();
        solve(root,ans);
        return ans;
        
        
    }
}



# 04 
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void solve(TreeNode root,List<List<Integer>>ans,int level){
        if(root==null)return;
        if(ans.size()==level)ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        solve(root.left,ans,level+1);
        solve(root.right,ans,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(root,ans,0);
        return ans;
    }
}

# 05 103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
class Solution {
  
      public void solve(TreeNode root,List<List<Integer>>ans,int level){
        if(root==null)return;
        if(ans.size()==level)ans.add(new ArrayList<>());
       if(level%2==0){
         ans.get(level).add(root.val);
       }else{
         ans.get(level).add(0,root.val);
       }
        solve(root.left,ans,level+1);
        solve(root.right,ans,level+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>>ans=new ArrayList<>();
        
        solve(root,ans,0);
        //   for (int i=0;i<ans.size();i++) {
        //     if (i%2!= 0) {
        //         Collections.reverse(ans.get(i));
        //     }
        // }
        return ans;

        
    }
}

# Question 
1. 101
2. 226
3. 112

# 06   101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean solve(TreeNode n1,TreeNode n2){
        if(n1==null && n2==null)return true;
        if(n1==null || n2==null)return false;
        return n1.val==n2.val && solve(n1.left,n2.right)&&solve(n1.right,n2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(solve(root.left,root.right)){
            return true;
        }else{
            return false;
        }S
    }
}