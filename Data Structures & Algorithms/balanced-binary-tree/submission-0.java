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
    public boolean balanceStatus = true;
    public boolean isBalanced(TreeNode root) {
        findHeight(root);
        return balanceStatus;        
    }

    //fn. to find Hieght of both child and return the max hieght 
    //and update status paralelly
    public int findHeight(TreeNode root) {

        if(root == null)
            return 0;
        
        int leftHeight = 1 + findHeight(root.left);
        int rightHeight = 1 + findHeight(root.right);

        if(Math.abs(rightHeight - leftHeight) > 1)
        {
            balanceStatus = false;
            return 0;
        }

        return Math.max(leftHeight, rightHeight);
        
    }
}
