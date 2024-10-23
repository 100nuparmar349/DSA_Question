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

# 07 257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
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
  public void path(TreeNode root,List<String>ans,String s){
    if(root==null)return;
     if(root.left==null && root.right==null){
        ans.add(s+root.val);
        return ;
        }
     if(root.left!=null)path(root.left,ans,s+root.val+"->");
       if(root.right!=null)path(root.right,ans,s+root.val+"->");

        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans=new ArrayList<>();
        String s="";
        path(root,ans,s);
        return ans;
    }
}

# 07 levelOrder Traversal
 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        // solve(root,ans,0);
        // return ans;
        Queue<TreeNode>q=new ArrayDeque<>();
        if(root==null)return ans;
       q.add(root);
       while(!q.isEmpty()){
        List<Integer>li=new ArrayList<>();
        int size=q.size();
        for(int i=0;i<size;i++){
            TreeNode x=q.remove();
            li.add(x.val);
            if(x.left!=null)q.add(x.left);
            if(x.right!=null)q.add(x.right);
        }
        ans.add(li);
       }
       return ans;
    }


# 08 Morris Traversal
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
     public void solve(TreeNode root,List<Integer>ans){
        if(root==null)return; 
       
        solve(root.left,ans);
         ans.add(root.val);
        solve(root.right,ans);
    }
    public void morris(TreeNode root,List<Integer>ans){
        TreeNode curr=root;// Step :- 1
        while(curr!=null){
            // Step :- 2
            if(curr.left==null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
                // Step :- 3
                TreeNode p=curr.left;
                while(p.right!=null && p.right!=curr){
                    p=p.right;
                }
                // Step :- 4
                if(p.right==null){
                    p.right=curr;
                    curr=curr.left;
                }else{
                    // Step :- 5
                    p.right=null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        // solve(root,ans);
        // return ans;
        morris(root,ans);
        return ans;
    
    }
}


# 09 199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
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
    public void value(TreeNode root,List<Integer>ans,int level){
        if(root==null)return;
       if(level==ans.size())
           ans.add(root.val);
       
        value(root.right,ans,level+1);
        value(root.left,ans,level+1);
       
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        value(root,ans,0);
        return ans;
        
    }
}

# 10 235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val)return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val)return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}



# 11  108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced
 binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length-1);
    }
    public TreeNode create(int[] nums,int start,int end){
        if(start>end)return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=create(nums,start,mid-1);
        root.right=create(nums,mid+1,end);
        return root;
    }
}


# 12  700. Search in a Binary Search Tree

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
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

   
     public TreeNode check(TreeNode root ,int val){
        if(root==null || root.val==val)return root;
        if(root.val>val)return check(root.left,val);
        else return check(root.right,val);
       
     
       
    }
    public TreeNode searchBST(TreeNode root, int val) {
       return check(root,val);
    
    }
}