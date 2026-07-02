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
    List<TreeNode> inorder = new ArrayList<>();
    int counter = 0;
    public void recoverTree(TreeNode root) 
    {
        //find inorder traversal
        inorder = findInorder(root);

        //swap
        swapWrongNodes();
    }

    public void swapWrongNodes()
    {
        //convert to integer array for values and sort it
        int[] nodesValue = new int[inorder.size()];

        for(int i = 0; i < inorder.size(); i++)
        {
            nodesValue[i] = inorder.get(i).val;
        }

        Arrays.sort(nodesValue);
        int temp = 0;
        for(int i = 0; i < inorder.size(); i++)
        {
            if(nodesValue[i] != inorder.get(i).val)
            {
                inorder.get(i).val = nodesValue[i];
            }
        }

    }

    public List<TreeNode> findInorder(TreeNode root)
    {
        if(root == null)
            return new ArrayList<>();
        
        if(root.left != null)
            findInorder(root.left);
        inorder.add(root);
        if(root.right != null)
            findInorder(root.right);

        return inorder;
    }
}