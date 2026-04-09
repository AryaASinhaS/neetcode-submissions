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

    //fn to arrange all elements in ascending order of a BST
    ArrayList<Integer> allElements = new ArrayList<>();
    public void arrangeElements(TreeNode root)
    {
        if(root == null)
            return;
        
        arrangeElements(root.left);
        allElements.add(root.val);
        arrangeElements(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        arrangeElements(root);
        return allElements.get(k-1);
    }
}
