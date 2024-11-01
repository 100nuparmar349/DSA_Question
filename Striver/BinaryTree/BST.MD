#  01 FIND CEIL VALUE
   
    int findCeil(Node root, int key) {
       int ceil=-1;
       while(root!=null){
           if(root.data==key){
               return root.data;
           }
           if(key>root.data){
               root=root.right;
           }else{
               ceil=root.data;
               root=root.left;
           }
          
       }
       
       return ceil;
    }



# 02 
  public static int floor(Node root, int key) {
        // Code ere
         int floor=-1;
       while(root!=null){
           if(root.data==key){
               return root.data;
           }
           if(key<root.data){
               root=root.left;
           }else{
               floor=root.data;
               root=root.right;
           }
          
       }
       
       return floor;
    }

# 03 
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(root.val==key)return helper(root);
        TreeNode dummy=root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }else{
                    root=root.right;
                }
            }
        }
        return dummy;

    }
    public TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            TreeNode rightchild=root.right;
            TreeNode lostright=findRight(root.left);
            lostright.right=rightchild;
            return root.left;
        }

    }
    public TreeNode findRight(TreeNode root){
        if(root.right==null){
            return root;
        }
        return findRight(root.right);
    }
}

# 04 
98. Validate Binary Search Tree
Solved
Medium
Topics
Companies
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:
class Solution {
    public boolean valid(TreeNode root,long minvalue,long maxvalue){
        if(root==null)return true;
        if(root.val>=maxvalue || root.val<=minvalue)return false;
        return valid(root.left,minvalue,root.val) && valid(root.right,root.val,maxvalue);
    }
    public boolean isValidBST(TreeNode root) {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
}
