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

    //build a tree
    public TreeNode buildTreeFunc(int[] preorder, int[] inorder, 
                              int ps, int pe, int is, int ie) {
        
        if( ps > pe || is > ie)
            return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = findIndexOfRootInInorder(inorder, root.val);
        int leftLength = rootIndex - is;
        root.left = buildTreeFunc(preorder, inorder, ps+1, ps + leftLength,
                                                 is, rootIndex - 1);
        
        int rightLength = ie - rootIndex;
        root.right = buildTreeFunc(preorder, inorder, ps + leftLength + 1, pe
                                                , rootIndex + 1, ie);

        return root;
    }

    public int findIndexOfRootInInorder(int[] inorder, int num)
    {
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == num)
                return i;
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeFunc(preorder, inorder, 0, preorder.length - 1,
                                                0, preorder.length -1);
    }
}
