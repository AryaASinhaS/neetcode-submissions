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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + findDepth(root);
        
    }

    public int findDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int mxDepth = 0;
        
        if(root.left != null || root.right != null)
        {
            int leftDepth = 0, rightDepth = 0;
            if(root.left != null)
                leftDepth = findDepth(root.left) + 1;
            
            if(root.right != null)
                rightDepth = findDepth(root.right) + 1;
            
            mxDepth = Math.max(leftDepth, rightDepth);
        }
        return mxDepth ;
    }
}
