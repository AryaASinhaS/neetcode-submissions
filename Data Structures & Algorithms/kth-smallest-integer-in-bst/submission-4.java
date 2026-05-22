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
    ArrayList<Integer> preOrder = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        /**
        create preorder traversal and store in a arraylist
        return k-1th element
        **/
        preOrderTraversal(root);
        return preOrder.get(k-1);
    }

    //code to compute preorder - L-R-Rt
    public void preOrderTraversal(TreeNode root)
    {
        if(root == null)
            return;
        
        if(root.left != null)
            preOrderTraversal(root.left);
        
        preOrder.add(root.val);

        if(root.right != null)
            preOrderTraversal(root.right);       
    }
}
