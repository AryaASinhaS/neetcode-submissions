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
    public List<Integer> rightSideView(TreeNode root) 
    {
        /**
        first find level order traversal
        after that take the last element of the traversal for your answer
        **/

        List<Integer> rightView = new ArrayList<>();

        if(root == null)
            return rightView;

        ArrayList<TreeNode> currentLvl = new ArrayList<>();
        currentLvl.add(root);

        while(currentLvl.size() > 0)
        {
            ArrayList<TreeNode> nextLvl = new ArrayList<>();
            TreeNode lastNode = new TreeNode();
            for(TreeNode curr : currentLvl)
            {
                lastNode = curr;
                if(curr.left != null)
                    nextLvl.add(curr.left);
                if(curr.right != null)
                    nextLvl.add(curr.right);
            }
            rightView.add(lastNode.val);
            currentLvl = nextLvl;
        }
        return rightView;
    }
}
