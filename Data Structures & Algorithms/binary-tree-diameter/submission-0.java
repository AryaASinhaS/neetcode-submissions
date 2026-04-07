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
    public int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        returnMaxDepthAndUpdateMaxDiameter(root);
        return maxDiameter;        
    }

    public int returnMaxDepthAndUpdateMaxDiameter(TreeNode root) {

        if(root == null)
            return 0;
        
        int leftDepth = returnMaxDepthAndUpdateMaxDiameter(root.left);
        int rightDepth = returnMaxDepthAndUpdateMaxDiameter(root.right);

        maxDiameter = Math.max(maxDiameter, (leftDepth + rightDepth));
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
