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

    //fn to check validity
    public boolean checkValidityOfBST(TreeNode root, int minVal, int maxVal) {
        /**
        IP: Root of a tree
        OP: Boolean
        Edge Case: Empty tree
        Approach:
        Check for each node if it's valid and then iterate over left n ryt
        **/

        if(root == null)
            return true;
        else
        {
            if(!(minVal < root.val && root.val < maxVal))
                return false;
        }

        return (checkValidityOfBST(root.left, minVal, root.val) && 
                checkValidityOfBST(root.right, root.val, maxVal));
    }

    public boolean isValidBST(TreeNode root) {

        if(root == null)
            return true;
        int minVal = Integer.MIN_VALUE, maxVal = Integer.MAX_VALUE;
        return checkValidityOfBST(root, minVal, maxVal);        
    }
}
