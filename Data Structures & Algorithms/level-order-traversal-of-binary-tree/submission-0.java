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
    public List<List<Integer>> levelOrder(TreeNode root) {

        /**
        IP: Root Node
        OP: Level Order Traversal of the tree
        Edge Case: empty tree
        Approach : 
        Traverse current level and add the next level nodes to different AL
        Swap current level and next till no more nodes are left to look at
        **/

        if(root == null)
        {
            return new ArrayList<>();
        }

        ArrayList<TreeNode> currentLevel = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        currentLevel.add(root);

        while(!currentLevel.isEmpty())
        {
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            ArrayList<Integer> thisLevel = new ArrayList<>();

            for(TreeNode curr : currentLevel)
            {
                thisLevel.add(curr.val);
                if(curr.left != null)
                    nextLevel.add(curr.left);
                if(curr.right != null)
                    nextLevel.add(curr.right);
            }

            result.add(thisLevel);
            currentLevel = nextLevel;
        }
        return result;
    }
}
