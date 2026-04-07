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

    public boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        sameTreeCheck(p, q);
        return isSame;
    }

    public void sameTreeCheck(TreeNode p, TreeNode q) {

        if(p == null && q == null)
            return;
        else if(p == null || q == null)
        {
            isSame = false;
            return;
        }
        else
        {
            if(p.val != q.val)
            {
                isSame = false;
                return;
            }

            sameTreeCheck(p.left, q.left);
            sameTreeCheck(p.right, q.right);
        }       
    }
}
