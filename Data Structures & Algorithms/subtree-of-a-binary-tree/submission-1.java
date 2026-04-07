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


    //fn to check if two trees are identical
    public boolean isTreeIdentical(TreeNode p, TreeNode q) 
    {
        if(p == null && q == null)
        {
            return true;
        }
        else if(p == null || q == null)
        {
            return false;
        }
        else if(p.val != q.val)
        {
            return false;
        } 
        else
            return (isTreeIdentical(p.left, q.left) &&
                    isTreeIdentical(p.right, q.right));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null)
        {
            return true;
        }
        if(root == null || subRoot == null)
        {
            return false;
        }

        return (isTreeIdentical(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}
