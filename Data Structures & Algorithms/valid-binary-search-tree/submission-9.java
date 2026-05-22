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
    public boolean validity = true;
    public boolean isValidBST(TreeNode root) {
        checkValidity(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return validity;
    }

    public void checkValidity(TreeNode root, int minVal, int maxVal) {
        if(root == null)
        {
            return;
        }
        
        if(!(root.val < maxVal && root.val > minVal))
        {
            validity = false;
            return;
        }

        checkValidity(root.left, minVal, root.val);
        checkValidity(root.right, root.val, maxVal);
    }
}
