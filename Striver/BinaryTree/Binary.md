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

# 05 112. Path Sum

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
class Solution {
    public boolean check(TreeNode root,int target,int sum){
        if(root==null)return false;;
        sum+=root.val;
        if(root.left==null && root.right==null)return sum==target;
       return check(root.left,target,sum)||check(root.right,target,sum);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return check(root,targetSum,0);
    }
}


# 06 
Code
Testcase
Testcase
Test Result
671. Second Minimum Node In a Binary Tree
Solved
Easy
Topics
Companies
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
class Solution {
    public int mini(TreeNode root,int value){
        if(root==null) return -1;
        if(root.val>value)return root.val;
       int left= mini(root.left,value);
       int right= mini(root.right,value); 
        if(left==-1)return right;
        if(right==-1)return left;
        return Math.min(left,right);
    }
   
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer>ls=new ArrayList<>(); 
   return  mini(root,root.val);
    //   int value=ls.get(0);
    //   Collections.sort(ls);
    //   for(int i=0;i<ls.size();i++){
    //         if(value<ls.get(i))return ls.get(i);
    //   }
    //   return -1;
        
    }
}


# 07
111. Minimum Depth of Binary Tree
Easy
Topics
Companies
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
class Solution {
    public int depth(TreeNode root){
        if(root==null)return 0;
        int lh=depth(root.left);
        int rh=depth(root.right);
        if(root.left==null && root.right==null){
           return 1;
        }
        if(root.left==null){
            return 1+rh;
        }
        if(root.right==null){
            return 1+lh;
        }
        return Math.min(lh,rh)+1;
        
    }
    public int minDepth(TreeNode root) {
        return depth(root);
    }
}


# 08

class Solution {
    public void inorder(TreeNode root,ArrayList<Integer>result){
       if(root==null)
        return;
        inorder(root.left,result);
        if(root.left==null && root.right==null)
        {
           result.add(root.val);
        }
        inorder(root.right,result);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       ArrayList<Integer>v=new ArrayList<>();
       ArrayList<Integer>v1=new ArrayList<>();
        inorder(root1,v);
      inorder(root2,v1);
      if(v1.size()!=v.size())
      return false;
    
      if(v.equals(v1)==true){
        return true;
      }else{
        return false;
      }
   
    }
}

# 09 701. Insert into a Binary Search Tree
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 

Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
class Solution {
    public void  check(TreeNode root,int val){
        TreeNode newNode=new TreeNode(val);
        if(root==null)return;
        if(root.left==null && root.val>val){
            root.left=newNode;
        }else if(root.right==null && root.val<val){
            root.right=newNode;
        }
        if(root.val>val){
            check(root.left,val);
        }else{
            check(root.right,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
       TreeNode temp=new TreeNode(val);
       if(root==null)return temp;
         check(root,val);
         return root;
    }
}



# 10

230. Kth Smallest Element in a BST
Solved
Medium
Topics
Companies
Hint
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1
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
    public void value(TreeNode root,ArrayList<Integer>ans){
        if(root==null)return;
        ans.add(root.val);
        value(root.left,ans);
        value(root.right,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer>ans=new ArrayList<>();
        value(root,ans);
        Collections.sort(ans);
       
        return ans.get(k-1);
    }
}


# 11

 public TreeNode bstFromPreorder(int[] A) {
        return BST(A,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode BST(int[] A,int bound,int[] i){
        if(i[0]==A.length || A[i[0]]>bound)return null;
        TreeNode root=new TreeNode(A[i[0]++]);
        root.left=BST(A,root.val,i);
        root.right=BST(A,bound,i);
        return root;
    }

