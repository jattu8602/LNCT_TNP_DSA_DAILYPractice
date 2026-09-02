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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0 ; 
        int sum = 0 ; 
        if(isleft(root.left))sum+=root.left.val;

        sum+=sumOfLeftLeaves(root.left);
        sum+=sumOfLeftLeaves(root.right);

        return sum;
        
        
    }
    public boolean isleft(TreeNode node){
        if(node==null)return false;
        return node.left==null && node.right == null;

    }
}