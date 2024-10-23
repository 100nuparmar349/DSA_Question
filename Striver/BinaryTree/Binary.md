# 01 104. Maximum Depth of Binary Tree
class Solution {
    int maxdepth(TreeNode root){
        if(root==null)return 0;
        int lh=maxdepth(root.left);
        int rh=maxdepth(root.right);
        return 1+Math.max(lh,rh);
    }
    public int maxDepth(TreeNode root) {
        return maxdepth(root);

    }
}


# 02 Height Balanced Binary Tree.

class Solution { 
    public int maximum(TreeNode root){
        if(root==null)return 0;
        int lh=maximum(root.left);
        int rh=maximum(root.right);
        if(lh==-1 || rh==-1)return -1;
        if(Math.abs(lh-rh)>1)return -1;
        return Math.max(lh,rh)+1;

    }
    public boolean isBalanced(TreeNode root) {
      if(maximum(root)==-1)return false;
      return true;
    }
}


# 03 543. Diameter of Binary Tree
Solved
Easy
Topics
Companies
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
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
    public int findmax(TreeNode root,int[] maxi){
        if(root==null)return 0;
        int lh=findmax(root.left,maxi);
        int rh=findmax(root.right,maxi);
        maxi[0]=Math.max(maxi[0],lh+rh);
    return 1+Math.max(lh,rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi=new int[1];
       findmax(root,maxi);
       return maxi[0];
    }
}

# 04 404. Sum of Left Leaves

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
    public void check(TreeNode root,int[] sum){
      if(root==null)return;
      
      if(root.left!=null && root.left.left==null && root.left.right==null)sum[0]+=root.left.val;
        check(root.left,sum);
        check(root.right,sum);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum=new int[1];
        check(root,sum);
        return sum[0];
        
    }