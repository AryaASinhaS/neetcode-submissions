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
    public int mVal = -999, count = 0;

    public int countgoodNodes(TreeNode root, int maxVal) {

        if(root == null)
            return 0;
        
        if(root.val >= maxVal)
        {
            count++;
            maxVal = root.val;
        }

        countgoodNodes(root.left, maxVal);
        countgoodNodes(root.right, maxVal);
        return count;
    }
    public int goodNodes(TreeNode root) {        
        countgoodNodes(root, mVal);
        return count;
    }
}
