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
    public int countNodes(TreeNode root) {
        // if(root==null)return 0;
        // return 1+countNodes(root.left)+countNodes(root.right);

        if(root==null)return 0 ; 

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight==rightHeight){
            return (1<<(leftHeight+1))-1 + countNodes(root.right)+1;

        }else{
            return (1<<(rightHeight+1))-1 + countNodes(root.left)+1;
        }














        // if(root == null) return 0; 
        // if(root.left==null && root.right==null)return 0;
        // int count = 1 ; 
        // traverse(root.left, root.right);
        // return count ; 
        
    }

    public int height(TreeNode node){
        int height =-1;
        while(node!=null){
            height++;
            node=node.left;
        }
        return height;
    }
    // public void traverse(TreeNode left, TreeNode right){
    //     if(left.left==null || left.right==null)return ;
    //     if(right.left==null || right.right==null)return ;

    //     while(left!=null 
    //     || right!=null){
    //         count++;
    //         left=left.left;
    //         right = right.right;
    //         left= left.right;
    //         right  = right.left;
    //     }

        
    
}